package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.Order;
import com.bookstore.bookstore.domian.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);
}
