package com.bkendbp.fieldsight.game.model;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {
    @Id
    private String id;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private Integer week;
    private Integer season;
    private LocalDate gameDay;
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL)
    private Prediction prediction;
    private Date createdAt = Date.from(Instant.now());
}
