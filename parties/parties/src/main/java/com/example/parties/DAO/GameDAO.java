package com.example.parties.DAO;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.parties.Entities.Game;
import com.example.parties.Repositories.GameRepository;

@Repository
public class GameDAO implements IGameDAO {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public void deleteGame(Long id) {
        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        Game gameToUpdate = gameRepository.findById(game.getId())
                .orElseThrow(() -> new RuntimeException("Game not found"));
        gameToUpdate.setDate(game.getDate());
        gameToUpdate.setGameType(game.getGameType());
        gameToUpdate.setMaximumScore(game.getMaximumScore());
        gameToUpdate.setHostId(game.getHostId());
        return gameRepository.save(gameToUpdate);
    }

}
