package com.example.bookapi.model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name="BOOK_TITLE",length=100,nullable=false)
      private String title;

      @Column(name="BOOK_RELEASE_DATE",nullable = true )
      private Date date;
      
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name="order_id")
      private Order order;

      @ManyToMany(mappedBy = "written_books")
      private Set <Author> authors = new HashSet<>();
}


