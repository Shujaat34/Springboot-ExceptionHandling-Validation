package com.bukhari.exceptionhandlingvalidation.repository;

import com.bukhari.exceptionhandlingvalidation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Custom Exception Handling BookRepository
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
