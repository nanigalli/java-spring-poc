package com.galli.poc.usecase.user.impl;

import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import com.galli.poc.usecase.user.GetUserUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserUseCaseFromDb implements GetUserUseCase {

    final UserRepository repository;

    public GetUserUseCaseFromDb(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

}
