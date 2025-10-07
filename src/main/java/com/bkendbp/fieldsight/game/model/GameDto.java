package com.bkendbp.fieldsight.game.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class GameDto {
    private Long id;
    @JsonIgnore
    private Long externalGameId;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private Date gameDate;
}
