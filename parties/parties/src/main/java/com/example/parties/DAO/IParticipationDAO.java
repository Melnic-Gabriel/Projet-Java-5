package com.example.parties.DAO;

import org.springframework.stereotype.Repository;

import com.example.parties.Entities.Participation;

@Repository
public interface IParticipationDAO {
    public Participation getParticipationById(Long id);

    public void deleteParticipation(Long id);

    public Participation createParticipation(Participation participation);

    public Participation updateParticipation(Participation participation);
}
