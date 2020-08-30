package com.galli.poc.usecase.user;

import com.galli.poc.model.User;

import java.util.Optional;

public interface GetUserUseCase {

    /**
     * Devuelve la informacion del usuario buscado.
     *
     * @param id : id del usuario buscado
     * @return Optional con el usuario encontrado, en caso contrario Optional.empty()
     */
    Optional<User> getUserById(final int id);

}
