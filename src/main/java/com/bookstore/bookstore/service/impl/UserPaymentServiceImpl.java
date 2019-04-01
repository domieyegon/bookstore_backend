package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.domian.UserPayment;
import com.bookstore.bookstore.repository.UserPaymentRepository;
import com.bookstore.bookstore.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);
    }

    public void removeById(Long id) {
        UserPayment payment = userPaymentRepository.getOne(id);

        userPaymentRepository.delete(payment);
        System.out.println(payment);
    }
}
