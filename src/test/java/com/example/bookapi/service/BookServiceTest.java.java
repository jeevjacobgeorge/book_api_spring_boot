package com.example.bookapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book One");

        book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book Two");
    }

    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.getAllBooks();

        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testGetBookById_Found() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));

        Optional<Book> result = bookService.getBookById(1L);

        assertTrue(result.isPresent());
        assertEquals("Book One", result.get().getTitle());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBookById_NotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Book> result = bookService.getBookById(99L);

        assertFalse(result.isPresent());
        verify(bookRepository, times(1)).findById(99L);
    }

    @Test
    void testCreateBook() {
        doAnswer(invocation -> {
            Book b = invocation.getArgument(0);
            b.setId(3L);
            return null;
        }).when(bookRepository).save(any(Book.class));

        Book newBook = new Book();
        newBook.setTitle("New Book");

        bookService.createBook(newBook);

        assertNotNull(newBook.getId());
        verify(bookRepository, times(1)).save(newBook);
    }

    @Test
    void testDeleteBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).delete(book1);
    }

    @Test
    void testDeleteBook_NotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());

        bookService.deleteBook(99L);

        verify(bookRepository, times(1)).findById(99L);
        verify(bookRepository, never()).delete(any(Book.class));
    }
}
