package com.example.parties.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationDTO {
    private Long id;
    private long idGame;
    private long idPlayer;
    private int score;
    private boolean win;
}
