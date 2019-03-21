package com.bookstore.bookstore.service;

import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserSecurityService implements UserDetailsService {

    public static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    // for accessing database -- it is a layer btwn java classes and database
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (null == user) {
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + "not found");

        }
        return user;

    }

}