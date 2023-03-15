package com.bukhari.exceptionhandlingvalidation.controller;

import com.bukhari.exceptionhandlingvalidation.classexception.LibBusinessException;
import com.bukhari.exceptionhandlingvalidation.entity.Book;
import com.bukhari.exceptionhandlingvalidation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Custom Exception Handling Controller
 */
@RestController
@RequestMapping("digital/lib")
public class LibraryController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        try {
            Book savedBook = bookService.addBook(book);
            return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
        } catch (LibBusinessException e) {
            LibBusinessException libex = new LibBusinessException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<LibBusinessException>(libex, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LibBusinessException libex = new LibBusinessException("804", "Something went wrong in controller");
            return new ResponseEntity<LibBusinessException>(libex, HttpStatus.BAD_REQUEST);
        }
    }
}
