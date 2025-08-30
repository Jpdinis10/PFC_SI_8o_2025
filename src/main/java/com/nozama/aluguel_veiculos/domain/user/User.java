package com.nozama.aluguel_veiculos.domain.user;

import com.nozama.aluguel_veiculos.dto.UserRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "email")
public class User {

    @Id
    private String email;

    private String password;

    public User(UserRequest userRequest) {
        this.email = userRequest.email();

        this.password = userRequest.password();

    }
}
