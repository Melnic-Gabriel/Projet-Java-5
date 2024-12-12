package com.example.parties.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parties.Entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}