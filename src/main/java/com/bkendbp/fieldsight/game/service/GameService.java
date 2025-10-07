package com.bkendbp.fieldsight.game.service;

import com.bkendbp.fieldsight.exception.ResourceAlreadyExistException;
import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;
import com.bkendbp.fieldsight.game.repository.GameRepository;
import com.bkendbp.fieldsight.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> getAllGames() {
        if(gameRepository.findAll().isEmpty()) {
          throw new ResourceNotFoundException("No games exist.");
        }
       return gameRepository.findAll().stream().map(GameMapper::toGameDto).toList();
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

        gameToUpdate.setHomeScore(game.getHomeScore());
        gameToUpdate.setAwayScore(game.getAwayScore());

        return GameMapper.toGameDto(gameRepository.save(gameToUpdate));
    }

    public GameDto createGame(GameDto game) {
        if(gameRepository.existsById(game.getId())) {
            throw new ResourceAlreadyExistException("Game with id: " + game.getId() + " already exist.");
        }

        Game newGame = gameRepository.save(GameMapper.toGame(game));

        return GameMapper.toGameDto(newGame);

    }

    public String deleteGameById(Long id) {
        gameRepository.deleteById(id);
        if(gameRepository.existsById(id)) {
            return "Game not deleted.";
        }

        return "Successfully deleted game.";
    }
}
