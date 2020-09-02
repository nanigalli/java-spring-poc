package com.galli.poc.usecase.tournamentevent;

import com.galli.poc.model.TournamentEvent;

import java.util.List;

public interface GetTournamentEventsUseCase {

    /**
     * Devuelve todos los eventos de torneo disponibles.
     *
     * @return lista de eventos de torneo
     */
    List<TournamentEvent> getTournamentEvents();
}
