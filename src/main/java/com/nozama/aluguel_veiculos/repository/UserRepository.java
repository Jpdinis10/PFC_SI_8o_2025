package com.nozama.aluguel_veiculos.repository;

import com.nozama.aluguel_veiculos.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
