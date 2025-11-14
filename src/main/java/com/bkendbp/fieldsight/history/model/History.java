package com.bkendbp.fieldsight.history.model;

import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.prediction.model.Prediction;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "History")
public class History {
    private Game game;
    private Prediction prediction;
    private String homeTeam;
    private String awayTeam;

}
