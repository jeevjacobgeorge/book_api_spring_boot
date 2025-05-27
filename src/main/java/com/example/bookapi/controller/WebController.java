package com.example.bookapi.controller;
import com.example.bookapi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookapi.model.UserCreateDto;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("")
public class WebController {

    private final UserService userService;

    WebController(UserService userService) {
        this.userService = userService;
    }
      @GetMapping("")
      public String redirectToHome(){
            return "redirect:/home";
      }


      @GetMapping("/register")
      public String showRegistrationForm(Model model) {
            model.addAttribute("user",new UserCreateDto());
            return "register";
      }

      @PostMapping("/register")
      public String register(@ModelAttribute("user") UserCreateDto userCreateDto) {
            userService.createUser(userCreateDto);
            // User created = userService.createUser(userCreateDto);
            // UserResponseDto res = new UserResponseDto(created.getId(),created.getUsername(),created.getEmail());
            return "redirect:/register?success";
      }

      @GetMapping("/login")
            public String loginPage() {
            return "login"; // login.html in templates
      }


      
      
}

