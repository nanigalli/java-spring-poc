package com.galli.poc.usecase.tournamentevent.impl;

import com.galli.poc.exception.RepositoryException;
import com.galli.poc.model.TournamentEvent;
import com.galli.poc.repository.TournamentEventRepository;
import com.galli.poc.usecase.tournamentevent.GetTournamentEventsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTournamentEventsUseCaseFromApi implements GetTournamentEventsUseCase {

    private final TournamentEventRepository repository;

    public GetTournamentEventsUseCaseFromApi(TournamentEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TournamentEvent> getTournamentEvents() {
        try {
            return repository.getAll();
        } catch (Exception e) {
            throw new RepositoryException("Hubo un problema al buscar los eventos de torneo", e);
        }
    }
}
