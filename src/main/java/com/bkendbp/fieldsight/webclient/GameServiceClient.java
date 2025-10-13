package com.bkendbp.fieldsight.webclient;

import com.bkendbp.fieldsight.game.model.GameDto;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

//@FeignClient(name = "game service", url = )
public interface GameServiceClient {
    public List<GameDto> getAllGamesForWeek();
}
