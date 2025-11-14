package com.bkendbp.fieldsight.mapper;


import com.bkendbp.fieldsight.history.model.History;
import com.bkendbp.fieldsight.history.model.HistoryDto;

public class HistoryMapper {

    public static HistoryDto toHistoryDto(History history) {
        if (history == null) {
            return null;
        }

        Double predictedWinner = getPredictedWinner(
                history.getPrediction().getHomeTeamWinProbability(),
                history.getPrediction().getAwayTeamWinProbability()
        );

        HistoryDto historyDto = new HistoryDto();
        historyDto.setHomeTeam(history.getHomeTeam());
        historyDto.setAwayTeam(history.getAwayTeam());
        historyDto.setHomeScore(history.getGame().getHomeScore());
        historyDto.setAwayScore(history.getGame().getAwayScore());
        historyDto.setHousePrediction(predictedWinner);

        return historyDto;
    }

    private static Double getPredictedWinner(Double homePossibility, Double awayPossibility) {
        if (homePossibility > awayPossibility) {
            return homePossibility;
        } else
            return awayPossibility;
    }
}
