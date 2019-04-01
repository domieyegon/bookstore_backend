package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {
}
