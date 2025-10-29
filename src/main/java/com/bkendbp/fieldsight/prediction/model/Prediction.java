package com.bkendbp.fieldsight.prediction.model;

import com.bkendbp.fieldsight.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "predictions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String homeTeam;
    private String awayTeam;
    private Double homeTeamWinProbability;
    private Double awayTeamWinProbability;
}
