package com.bkendbp.fieldsight.history.repository;

import com.bkendbp.fieldsight.history.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {
    History findHistoryByTeam(String team);
}
