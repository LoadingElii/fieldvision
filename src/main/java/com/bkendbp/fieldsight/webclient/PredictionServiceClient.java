package com.bkendbp.fieldsight.webclient;

import com.bkendbp.fieldsight.game.model.GameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.bkendbp.fieldsight.prediction.model.PredictionDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "prediction-service", url = "${predictionservice.url}")
public interface PredictionServiceClient {

    @GetMapping("/winprobability/game")
    public PredictionDto getPredictionForGame(@RequestParam String game_id,
                                              @RequestParam String home_team,
                                              @RequestParam String away_team);
}
