package com.bukhari.exceptionhandlingvalidation.service;

import com.bukhari.exceptionhandlingvalidation.classexception.LibBusinessException;
import com.bukhari.exceptionhandlingvalidation.entity.Book;
import com.bukhari.exceptionhandlingvalidation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Custom Exception Handling BookService
 */

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {

        //If the Name of the book is Empty
        if (book.getName().isEmpty()) {
            throw new LibBusinessException("801", "The Name of the Book can't be Empty");
        }
        //If the Name of the Author is Empty
        if (book.getAuthor().isEmpty()) {
            throw new LibBusinessException("802", "The Author's Name can't be Empty");
        }

        //If the Price is less than 10
        if (book.getPrice().intValue() < 10) {
            throw new LibBusinessException("803", "The Price of the Book must be $10 or greater than $10");
        }
        return bookRepository.save(book);
    }

}
