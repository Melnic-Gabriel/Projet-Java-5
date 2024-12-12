package com.example.parties.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parties.Entities.Participation;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

}
