package com.bookstore.bookstore.service;

import java.util.Set;

import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.domian.UserBilling;
import com.bookstore.bookstore.domian.UserPayment;
import com.bookstore.bookstore.domian.UserShipping;
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

    void  updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);


    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserShippingDefault(Long userShippingId, User user);

}