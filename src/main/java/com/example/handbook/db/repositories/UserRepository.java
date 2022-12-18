package com.example.handbook.db.repositories;

import com.example.handbook.db.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
