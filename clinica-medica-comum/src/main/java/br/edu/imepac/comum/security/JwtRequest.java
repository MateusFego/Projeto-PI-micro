package br.edu.imepac.comum.security;

import jakarta.validation.constraints.NotBlank;

public record JwtRequest(
        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        String password
) {}
