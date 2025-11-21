package com.bkendbp.fieldsight.history.repository;

import com.bkendbp.fieldsight.history.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("SELECT h FROM History h WHERE " +
            "h.homeTeam = :teamName OR h.awayTeam = :teamName")
    History findHistoryByTeamName(@Param("teamName") String teamName);
}
