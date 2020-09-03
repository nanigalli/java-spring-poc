package com.galli.poc.controller;

import com.galli.poc.exception.RepositoryException;
import com.galli.poc.model.ErrorResponse;
import com.galli.poc.model.TournamentEvent;
import com.galli.poc.repository.TournamentEventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TournamentEventControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    TournamentEventRepository repository;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetAll() throws MalformedURLException {
        TournamentEvent.Location location = new TournamentEvent.Location("Calle falsa 1", "CABA", "Buenos Aires", 37.4211274197085, -122.0855988802915);
        TournamentEvent event = new TournamentEvent(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"), "Super Mario 3", 546, new Date(), location);

        when(repository.getAll()).thenReturn(Collections.singletonList(event));

        ResponseEntity<List> response = template.getForEntity(getUrl(""), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void testGetAllEmpty() throws MalformedURLException {
        when(repository.getAll()).thenReturn(Collections.emptyList());

        ResponseEntity<List> response = template.getForEntity(getUrl(""), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void testGetAllException() throws MalformedURLException {
        when(repository.getAll()).thenThrow(new RepositoryException("Upss..", new RuntimeException()));

        ResponseEntity<ErrorResponse> response = template.getForEntity(getUrl(""), ErrorResponse.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(ErrorResponse.ErrorCode.FATAL_ERROR, response.getBody().getCode());
    }

    private String getUrl(String endpoint) throws MalformedURLException {
        return new URL(String.format("http://localhost:%d/v1/tournamentevents%s", port, endpoint)).toString();
    }

}
