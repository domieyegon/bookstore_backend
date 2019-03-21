package com.bookstore.bookstore.utility;


import com.bookstore.bookstore.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructNewUserEmail(User user, String password) {
        String message = "\nPlease use the following credetials to login and edit your personal information including your own password."
                + "Username: "+ user.getUsername() + " Password: "+ password;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Le's Bookstore - New User");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
