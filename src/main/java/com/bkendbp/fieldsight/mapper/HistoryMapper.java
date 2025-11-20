package com.bkendbp.fieldsight.mapper;


import com.bkendbp.fieldsight.history.model.History;
import com.bkendbp.fieldsight.history.model.HistoryDto;

public class HistoryMapper {

    public static HistoryDto toHistoryDto(History history) {
        if (history == null) {
            return null;
        }

        Double predictedWinner = getPredictedWinner(
                history.getHomeWinProbability(),
                history.getAwayWinProbability()
        );

        HistoryDto historyDto = new HistoryDto();
        historyDto.setHomeTeam(history.getHomeTeam());
        historyDto.setAwayTeam(history.getAwayTeam());
        historyDto.setHomeScore(history.getHomeScore());
        historyDto.setAwayScore(history.getAwayScore());

        return historyDto;
    }

    private static Double getPredictedWinner(Double homePossibility, Double awayPossibility) {
        if (homePossibility > awayPossibility) {
            return homePossibility;
        } else
            return awayPossibility;
    }
}
