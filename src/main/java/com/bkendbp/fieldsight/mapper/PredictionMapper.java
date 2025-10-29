package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDTO;

public class PredictionMapper {
    public static PredictionDTO toPredictionDTO(Prediction prediction) {
        if(prediction == null) {
            return null;
        }

        PredictionDTO predictionDTOFromPrediction = new PredictionDTO();
        predictionDTOFromPrediction.setPrediction_id(prediction.getId());
        predictionDTOFromPrediction.setHome_team(prediction.getHomeTeam());
        predictionDTOFromPrediction.setAway_team(prediction.getAwayTeam());
        predictionDTOFromPrediction.setHome_win_probability(prediction.getHomeTeamWinProbability());
        predictionDTOFromPrediction.setAway_win_probability(prediction.getAwayTeamWinProbability());

        return predictionDTOFromPrediction;
    }

    public static Prediction toPrediction(PredictionDTO predictionDto) {
        if(predictionDto == null) {
            return null;
        }

        Prediction predictionFromPredictionDTO = new Prediction();
        predictionFromPredictionDTO.setHomeTeam(predictionDto.getHome_team());
        predictionFromPredictionDTO.setAwayTeam(predictionDto.getAway_team());
        predictionFromPredictionDTO.setHomeTeamWinProbability(predictionDto.getHome_win_probability());
        predictionFromPredictionDTO.setAwayTeamWinProbability(predictionDto.getAway_win_probability());


        return predictionFromPredictionDTO;
    }


}
