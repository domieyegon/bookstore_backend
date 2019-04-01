package com.bookstore.bookstore.resource;

import com.bookstore.bookstore.domian.User;
import com.bookstore.bookstore.domian.UserShipping;
import com.bookstore.bookstore.service.UserService;
import com.bookstore.bookstore.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserShippingService userShippingService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private ResponseEntity addNewShippingPost (@RequestBody UserShipping userShipping, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        userService.updateUserShipping(userShipping, user);

        return new ResponseEntity("User Shipping Added(Updated) Successfully", HttpStatus.OK);
    }

    @RequestMapping("/getUserShippingList")
    private List<UserShipping> getUserShippingList(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<UserShipping> userShippingList = user.getUserShippingList();

        return userShippingList;

    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    private ResponseEntity removeUserShippingPost (@RequestBody String id) {

        userShippingService.removeById(Long.parseLong(id));

        return new ResponseEntity ("User Shipping deleted Successfully", HttpStatus.OK);

    }

    @RequestMapping(value = "/setDefault", method = RequestMethod.POST)
    private ResponseEntity setDefaultShipping(@RequestBody String id, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        userService.setUserShippingDefault(Long.parseLong(id), user);

        return new ResponseEntity ("Set Default Shipping Successfully", HttpStatus.OK);

    }
}
