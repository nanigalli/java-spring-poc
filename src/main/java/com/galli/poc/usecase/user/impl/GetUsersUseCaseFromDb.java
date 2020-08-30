package com.galli.poc.usecase.user.impl;

import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import com.galli.poc.usecase.user.GetUsersUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUseCaseFromDb implements GetUsersUseCase {

    private final UserRepository repository;

    public GetUsersUseCaseFromDb(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllEnabledUsers() {
        return repository.findAllEnabled();
    }
}
