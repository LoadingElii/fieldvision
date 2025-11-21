package com.bkendbp.fieldsight.game.service;

import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.game.repository.GameRepository;
import com.bkendbp.fieldsight.mapper.GameMapper;
import com.bkendbp.fieldsight.webclient.GameServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameServiceClient gameServiceClient;

    @Autowired
    public GameService(GameRepository gameRepository, GameServiceClient gameServiceClient) {
        this.gameRepository = gameRepository;
        this.gameServiceClient = gameServiceClient;
    }

    public List<GameDto> getAllGames() {
        if(gameRepository.findAll().isEmpty()) {
            getGamesFromClientAndSave();
        }
        List<GameDto> allGamesForWeek = gameRepository.findAll().
                stream().map(GameMapper::toGameDto).toList();

        if (allGamesForWeek.isEmpty()) {
            throw new ResourceNotFoundException("No Games Found.");
        }else
            return allGamesForWeek;
    }

    private void getGamesFromClientAndSave()  {
        List<GameDto> gamesFromClient = gameServiceClient.getAllGamesForWeek();
        List<Game> games = gamesFromClient.stream().map(GameMapper::toGame).toList();
        gameRepository.saveAll(games);
    }

    public GameDto getGameById(String id) {
        Game game = gameRepository.getGameById(id);

        if(game.getId().isEmpty()){
            throw new ResourceNotFoundException("Game with id: " + id + " does not found.");
        }
        return GameMapper.toGameDto(game);
    }

    public List<Game> getAllPastGames() {
        List<Game> Games = gameRepository.findByGameDayBefore(LocalDate.now());
        if(Games.isEmpty()) {
            throw new ResourceNotFoundException("No past games found.");
        } else
            return Games;
    }

    public GameDto updateGameById(String id, GameDto game) {
        Game gameToUpdate = gameRepository.getGameById(id);

        if(gameToUpdate.getId().isEmpty()){
            throw new ResourceNotFoundException("Game with id: " + id + " does not found.");
        }

        gameToUpdate.setHomeScore(game.getHome_score());
        gameToUpdate.setAwayScore(game.getAway_score());

        return GameMapper.toGameDto(gameRepository.save(gameToUpdate));
    }


    public void deleteGame(Game game) {
        gameRepository.delete(game);
    }
}
