package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDto;

public class PredictionMapper {
    public static PredictionDto toPredictionDTO(Prediction prediction) {
        if(prediction == null) {
            return null;
        }

        PredictionDto predictionDTO = new PredictionDto();
        predictionDTO.setId(prediction.getId());
        predictionDTO.setGame_id(prediction.getGame().getId());
        predictionDTO.setHome_team(prediction.getHomeTeam());
        predictionDTO.setAway_team(prediction.getAwayTeam());
        predictionDTO.setHome_win_probability(prediction.getHomeTeamWinProbability());
        predictionDTO.setAway_win_probability(prediction.getAwayTeamWinProbability());

        return predictionDTO;
    }

    public static Prediction toPrediction(PredictionDto predictionDto) {
        if(predictionDto == null) {
            return null;
        }

        Prediction prediction = new Prediction();
        prediction.setHomeTeam(predictionDto.getHome_team());
        prediction.setAwayTeam(predictionDto.getAway_team());
        prediction.setHomeTeamWinProbability(predictionDto.getHome_win_probability());
        prediction.setAwayTeamWinProbability(predictionDto.getAway_win_probability());


        return prediction;
    }


}
