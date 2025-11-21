package com.bkendbp.fieldsight.game.repository;

import com.bkendbp.fieldsight.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {
    @Query("SELECT g FROM Game g WHERE g.gameDay < :today")
    public List<Game> findByGameDayBefore(@Param("today") LocalDate today);
    public Game getGameById(String id);
}
