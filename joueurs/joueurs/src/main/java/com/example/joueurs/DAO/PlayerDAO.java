package com.example.joueurs.DAO;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.joueurs.Entities.Friend;
import com.example.joueurs.Entities.Player;
import com.example.joueurs.Repositories.FriendRepository;
import com.example.joueurs.Repositories.PlayerRepository;

@Repository
public class PlayerDAO implements IPlayerDAO {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private FriendRepository friendRepository;

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    @Override
    public Player addPlayer(Player player) {
        if (player == null) {
            throw new RuntimeException("Player cannot be null");
        }
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {

        Player playerToUpdate = playerRepository.findById(player.getId())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        playerToUpdate.setName(player.getName());
        playerToUpdate.setNickname(player.getNickname());
        playerToUpdate.setEmail(player.getEmail());
        playerToUpdate.setLevel(player.getLevel());
        playerToUpdate.setTotalPoints(player.getTotalPoints());

        return playerRepository.save(playerToUpdate);
    }

    @Override
    public void deletePlayer(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Player not found");
        }
    }

    @Override
    public List<Friend> getFriendsByPlayerId(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return player.getFriends();
    }

    @Override
    public String getPlayerStatisticsById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return "Player " + player.getName() + " has " + player.getTotalPoints() + " points and is level "
                + player.getLevel();
    }

    @Override
    public Friend addFriend(Long idPlayer, Long idFriend) {
        Player player = playerRepository.findById(idPlayer)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + idPlayer));

        Player friendPlayer = playerRepository.findById(idFriend)
                .orElseThrow(() -> new RuntimeException("Friend not found with ID: " + idFriend));

        Friend friend = new Friend();
        friend.setPlayer(player);
        friend.setFriend(friendPlayer);

        friendRepository.save(friend);
        return friend;
    }

    @Override
    public void deleteFriend(Long idPlayer, Long idFriend) {

        Player player = playerRepository.findById(idPlayer).orElseThrow(() -> new RuntimeException("Player not found"));
        Friend friend = player.getFriends().stream().filter(f -> f.getId().equals(idFriend)).findFirst()
                .orElseThrow(() -> new RuntimeException("Friend not found"));
        player.getFriends().remove(friend);
        playerRepository.save(player);
    }
}
