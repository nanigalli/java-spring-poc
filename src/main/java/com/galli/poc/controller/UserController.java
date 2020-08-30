package com.galli.poc.controller;

import com.galli.poc.exception.NotFoundException;
import com.galli.poc.mapper.UserMapper;
import com.galli.poc.model.UserDto;
import com.galli.poc.usecase.user.GetUserUseCase;
import com.galli.poc.usecase.user.GetUsersUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    final GetUserUseCase getUserUseCase;

    final GetUsersUseCase getUsersUseCase;

    public UserController(GetUserUseCase getUserUseCase, GetUsersUseCase getUsersUseCase) {
        this.getUserUseCase = getUserUseCase;
        this.getUsersUseCase = getUsersUseCase;
    }

    @GetMapping("")
    public List<UserDto> getAllEnabled() {
        return getUsersUseCase.getAllEnabledUsers().stream().map(UserMapper.INSTANCE::userToUserDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") final int id) {
        return getUserUseCase.getUserById(id).map(UserMapper.INSTANCE::userToUserDto)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found", id)));
    }

}
