package com.example.joueurs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.joueurs.Entities.Player;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FriendDTO {
    private Long id;
    private Player player;
    private Player friend;
}
