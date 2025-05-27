package com.example.bookapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookapi.model.User;
import com.example.bookapi.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

      private final UserRepository userRepository;

      public MyUserDetailsService(UserRepository userRepository){
            this.userRepository = userRepository;
      }

      @Override
      public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
            Optional<User> optionaluser = userRepository.findByUsername(username);

            User user = optionaluser.orElseThrow(()->{
                  System.out.println("User not found");
                  return new UsernameNotFoundException("User doesn't exist Please Register");});
            System.out.println("user exists"+user);
            return new org.springframework.security.core.userdetails.User(
                  user.getUsername(),
                  user.getPassword(),
                  new ArrayList<>()
            );
      }
}
