package com.bookstore.bookstore.repository;

import java.util.List;

import com.bookstore.bookstore.domian.User;

import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository <User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    List <User> findAll();
    
}