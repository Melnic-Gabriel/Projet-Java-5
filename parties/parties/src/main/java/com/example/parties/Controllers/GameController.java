package com.example.parties.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getGameById")
    public Game getGameById(@RequestBody Long id) {
        return gameService.findGameById(id);
    }

    @GetMapping("/deleteGame")
    public void deleteGame(@RequestBody Long id) {
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
