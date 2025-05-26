package com.example.bookapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookapi.model.Author;
import com.example.bookapi.repository.AuthorRepository;

@Service
public class AuthorService {
      private final AuthorRepository authorRepository;

      public AuthorService(AuthorRepository authorRepository){
            this.authorRepository = authorRepository;
      }

      @Transactional(readOnly = true)
      public Optional<Author> getAuthorById(Long id){
            return authorRepository.findById(id);
      }

      @Transactional(rollbackFor = Exception.class )
      public void createAuthor(Author author){
            authorRepository.save(author);
      }

      // public updateAuthor(Author author){
      //       author
      // }

      
      @Transactional(rollbackFor = Exception.class )
      public void deleteAuthor(Long id){
            authorRepository.deleteById(id);
      }

      
}
