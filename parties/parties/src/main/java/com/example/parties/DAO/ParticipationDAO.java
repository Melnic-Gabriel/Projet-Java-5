package com.example.parties.DAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.parties.Entities.Participation;
import com.example.parties.Repositories.ParticipationRepository;

public class ParticipationDAO implements IParticipationDAO {
    @Autowired
    private ParticipationRepository participationRepository;

    @Override
    public Participation getParticipationById(Long id) {
        return participationRepository.findById(id).orElseThrow(() -> new RuntimeException("PArticipation not found"));
    }

    @Override
    public void deleteParticipation(Long id) {
        if (participationRepository.existsById(id)) {
            participationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Participation not found");
        }
    }

    @Override
    public Participation createParticipation(Participation participation) {
        if (participationRepository.existsById(participation.getId())) {
            throw new RuntimeException("Participation already exists");
        }
        return participationRepository.save(participation);
    }

    @Override
    public Participation updateParticipation(Participation participation) {
        Participation participationToUpdate = participationRepository.findById(participation.getId())
                .orElseThrow(() -> new RuntimeException("Participation not found"));
        participationToUpdate.setGameId(participation.getGameId());
        participationToUpdate.setPlayerId(participation.getPlayerId());
        participationToUpdate.setScore(participation.getScore());
        participationToUpdate.setWin(participation.isWin());
        return participationRepository.save(participationToUpdate);

    }

}
