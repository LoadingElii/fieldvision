package com.bkendbp.fieldsight.prediction.service;

import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.mapper.PredictionMapper;
import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDTO;
import com.bkendbp.fieldsight.prediction.repository.PredictionRepository;
import com.bkendbp.fieldsight.webclient.GameServiceClient;
import com.bkendbp.fieldsight.webclient.PredictionServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {
    private final PredictionRepository predictionRepository;
    private final PredictionServiceClient predictionServiceClient;
    private final GameServiceClient gameServiceClient;

    @Autowired
    public PredictionService(PredictionRepository predictionRepository,
                             PredictionServiceClient predictionServiceClient, GameServiceClient gameServiceClient) {
        this.predictionRepository = predictionRepository;
        this.predictionServiceClient = predictionServiceClient;
        this.gameServiceClient = gameServiceClient;
    }

    public List<PredictionDTO> getAllPredictions() {
        if(predictionRepository.findAll().isEmpty()) {
            getPredictionsFromClientAndSave();
        }
        return predictionRepository.findAll().stream().map(PredictionMapper::toPredictionDTO).toList();
    }
     private void getPredictionsFromClientAndSave(){
         List<GameDto> games = gameServiceClient.getAllGamesForWeek();
         List<PredictionDTO> predictionDTOS = games.stream().map(game ->
                 predictionServiceClient.getPredictionForGame(game.getHome_team(),
                         game.getAway_team())).toList();
         List<Prediction> predictions = predictionDTOS.stream().map(PredictionMapper::toPrediction).toList();
         predictionRepository.saveAll(predictions);
     }

    public Prediction getPredictionById(Long id) {
        return predictionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No prediction by: " + id + " exist."));
    }
}
