package com.example.parties.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;
    private Date date;
    private String gameType;
    private int maximumScore;
    private Long hostId;
}
