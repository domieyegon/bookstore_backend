package com.bookstore.bookstore;

import java.util.HashSet;
import java.util.Set;

import com.bookstore.bookstore.config.SecurityUtility;
import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.domian.security.Role;
import com.bookstore.bookstore.domian.security.UserRole;
import com.bookstore.bookstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // CommandLineRunner helps in implementing a method called run()

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... string) throws Exception {

        User user1 = new User();
        user1.setFirstname("Dominic");
        user1.setLastname("Yegon");
        user1.setUsername("Domie");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("d"));
        user1.setEmail("domieyegon70@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);

        userRoles.clear();

        User user2 = new User();
        user2.setFirstname("Admin");
        user2.setLastname("Admin");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user2.setEmail("Admin@gmail.com");

        Role role2 = new Role();
        role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user2, role2));

        userService.createUser(user2, userRoles);
    }

}
