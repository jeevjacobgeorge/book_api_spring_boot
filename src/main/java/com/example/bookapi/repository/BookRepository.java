package com.example.bookapi.repository;

import com.example.bookapi.model.Book;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // You can add custom query methods if needed later  

} 





// //tO USE HIBERNATE SESSION
// import java.util.List;
// import java.util.Optional;
// public interface BookRepository {
//     void save(Book book);

//     Optional<Book> findById(Long id);

//     List<Book> findAll();

//     void update(Book book);

//     void delete(Book book);
// }


