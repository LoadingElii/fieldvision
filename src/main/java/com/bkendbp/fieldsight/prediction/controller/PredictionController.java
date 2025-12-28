package com.bkendbp.fieldsight.prediction.controller;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDto;
import com.bkendbp.fieldsight.prediction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/predictions")
public class PredictionController {
     private final PredictionService predictionService;

     @Autowired
     public PredictionController(PredictionService predictionService) {
         this.predictionService = predictionService;
     }

    @GetMapping("/all")
    public ResponseEntity<List<PredictionDto>> getAllPredictions() {
         return ResponseEntity.ok(predictionService.getAllPredictions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PredictionDto> getPredictionById(@PathVariable("id") String id) {
        return ResponseEntity.ok(predictionService.getPredictionByGameId(id));
     }

}
