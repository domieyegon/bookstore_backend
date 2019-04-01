package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.domian.CartItem;
import com.bookstore.bookstore.domian.ShoppingCart;
import com.bookstore.bookstore.repository.ShoppingCartRepository;
import com.bookstore.bookstore.service.CartItemService;
import com.bookstore.bookstore.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {

        BigDecimal cartTotal = new BigDecimal(0);

        List<CartItem> cartItemList =cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            if (cartItem.getBook().getInStockNumber() > 0 ) {
                cartItemService.updateCartItem(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubtotal());

            }
        }

        shoppingCart.setGrandTotal(cartTotal);

        shoppingCartRepository.save(shoppingCart);
        return  shoppingCart;
    }

    public void clearShoppingCart(ShoppingCart shoppingCart) {

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            cartItem.setShoppingCart(null);
            cartItemService.save(cartItem);
        }

        shoppingCart.setGrandTotal(new BigDecimal(0));

        shoppingCartRepository.save(shoppingCart);

    }

}
