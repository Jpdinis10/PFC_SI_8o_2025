package com.nozama.aluguel_veiculos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").permitAll() // libera o endpoint /user
                        .anyRequest().authenticated() // outros endpoints precisam de autenticação
                );

        return http.build();
    }

}
