package com.bkendbp.fieldsight.webclient;

import com.bkendbp.fieldsight.game.model.GameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "game-service", url = "${gameservice.url}" )
public interface GameServiceClient {
    @GetMapping("/currentweek")
    public List<GameDto> getAllGamesForWeek();
}
