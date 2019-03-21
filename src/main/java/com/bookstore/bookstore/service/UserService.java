package com.bookstore.bookstore.service;

import java.util.Set;

import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.domian.security.UserRole;

/**
 * UserService
 */
public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);

    User findByUsername(String username);


    User findByEmail(String email);

    User save(User user);

    User findById(Long id);
}