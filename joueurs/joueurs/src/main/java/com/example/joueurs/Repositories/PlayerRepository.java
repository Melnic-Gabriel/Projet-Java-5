package com.example.joueurs.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joueurs.Entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
