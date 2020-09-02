package com.galli.poc.usecase.tournamentevent.impl;

import com.galli.poc.model.TournamentEvent;
import com.galli.poc.repository.TournamentEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetTournamentEventsUseCaseFromApiTest {

        @Mock
        private TournamentEventRepository repository;

        @InjectMocks
        private GetTournamentEventsUseCaseFromApi useCase;

        @Test
        public void testGetTournamentEventsWithProblemRepository() {
            when(repository.getAll()).thenThrow(new RuntimeException("Error"));

            assertThrows(RuntimeException.class, () -> useCase.getTournamentEvents());
        }

        @Test
        public void testGetTournamentEventsEmpty() {
            when(repository.getAll()).thenReturn(new ArrayList<>());

            List<TournamentEvent> tournamentEvents = useCase.getTournamentEvents();

            assertNotNull(tournamentEvents);
            assertTrue(tournamentEvents.isEmpty());
        }

        @Test
        public void testGetTournamentEvents() {
            TournamentEvent.Location location = new TournamentEvent.Location("Calle falsa 1", "CABA", "Buenos Aires", 37.4211274197085, -122.0855988802915);
            TournamentEvent event = new TournamentEvent(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"), "Super Mario 3", 546, new Date(), location);

            when(repository.getAll()).thenReturn(Collections.singletonList(event));

            List<TournamentEvent> tournamentEvents = useCase.getTournamentEvents();

            assertNotNull(tournamentEvents);
            assertFalse(tournamentEvents.isEmpty());
            assertEquals(1, tournamentEvents.size());
        }
}
