package com.example.parties.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parties.DAO.GameDAO;
import com.example.parties.Entities.Game;
import com.example.parties.Repositories.GameRepository;
import com.example.parties.Repositories.ParticipationRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameDAO gameDAO;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findGameById(Long id) {
        return gameDAO.getGameById(id);
    }

    public Game addGame(Game game) {
        return gameDAO.createGame(game);
    }

    public Game updateGame(Game game) {
        return gameDAO.updateGame(game);
    }

    public void deleteGame(Long id) {
        gameDAO.deleteGame(id);
    }

}
