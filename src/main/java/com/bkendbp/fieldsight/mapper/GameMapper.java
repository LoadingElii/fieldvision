package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.game.model.Game;
import com.bkendbp.fieldsight.game.model.GameDto;

public class GameMapper {

    public static GameDto toGameDto(Game game) {
        if(game == null) {
            return null;
        }

        GameDto gameDto = new GameDto();
        gameDto.setGame_id(game.getId());
        gameDto.setHome_team(game.getHomeTeam());
        gameDto.setAway_team(game.getAwayTeam());
        gameDto.setHome_score(game.getHomeScore());
        gameDto.setAway_score(game.getAwayScore());
        gameDto.setWeek(game.getWeek());
        gameDto.setSeason(game.getSeason());
        gameDto.setGameday(game.getGameDay());

        return gameDto;
    }

    public static Game toGame(GameDto gameDto) {
        if(gameDto == null) {
            return null;
        }

        Game game = new Game();
        game.setId(gameDto.getGame_id());
        game.setHomeTeam(gameDto.getHome_team());
        game.setAwayTeam(gameDto.getAway_team());
        game.setHomeScore(gameDto.getHome_score());
        game.setAwayScore(gameDto.getAway_score());
        game.setWeek(gameDto.getWeek());
        game.setSeason(gameDto.getSeason());
        game.setGameDay(gameDto.getGameday());

        return game;
    }

}
