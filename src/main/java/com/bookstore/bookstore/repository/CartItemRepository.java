package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.CartItem;
import com.bookstore.bookstore.domian.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {


    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//    List<CartItem> findByOrder(Order order);

}
