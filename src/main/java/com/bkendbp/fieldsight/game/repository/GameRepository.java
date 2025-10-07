package com.bkendbp.fieldsight.game.repository;

import com.bkendbp.fieldsight.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
