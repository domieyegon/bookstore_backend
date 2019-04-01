package com.bookstore.bookstore.service;

import com.bookstore.bookstore.domian.Book;
import com.bookstore.bookstore.domian.CartItem;
import com.bookstore.bookstore.domian.ShoppingCart;
import com.bookstore.bookstore.domian.User;

import java.util.List;

public interface CartItemService {

    CartItem addBookToCart(Book book, User user, int qty);

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//    List<CartItem> findByOrder(Order order);

    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem findById(Long id);

    CartItem save(CartItem cartItem);

}
