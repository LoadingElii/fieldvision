package com.bkendbp.fieldsight.game.controller;

import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameDto>> getAllGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable("id") String id) {
        return new ResponseEntity<>(gameService.getGameById(id),HttpStatus.valueOf(200));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<GameDto> updateGameById(@PathVariable("id") String id,
                                                  @RequestBody GameDto game) {
        return new ResponseEntity<>(gameService.updateGameById(id, game), HttpStatus.valueOf(200));
    }

}
