package com.example.joueurs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.joueurs.DAO.PlayerDAO;
import com.example.joueurs.Entities.Friend;
import com.example.joueurs.Entities.Player;
import com.example.joueurs.Repositories.FriendRepository;
import com.example.joueurs.Repositories.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, FriendRepository friendRepository) {
        this.playerRepository = playerRepository;
        this.friendRepository = friendRepository;
    }

    public Player findPlayerById(Long id) {
        return playerDAO.getPlayerById(id);
    }

    public Player addPlayer(Player player) {
        return playerDAO.addPlayer(player);
    }

    public Player updatePlayer(Player player) {
        return playerDAO.updatePlayer(player);
    }

    public void deletePlayer(Long id) {
        playerDAO.deletePlayer(id);
    }

    public String getPlayerStatisticsById(Long id) {
        return playerDAO.getPlayerStatisticsById(id);
    }

    public void addFriend(Long idPlayer, Long idFriend) {
        // playerDAO.addFriend(idPlayer, friend);
        playerDAO.addFriend(idPlayer, idFriend);
    }

    public void deleteFriend(Long idPlayer, Long idFriend) {
        playerDAO.deleteFriend(idPlayer, idFriend);
    }

}
