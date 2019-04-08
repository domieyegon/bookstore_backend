package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.BillingAddress;
import org.springframework.data.repository.CrudRepository;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {
}
