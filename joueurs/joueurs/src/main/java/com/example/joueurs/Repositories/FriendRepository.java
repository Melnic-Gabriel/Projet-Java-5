package com.example.joueurs.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.joueurs.Entities.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {

}
