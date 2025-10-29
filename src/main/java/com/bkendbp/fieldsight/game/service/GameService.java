package com.bkendbp.fieldsight.game.service;

import com.bkendbp.fieldsight.exception.ResourceAlreadyExistException;
import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.game.repository.GameRepository;
import com.bkendbp.fieldsight.mapper.GameMapper;
import com.bkendbp.fieldsight.webclient.GameServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        getGamesFromClientAndSave();
        if(gameRepository.findAll().isEmpty()) {
          throw new ResourceNotFoundException("No games exist.");
        }
       return gameRepository.findAll().stream().map(GameMapper::toGameDto).toList();
    }

    private void getGamesFromClientAndSave() {
        List<GameDto> gamesFromClient = gameServiceClient.getAllGamesForWeek();
        List<Game> games = gamesFromClient.stream().map(GameMapper::toGame).toList();
        gameRepository.saveAll(games);
    }

    public GameDto getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Game with id: " + id + " does not exist."));

        return GameMapper.toGameDto(game);
    }

    public GameDto updateGameById(Long id, GameDto game) {
        Game gameToUpdate = gameRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Game with id: " + id + " does not exist."));

        gameToUpdate.setHomeScore(game.getHome_score());
        gameToUpdate.setAwayScore(game.getAway_score());

        return GameMapper.toGameDto(gameRepository.save(gameToUpdate));
    }


    public String deleteGameById(Long id) {
        gameRepository.deleteById(id);
        if(gameRepository.existsById(id)) {
            return "Game not deleted.";
        }

        return "Successfully deleted game.";
    }
}
