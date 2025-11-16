package com.bkendbp.fieldsight.prediction.model;

import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "predictions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String homeTeam;
    private String awayTeam;
    private Double homeTeamWinProbability;
    private Double awayTeamWinProbability;
    @OneToOne
    @JoinColumn(name = "game_id",referencedColumnName = "id")
    private Game game;
    private LocalDate createdAt = LocalDate.now();

}
