package com.bkendbp.fieldsight.game.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class GameDto {
    private String game_id;
    private Integer week;
    private Integer season;
    private String home_team;
    private String away_team;
    private Integer home_score;
    private Integer away_score;
    private Date gameday;
}
