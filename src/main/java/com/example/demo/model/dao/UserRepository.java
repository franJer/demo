package com.example.demo.model.dao;

import com.example.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
    User findByName(String name);
}
