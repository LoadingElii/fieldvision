package com.bkendbp.fieldsight.game.repository;

import com.bkendbp.fieldsight.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public List<Game> getAllGamesBeforeDate(LocalDate today);
    public Game getGameById(String id);
}
