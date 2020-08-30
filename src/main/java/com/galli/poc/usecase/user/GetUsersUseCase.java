package com.galli.poc.usecase.user;

import com.galli.poc.model.User;

import java.util.List;

public interface GetUsersUseCase {

    /**
     * Devuelve todos los usuarios habilitados.
     *
     * @return lista de usuarios habilitados
     */
    List<User> getAllEnabledUsers();

}
