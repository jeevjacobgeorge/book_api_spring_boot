package com.example.bookapi.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "app_user")
public class User {
      @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(unique = true,nullable = false)
      private String username;

      @Column(unique = true,nullable = false)
      private String email;

      @Column(nullable = false)
      private String password;  //hashed

      @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
      private List<Order> orders = new ArrayList<>();

}