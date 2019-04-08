package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.ShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
}
