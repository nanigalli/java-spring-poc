package com.galli.poc.repositories;

import com.galli.poc.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
