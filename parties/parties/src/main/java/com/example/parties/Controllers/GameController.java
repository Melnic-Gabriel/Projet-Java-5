package com.example.parties.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parties.Entities.Game;
import com.example.parties.Services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/getGameById/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.findGameById(id);
    }

    @DeleteMapping("/deleteGame/{id}")
    public void deleteGame(@PathVariable Long id) {
        if (gameService.findGameById(id) == null) {
            throw new RuntimeException("Game not found");
        }
        gameService.deleteGame(id);
    }

    @PostMapping("/updateGame")
    public Game updateGame(@RequestBody Game game) {
        return gameService.updateGame(game);
    }

    @PostMapping("/addGame")
    public Game addGame(@RequestBody Game game) {
        return gameService.addGame(game);
    }
}
