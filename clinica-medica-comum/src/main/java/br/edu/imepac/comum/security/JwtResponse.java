package br.edu.imepac.comum.security;

import java.util.List;

public record JwtResponse(
        String token,
        String username,
        List<String> authorities
) {}
