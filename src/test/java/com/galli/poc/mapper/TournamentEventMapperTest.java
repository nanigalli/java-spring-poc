package com.galli.poc.mapper;

import com.galli.poc.model.TournamentEvent;
import com.galli.poc.model.TournamentEventDto;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TournamentEventMapperTest {

    @Test
    public void test() {
        TournamentEvent.Location location = new TournamentEvent.Location("Calle falsa 1", "CABA", "Buenos Aires", 37.4211274197085, -122.0855988802915);
        TournamentEvent event = new TournamentEvent(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"), "Super Mario 3", 546, new Date(), location);

        TournamentEventDto eventDto = TournamentEventMapper.INSTANCE.tournamentEventToTournamentEventDto(event);

        assertNotNull(eventDto);
        assertEquals(event.getId(), eventDto.getId());
        assertEquals(event.getGame(), eventDto.getGame());
        assertEquals(event.getLocation().getAddress() + ", " + event.getLocation().getLocality() + ", " + event.getLocation().getProvince(), eventDto.getAddress());
        assertEquals(event.getEnrolled(), eventDto.getEnrolled());
        assertEquals(event.getLocation().getLatitude(), eventDto.getLatitude());
        assertEquals(event.getLocation().getLongitude(), eventDto.getLongitude());
        //TODO: ver como evaluar las fechas 01 Sep 2020 11:15
//        assertEquals(event.getDate(), eventDto.getDate());
    }

    @Test
    public void test2() {
        TournamentEventDto eventDto = new TournamentEventDto(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"), "Super Mario 3", 546, "01 Sep 2020 11:15", "Calle falsa 1, CABA, Buenos Aires", 37.4211274197085, -122.0855988802915);

        TournamentEvent event = TournamentEventMapper.INSTANCE.tournamentEventDtoTotournamentEvent(eventDto);

        assertNotNull(eventDto);
        assertEquals(event.getId(), eventDto.getId());
        assertEquals(event.getGame(), eventDto.getGame());
        assertEquals(event.getLocation().getAddress() + ", " + event.getLocation().getLocality() + ", " + event.getLocation().getProvince(), eventDto.getAddress());
        assertEquals(event.getEnrolled(), eventDto.getEnrolled());
        assertEquals(event.getLocation().getLatitude(), eventDto.getLatitude());
        assertEquals(event.getLocation().getLongitude(), eventDto.getLongitude());
        //TODO: ver como evaluar las fechas
//        assertEquals(event.getDate(), eventDto.getDate());
    }

}
