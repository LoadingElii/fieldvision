package com.bkendbp.fieldsight.prediction.controller;

import com.bkendbp.fieldsight.prediction.model.Prediction;
import com.bkendbp.fieldsight.prediction.model.PredictionDTO;
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
    public ResponseEntity<List<PredictionDTO>> getAllPredictions() {
         return new ResponseEntity<>(predictionService.getAllPredictions(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prediction> getPredictionById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(predictionService.getPredictionById(id), HttpStatusCode.valueOf(200));
    }

}
