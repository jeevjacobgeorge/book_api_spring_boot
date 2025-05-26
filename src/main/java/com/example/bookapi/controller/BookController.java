package com.example.bookapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.model.Book;
import com.example.bookapi.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
      private final BookService bookService;

      public BookController(BookService bookService) {
            this.bookService = bookService;
      }

      @GetMapping
      public List<Book> getAllBooks(){
            return bookService.getAllBooks();
      }

      @PostMapping
      public void createBook(@RequestBody Book book){
            bookService.createBook(book);
      }

      @GetMapping("/{id}")
      public Book getBook(@PathVariable Long id) {
          return bookService.getBookById(id)
          .orElseThrow(() -> new RuntimeException("Book not Found"));
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<String> deleteBook(@PathVariable Long id){
            boolean deleted = bookService.deleteBook(id);
            if (deleted) {
            	return ResponseEntity.ok("Book"+ id+ " deleted successfully");
            }
            else {
            	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not exists");
            }
            
      }
      
}
