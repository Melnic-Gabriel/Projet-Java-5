package com.example.joueurs.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joueurs.Entities.Friend;
import com.example.joueurs.Entities.Player;
import com.example.joueurs.Services.PlayerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    /*
     * @GetMapping("/getPlayerById")
     * public Player getPlayerById(@RequestBody Long id) {
     * return playerService.findPlayerById(id);
     * }
     */

    @GetMapping("/getPlayerById/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.findPlayerById(id);
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @PostMapping("/updatePlayer")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @GetMapping("/getPlayerStatisticsById/{id}")
    public String getPlayerStatisticsById(@PathVariable Long id) {
        return playerService.getPlayerStatisticsById(id);
    }

    @PostMapping("/addFriend/{idPlayer}/{idFriend}")
    public void addFriend(@PathVariable Long idPlayer, @PathVariable Long idFriend) {
        playerService.addFriend(idPlayer, idFriend);
    }

    @DeleteMapping("/deleteFriend")
    public void deleteFriend(@RequestBody Long idPlayer, @RequestBody Long idFriend) {
        playerService.deleteFriend(idPlayer, idFriend);
    }

}