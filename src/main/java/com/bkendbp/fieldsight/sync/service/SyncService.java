package com.bkendbp.fieldsight.sync.service;

import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.service.GameService;
import com.bkendbp.fieldsight.history.model.History;
import com.bkendbp.fieldsight.history.service.HistoryService;
import com.bkendbp.fieldsight.mapper.PredictionMapper;
import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDto;
import com.bkendbp.fieldsight.prediction.service.PredictionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SyncService {
    private final GameService gameService;
    private final PredictionService predictionService;
    private final HistoryService historyService;

    public SyncService(GameService gameService,
                       PredictionService predictionService,
                       HistoryService historyService) {
        this.gameService = gameService;
        this.predictionService = predictionService;
        this.historyService = historyService;
    }

    public void archivePastGames() {
       List<Game> pastGames = gameService.getAllPastGames();
       for (Game game: pastGames) {
           PredictionDto predictionDto = predictionService.getPredictionByGameId(game.getId());
           Prediction prediction = PredictionMapper.toPrediction(predictionDto);
           History history = createHistoryFromPastGameAndPrediction(game, prediction);
           historyService.saveHistoricalGame(history);
           deletePastGame(game);
           deletePastPrediction(prediction);
       }
    }

    private void deletePastGame(Game game) {
        gameService.deleteGame(game);
    }

    private void deletePastPrediction(Prediction prediction) {
        predictionService.deletePrediction(prediction);
    }


    private History createHistoryFromPastGameAndPrediction(Game game, Prediction prediction) {
        History historyRecord = new History();
        historyRecord.setHomeTeam(game.getHomeTeam());
        historyRecord.setAwayTeam(game.getAwayTeam());
        historyRecord.setHomeScore(game.getHomeScore());
        historyRecord.setAwayScore(game.getAwayScore());
        historyRecord.setHomeWinProbability(prediction.getHomeTeamWinProbability());
        historyRecord.setAwayWinProbability(prediction.getAwayTeamWinProbability());

        return historyRecord;
    }
}
