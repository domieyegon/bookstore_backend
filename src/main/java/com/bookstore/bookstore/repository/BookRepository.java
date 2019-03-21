
package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.domian.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
    
    List<Book> findByTitleContaining(String keyword);
    
}
