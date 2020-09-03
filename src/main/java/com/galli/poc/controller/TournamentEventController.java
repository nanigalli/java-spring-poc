package com.galli.poc.controller;

import com.galli.poc.mapper.TournamentEventMapper;
import com.galli.poc.model.TournamentEventDto;
import com.galli.poc.usecase.tournamentevent.GetTournamentEventsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tournamentevents")
public class TournamentEventController {

    final GetTournamentEventsUseCase getTournamentEventsUseCase;

    public TournamentEventController(GetTournamentEventsUseCase getTournamentEventsUseCase) {
        this.getTournamentEventsUseCase = getTournamentEventsUseCase;
    }

    @GetMapping("")
    public List<TournamentEventDto> getAll() {
        return getTournamentEventsUseCase.getTournamentEvents().stream()
                .map(TournamentEventMapper.INSTANCE::tournamentEventToTournamentEventDto)
                .collect(Collectors.toList());
    }

}
