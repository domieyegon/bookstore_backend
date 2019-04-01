package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository <ShoppingCart, Long> {
}
