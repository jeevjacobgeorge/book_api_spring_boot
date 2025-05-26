// package com.example.bookapi.repository;

// import java.util.List;
// import java.util.Optional;

// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.springframework.stereotype.Repository;

// import com.example.bookapi.model.Book;

// import org.springframework.transaction.annotation.Transactional;


// @Repository
// @Transactional // Apply transaction management to all public methods
// public class BookRepositoryAdapter implements BookRepository {

//     private final SessionFactory sessionFactory;

//     public BookRepositoryAdapter(SessionFactory sessionFactory) {
//         this.sessionFactory = sessionFactory;
//     }

//     private Session getSession() {
//         return sessionFactory.getCurrentSession(); // No openSession() needed
//     }

//     @Override
//     public void save(Book book) {
//         getSession().persist(book); // No transaction code needed
//     }

//     @Override
//     public Optional<Book> findById(Long id) {
//         return Optional.ofNullable(getSession().get(Book.class, id));
//     }

//     @Override
//     public List<Book> findAll() {
//         return getSession()
//                 .createQuery("FROM Book", Book.class)
//                 .getResultList();
//     }

//     @Override
//     public void update(Book book) {
//         getSession().merge(book);
//     }

//     @Override
//     public void delete(Book book) {
//         Book managedBook = getSession().get(Book.class, book.getId());
//         if (managedBook != null) {
//             getSession().remove(managedBook);
//         }
//     }
// }