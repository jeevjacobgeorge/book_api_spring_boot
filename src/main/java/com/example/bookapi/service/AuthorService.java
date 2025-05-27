package com.example.bookapi.service;

import java.util.List;
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

      @Transactional(rollbackFor = Exception.class )
      public Author createAuthor(Author author){
            return authorRepository.save(author);
      }

      @Transactional(readOnly = true)
      public Optional<Author> getAuthorById(Long id){
            return authorRepository.findById(id);
      }


      // public updateAuthor(Author author){
      //       author
      // }

      
      @Transactional(rollbackFor = Exception.class )
      public void deleteAuthor(Long id){
            authorRepository.deleteById(id);
      }

      @Transactional(readOnly = true)

      public List<Author> findAuthorStartingWithA(){
            return authorRepository.findAuthorStartingWithA();
      }

      @Transactional(readOnly = true)
      public Long countAuthors(){
            return authorRepository.countAuthors();
      }
      
}
