package com.bookstore.bookstore.service;

import com.bookstore.bookstore.domian.*;

public interface OrderService  {

    Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress, Payment payment, String shippingMethod, User user);

//    Order findOne(Long id);
}
