package com.nozama.aluguel_veiculos.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank String email,

        @NotBlank String password
) {
}
