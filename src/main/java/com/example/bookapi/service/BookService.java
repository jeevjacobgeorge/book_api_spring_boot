package com.example.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;

@Service
public class BookService {
      private final BookRepository bookRepository;

      public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
      }
      
      public List<Book> getAllBooks(){
            return bookRepository.findAll();
      }

      public Optional<Book> getBookById(Long id){
            return bookRepository.findById(id);
      }

      public void createBook(Book book){
            bookRepository.save(book);
      }

      public boolean deleteBook(Long id) {
          Optional<Book> book = bookRepository.findById(id);
          if ( book.isPresent() ) {
        	  bookRepository.delete(book.get());
        	  return true;
          }
          return false;
      }

      
}
