package com.bkendbp.fieldsight.prediction.repository;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}
