package com.example.bookapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bookapi.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
      @Query("SELECT a FROM Author a WHERE fullName LIKE 'A%'")
      List<Author> findAuthorStartingWithA();

      @Query("SELECT COUNT(a) FROM Author a")
      Long countAuthors();
}
