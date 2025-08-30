package com.nozama.aluguel_veiculos.services;

import com.nozama.aluguel_veiculos.domain.user.User;
import com.nozama.aluguel_veiculos.dto.UserRequest;
import com.nozama.aluguel_veiculos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserRequest userRequest) {
        return  userRepository.save(new User(userRequest));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
