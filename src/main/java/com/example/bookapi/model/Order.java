package com.example.bookapi.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_order")
public class Order {
      @Id
      @GeneratedValue
      private Long id;
      
      @ManyToOne(fetch = FetchType.LAZY,optional=false)
      @JoinColumn(name="user_id")
      private User user;

      @OneToMany
      private List<Book> books = new ArrayList<>();



}
