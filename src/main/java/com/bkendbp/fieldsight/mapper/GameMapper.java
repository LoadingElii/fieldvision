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
        gameDtoFromGame.setHome_team(game.getHomeTeam());
        gameDtoFromGame.setAway_team(game.getAwayTeam());
        gameDtoFromGame.setHome_score(game.getHomeScore());
        gameDtoFromGame.setAway_score(game.getAwayScore());
        gameDtoFromGame.setWeek(game.getWeek());
        gameDtoFromGame.setSeason(game.getSeason());
        gameDtoFromGame.setGameday(game.getGameDay());

        return gameDtoFromGame;
    }

    public static Game toGame(GameDto gameDto) {
        if(gameDto == null) {
            return null;
        }

        Game gameFromGameDto = new Game();
        gameFromGameDto.setExternalGameId(gameDto.getGame_id());
        gameFromGameDto.setHomeTeam(gameDto.getHome_team());
        gameFromGameDto.setAwayTeam(gameDto.getAway_team());
        gameFromGameDto.setHomeScore(gameDto.getHome_score());
        gameFromGameDto.setAwayScore(gameDto.getAway_score());
        gameFromGameDto.setWeek(gameDto.getWeek());
        gameFromGameDto.setSeason(gameDto.getSeason());
        gameFromGameDto.setGameDay(gameDto.getGameday());

        return gameFromGameDto;
    }

}
