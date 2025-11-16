package com.bkendbp.fieldsight.prediction.model;

import lombok.Data;

import java.util.UUID;

@Data
public class PredictionDto {
    private UUID id;
    private String game_id;
    private String home_team;
    private String away_team;
    private double home_win_probability;
    private double away_win_probability;
}
