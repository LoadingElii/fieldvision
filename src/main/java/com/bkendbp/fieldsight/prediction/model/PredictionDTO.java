package com.bkendbp.fieldsight.prediction.model;

import lombok.Data;

@Data
public class PredictionDTO {
    private Long prediction_id;
    private String home_team;
    private String away_team;
    private double home_win_probability;
    private double away_win_probability;
}
