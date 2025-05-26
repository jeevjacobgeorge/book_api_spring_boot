package com.example.bookapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.model.User;
import com.example.bookapi.model.UserCreateDto;
import com.example.bookapi.model.UserResponseDto;
import com.example.bookapi.model.UserUpdateDto;
import com.example.bookapi.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {
      private final UserService userService;

      public UserController(UserService userService){
            this.userService = userService;
      }

      @PostMapping
      public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
            User created = userService.createUser(userCreateDto);
            UserResponseDto res = new UserResponseDto(created.getId(),created.getUsername(),created.getEmail());
          return ResponseEntity.ok(res);
      }
      
      @GetMapping("/{id}")
      public ResponseEntity<User> getUser(@PathVariable Long id){
            return userService.getUserById(id)
                  .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
      }

      @PutMapping("/{id}") //not working do with id 
      public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody UserUpdateDto user){
            return ResponseEntity.ok(userService.updateUser(id, user));
      }
      
      @DeleteMapping("/{id}")
      public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            Optional<User> userOpt = userService.getUserById(id);

            if (userOpt.isPresent()) {
                  userService.deleteUser(id);
                  return ResponseEntity.ok("User deleted successfully");
            } else {
                  return ResponseEntity.notFound().build();
            }
      }

      @GetMapping
      public List<User> getAllUsers(){
            return userService.getAllUsers();
      }

      @GetMapping("/test-first-level-cache/{id}")
      public void getMethodName(@PathVariable Long id) {
          userService.fetchUserTwice(id);
      }
      
}
