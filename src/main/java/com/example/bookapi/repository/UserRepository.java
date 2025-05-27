package com.example.bookapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
      Optional<User> findByUsername (String username);   // Automatic Query Derivation from Method Names. 
                                                            //no need to write query

}
