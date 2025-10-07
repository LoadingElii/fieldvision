package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;

public class GameMapper {

    public static GameDto toGameDto(Game game) {
        if(game == null) {
            return null;
        }

        GameDto gameDtoFromGame = new GameDto();
        gameDtoFromGame.setId(game.getId());
        gameDtoFromGame.setHomeTeam(game.getHomeTeam());
        gameDtoFromGame.setAwayTeam(game.getAwayTeam());
        gameDtoFromGame.setHomeScore(game.getHomeScore());
        gameDtoFromGame.setAwayScore(game.getAwayScore());
        gameDtoFromGame.setGameDate(game.getGameDate());

        return gameDtoFromGame;
    }

    public static Game toGame(GameDto gameDto) {
        if(gameDto == null) {
            return null;
        }

        Game gameFromGameDto = new Game();
        gameFromGameDto.setExternalGameId(gameDto.getExternalGameId());
        gameFromGameDto.setHomeTeam(gameDto.getHomeTeam());
        gameFromGameDto.setAwayTeam(gameDto.getAwayTeam());
        gameFromGameDto.setHomeScore(gameDto.getHomeScore());
        gameFromGameDto.setAwayScore(gameDto.getAwayScore());
        gameFromGameDto.setGameDate(gameDto.getGameDate());

        return gameFromGameDto;
    }

}
