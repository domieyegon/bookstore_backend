package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.security.Role;

import org.springframework.data.repository.CrudRepository;

/**
 * RoleRepository
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

}