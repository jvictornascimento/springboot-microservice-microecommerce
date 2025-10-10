package br.com.jvictornascimento.user.dtos.response;

import br.com.jvictornascimento.user.models.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserResponseDto(

        UUID userId,
        String name,
        String email,
        UserType type
) {
}
