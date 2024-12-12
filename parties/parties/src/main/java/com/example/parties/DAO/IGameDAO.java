package com.example.parties.DAO;

import org.springframework.stereotype.Repository;

import com.example.parties.Entities.Game;

@Repository
public interface IGameDAO {
    public Game getGameById(Long id);

    public void deleteGame(Long id);

    public Game createGame(Game game);

    public Game updateGame(Game game);
}
