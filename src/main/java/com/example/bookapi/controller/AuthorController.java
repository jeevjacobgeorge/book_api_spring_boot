package com.example.bookapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.model.Author;
import com.example.bookapi.service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {
      private final AuthorService authorService;

      public AuthorController(AuthorService authorService){
            this.authorService = authorService;
      }

      
      @PostMapping
      public ResponseEntity<Author> createAuthor(@RequestBody Author author){
           return ResponseEntity.ok(authorService.createAuthor(author)); 
      }

      @GetMapping("/{id}")
      public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
            Optional <Author> res = authorService.getAuthorById(id);
            return res.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build()); 
      }
            
      @DeleteMapping("/{id}")
      public void deleteAuthor(@PathVariable Long id){
            authorService.deleteAuthor(id);
      }

      @GetMapping("/startswithA")
      public  List<Author> findAuthorStartingWithA() {
          return authorService.findAuthorStartingWithA();
      }

      @GetMapping("/count")
      public ResponseEntity<Long> countAuthors() {
          return ResponseEntity.ok(authorService.countAuthors());
      }
      
      
}
