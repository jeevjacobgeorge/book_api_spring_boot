package com.example.bookapi.model;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Author{
      @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
      
      private String fullName;

      @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)
      @JoinTable(name="author_books",joinColumns = @JoinColumn(name = "author_id"),inverseJoinColumns = @JoinColumn(name="book_id"))
      private Set<Book> written_books = new HashSet<>();
      
}
