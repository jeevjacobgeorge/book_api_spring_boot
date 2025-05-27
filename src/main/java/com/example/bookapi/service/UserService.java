package com.example.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookapi.model.User;
import com.example.bookapi.model.UserCreateDto;
import com.example.bookapi.model.UserUpdateDto;
import com.example.bookapi.repository.UserRepository;



@Service
public class UserService {
      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder; // Spring Security

      public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
      }

 
      @Transactional(rollbackFor = Exception.class )
      public User createUser(UserCreateDto userDto){
            User user = new User();
            user.setUsername(userDto.getUsername()); //TODO: handle null 
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            User res = userRepository.save(user);
            // int a = 5/0;   // to simulate runtime exception 
            return res;
      }

      
      @Transactional(rollbackFor = Exception.class)
      public User updateUser(Long id, UserUpdateDto userDto){
            User existingUser = userRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("User not found with id:"+ id ));
            
            if(userDto.getUsername() !=null)
                  existingUser.setUsername(userDto.getUsername());
            if(userDto.getEmail() != null)
                  existingUser.setEmail(userDto.getEmail());

            return userRepository.save(existingUser);
      }
      
      @Transactional(rollbackFor = Exception.class)
      public void deleteUser(Long id){
            userRepository.deleteById(id);
      }
      
      @Transactional(readOnly = true)
      public Optional<User> getUserById(Long id){
            return userRepository.findById(id);
      }

      @Transactional(readOnly = true)
      public List<User> getAllUsers(){
            return userRepository.findAll();
      }

      @Transactional
      public void fetchUserTwice(Long id) {
            System.out.println("🔍 First fetch:");
            User user1 = userRepository.findById(id).orElse(null);

            System.out.println("🔁 Second fetch:");
            User user2 = userRepository.findById(id).orElse(null);

            System.out.println("Are both references same? " + (user1 == user2));
      }
    
}
