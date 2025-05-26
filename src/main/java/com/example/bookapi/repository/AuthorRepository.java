package com.example.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookapi.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
      
}
