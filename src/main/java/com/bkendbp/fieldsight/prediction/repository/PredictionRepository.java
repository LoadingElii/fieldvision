package com.bkendbp.fieldsight.prediction.repository;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}
