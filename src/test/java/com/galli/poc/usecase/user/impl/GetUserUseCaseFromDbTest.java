package com.galli.poc.usecase.user.impl;

import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetUserUseCaseFromDbTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private GetUserUseCaseFromDb useCase;

    @Test
    public void testGetAllEnabledUsersWithProblemRepository() {
        int id = 1;
        when(repository.findById(id)).thenThrow(new RuntimeException("Error"));

        assertThrows(RuntimeException.class, () -> useCase.getUserById(id));
    }

    @Test
    public void testGetAllEnabledUsersEmpty() {
        int id = 1;
        when(repository.findById(id)).thenReturn(Optional.empty());

        Optional<User> result = useCase.getUserById(id);

        assertNotNull(result);
        assertFalse(result.isPresent());
    }

    @Test
    public void testGetAllEnabledUsers() {
        int id = 1;
        User user = new User(3888, "Pepe", "Grillo");
        user.setId(id);
        when(repository.findById(id)).thenReturn(Optional.of(user));

        Optional<User> result = useCase.getUserById(id);

        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

}
