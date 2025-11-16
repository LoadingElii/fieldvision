package com.bkendbp.fieldsight.prediction.service;

import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.game.service.GameService;
import com.bkendbp.fieldsight.mapper.GameMapper;
import com.bkendbp.fieldsight.mapper.PredictionMapper;
import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDto;
import com.bkendbp.fieldsight.prediction.repository.PredictionRepository;
import com.bkendbp.fieldsight.webclient.PredictionServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PredictionService {
    private final PredictionRepository predictionRepository;
    private final PredictionServiceClient predictionServiceClient;
    private final GameService gameService;

    @Autowired
    public PredictionService(PredictionRepository predictionRepository,
                             PredictionServiceClient predictionServiceClient,
                             GameService gameService) {
        this.predictionRepository = predictionRepository;
        this.predictionServiceClient = predictionServiceClient;
        this.gameService = gameService;
    }

    public List<PredictionDto> getAllPredictions() {
        if(predictionRepository.findAll().isEmpty()) {
            saveAllPredictions();
        }
        return predictionRepository.findAll().stream().map(PredictionMapper::toPredictionDTO).toList();
    }
     private void saveAllPredictions(){
         List<Prediction> predictions = getAllPredictionsForGames();
         predictionRepository.saveAll(predictions);
     }

     public List<Prediction> getAllPredictionsForGames() {
         List<GameDto> allGames = gameService.getAllGames();
         List<Game> gamesEntities = allGames.stream().map(GameMapper::toGame).toList();

         Map<String, Game> games =
                 gamesEntities.stream().collect(Collectors.toMap(Game::getId, g -> g));

         List<PredictionDto> predictionDTOS = allGames.stream().
                 map(predictionServiceClient::getPredictionForGame).toList();

         return predictionDTOS.stream()
                 .map((pred) -> {
                     Prediction prediction = PredictionMapper.toPrediction(pred);
                     prediction.setGame(games.get(pred.getGame_id()));
                     return prediction;
                 }).toList();

     }

    public PredictionDto getPredictionById(String id) {
        Prediction prediction = predictionRepository.getPredictionById(id);
        return PredictionMapper.toPredictionDTO(prediction);
    }

    public void deletePrediction(Prediction prediction) {
        predictionRepository.delete(prediction);
    }
}
