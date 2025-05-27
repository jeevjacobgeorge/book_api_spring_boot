package com.example.bookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
      ////Only for Testing allows all requests
      // @Bean
      // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            // return http
            //         .csrf(csrf -> csrf.disable())
            //         .authorizeHttpRequests(auth -> auth
            //                         .anyRequest().permitAll()
            //         )
            //         .build();
            // }
            
            @Bean
            public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
                  return http
                  .authorizeHttpRequests(auth -> auth
                  .requestMatchers("/register","/css/**","/js/**").permitAll()
                  .anyRequest().authenticated()
                  )
                  .formLogin(form -> form
                  .loginPage("/login") 
                  .defaultSuccessUrl("/home",true)
                  .permitAll()
                  )
                  .logout(logout -> logout
                  .logoutSuccessUrl("/login?logout")
                  .permitAll()
                  ).build();
            }
            
            @Bean
            public PasswordEncoder passwordEncoder(){
                  return new BCryptPasswordEncoder();
            }
}
// Spring Security calls your custom service:
// Your MyUserDetailsService is used
//UserDetails user = myUserDetailsService.loadUserByUsername("entered_username");
