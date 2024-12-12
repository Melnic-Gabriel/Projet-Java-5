package com.example.parties.Services;

import org.springframework.stereotype.Service;

import com.example.parties.DAO.ParticipationDAO;
import com.example.parties.Entities.Participation;
import com.example.parties.Repositories.ParticipationRepository;

@Service
public class ParticipationService {
    private ParticipationRepository participationRepository;
    private ParticipationDAO participationDAO;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation findParticipationById(Long id) {
        return participationDAO.getParticipationById(id);
    }

    public Participation addParticipation(Participation participation) {
        return participationDAO.createParticipation(participation);
    }

    public Participation updateParticipation(Participation participation) {
        return participationDAO.updateParticipation(participation);
    }

    public void deleteParticipation(Long id) {
        participationDAO.deleteParticipation(id);
    }
}
