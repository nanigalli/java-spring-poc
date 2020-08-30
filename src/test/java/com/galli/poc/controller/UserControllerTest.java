package com.galli.poc.controller;

import com.galli.poc.model.ErrorResponse;
import com.galli.poc.model.User;
import com.galli.poc.model.UserDto;
import com.galli.poc.repository.UserRepository;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    UserRepository repository;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetAllEnabled() throws MalformedURLException {
        User user = new User(40000000, "Pato", "Lucas");
        user.setId(1);
        when(repository.findAllEnabled()).thenReturn(Collections.singletonList(user));

        ResponseEntity<List> response = template.getForEntity(getUrl(""), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void testGetAllEnabledEmpty() throws MalformedURLException {
        when(repository.findAllEnabled()).thenReturn(new ArrayList());

        ResponseEntity<List> response = template.getForEntity(getUrl(""), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void testGetByIdNotFound() throws MalformedURLException {
        //El id 0 nunca va a existir
        int id = 0;

        ResponseEntity<ErrorResponse> response = template.getForEntity(getUrl("/" + id), ErrorResponse.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(ErrorResponse.ErrorCode.NOT_FOUND, response.getBody().getCode());
    }

    @Test
    public void testGetById() throws MalformedURLException {
        int id = 1;

        User user = new User(40000000, "Pato", "Lucas");
        user.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(user));

        ResponseEntity<UserDto> response = template.getForEntity(getUrl("/" + id), UserDto.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
    }

    private String getUrl(String endpoint) throws MalformedURLException {
        return new URL(String.format("http://localhost:%d/v1/users%s", port, endpoint)).toString();
    }

}
