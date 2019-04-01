package com.bookstore.bookstore.resource;

import com.bookstore.bookstore.domian.Book;
import com.bookstore.bookstore.domian.CartItem;
import com.bookstore.bookstore.domian.ShoppingCart;
import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.CartItemService;
import com.bookstore.bookstore.service.ShoppingCartService;
import com.bookstore.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartResource {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartItemService cartItemService;


    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/add")
    public ResponseEntity addItem (@RequestBody HashMap<String, String>  mapper, Principal principal) {

        String bookId = (String) mapper.get("bookId");

        String qty = mapper.get("qty");

        User user = userService.findByUsername(principal.getName());

        Book book = bookService.findOne(Long.parseLong(bookId));

        if (Integer.parseInt(qty) > book.getInStockNumber()) {
            return new ResponseEntity("Not Enough Stock!", HttpStatus.BAD_REQUEST);
        }

        CartItem cartItem = cartItemService.addBookToCart(book, user, Integer.parseInt(qty));

        return new ResponseEntity("Book added successfully!", HttpStatus.OK);

    }

    @RequestMapping("/getCartItemList")
    public List<CartItem> getCartItemList(Principal principal) {
        User user = userService.findByUsername(principal.getName());

        ShoppingCart shoppingCart = (ShoppingCart) user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        return cartItemList;
    }

    @RequestMapping("/getShoppingCart")
    public ShoppingCart getShoppingCart(Principal principal) {
        User user = userService.findByUsername(principal.getName());

        ShoppingCart shoppingCart = (ShoppingCart) user.getShoppingCart();

        shoppingCartService.updateShoppingCart(shoppingCart);

        return shoppingCart;
    }

    @RequestMapping("removeItem")
    public ResponseEntity removeItem(@RequestBody String id) {
        cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id))) ;

        return new ResponseEntity("Cart item Removed successfully!", HttpStatus.OK);

    }

    @RequestMapping("updateCartItem")
    public ResponseEntity updateCartItem(@RequestBody HashMap<String, String>  mapper, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        String cartItemId = mapper.get("cartItemId");
        String qty = mapper.get("qty");

        CartItem cartItem = cartItemService.findById(Long.parseLong(cartItemId));

        cartItem.setQty(Integer.parseInt(qty));

        cartItemService.updateCartItem(cartItem);

        return new ResponseEntity("Cart item Updated successfully!", HttpStatus.OK);

    }
}
