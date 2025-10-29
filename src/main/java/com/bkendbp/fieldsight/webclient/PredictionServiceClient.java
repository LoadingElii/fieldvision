package com.bkendbp.fieldsight.webclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.bkendbp.fieldsight.prediction.model.PredictionDTO;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "prediction-service", url = "${predictionservice.url}")
public interface PredictionServiceClient {

    @GetMapping("/winprobability/{home_team}/{away_team}")
    public PredictionDTO getPredictionForGame(@PathVariable("home_team") String home_team,
                                              @PathVariable("away_team") String away_team);
}
