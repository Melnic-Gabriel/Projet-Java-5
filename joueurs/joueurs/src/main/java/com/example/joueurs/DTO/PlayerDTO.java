package com.example.joueurs.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    // private long id;
    private String name;
    private String nickname;
    private String email;
    private int level;
    private int totalPoints;

    private List<FriendDTO> friends;
}
