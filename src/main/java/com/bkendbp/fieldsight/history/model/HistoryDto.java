package com.bkendbp.fieldsight.history.model;

import lombok.Data;

@Data
public class HistoryDto {
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private Double housePrediction;
}