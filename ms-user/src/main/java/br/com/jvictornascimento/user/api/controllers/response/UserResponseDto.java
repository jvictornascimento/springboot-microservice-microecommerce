package br.com.jvictornascimento.user.api.controllers.response;

import br.com.jvictornascimento.user.domain.enums.UserType;

import java.util.UUID;

public record UserResponseDto(

        UUID userId,
        String name,
        String email,
        UserType type
) {
}
