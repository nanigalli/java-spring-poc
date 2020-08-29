package com.galli.poc.controller;

import com.galli.poc.model.User;
import com.galli.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("")
    public List<User> getAll() {
        return repository.findAll();
    }

}
