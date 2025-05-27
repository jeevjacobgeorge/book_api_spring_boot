package com.example.bookapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookapi.model.Book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class HomeController {
      private final BookRepository bookRepository;

      public HomeController(BookRepository bookRepository){
            this.bookRepository = bookRepository;
      }

      @GetMapping("")
      public String home(Model model) {
            List<Book> books = bookRepository.findAll();
            model.addAttribute("books", books);
            return "home";
      }
      
}
