package com.example.joueurs.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.joueurs.Entities.Friend;
import com.example.joueurs.Entities.Player;

@Repository
public interface IPlayerDAO {
    // player CRUD
    public Player getPlayerById(Long id);

    public Player addPlayer(Player player);

    public Player updatePlayer(Player player);

    public void deletePlayer(Long id);

    public String getPlayerStatisticsById(Long id);

    // friends
    public List<Friend> getFriendsByPlayerId(Long id);

    // public Friend addFriend(Long idPlayer, Friend friend);
    public Friend addFriend(Long idPlayer, Long idFriend);

    public void deleteFriend(Long idPlayer, Long idFriend);

}
