package com.galli.poc.controller;

import com.galli.poc.exception.NotFoundException;
import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<User> getAllEnabled() {
        return repository.findAllEnabled();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") final int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found", id)));
    }

}
