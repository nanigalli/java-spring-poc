package com.galli.poc.usecase.user.impl;

import com.galli.poc.exception.RepositoryException;
import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetUsersUseCaseFromDbTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private GetUsersUseCaseFromDb useCase;

    @Test
    public void testGetAllEnabledUsersWithProblemRepository() {
        when(repository.findAllEnabled()).thenThrow(new RuntimeException("Error"));

        assertThrows(RepositoryException.class, () -> useCase.getAllEnabledUsers());
    }

    @Test
    public void testGetAllEnabledUsersEmpty() {
        when(repository.findAllEnabled()).thenReturn(new ArrayList<>());

        List<User> users = useCase.getAllEnabledUsers();

        assertNotNull(users);
        assertTrue(users.isEmpty());
    }

    @Test
    public void testGetAllEnabledUsers() {
        User user = new User(3888, "Pepe", "Grillo");
        when(repository.findAllEnabled()).thenReturn(Collections.singletonList(user));

        List<User> users = useCase.getAllEnabledUsers();

        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
    }

}
