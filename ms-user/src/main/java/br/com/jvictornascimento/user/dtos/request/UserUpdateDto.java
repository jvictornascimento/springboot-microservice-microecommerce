package br.com.jvictornascimento.user.dtos.request;

import br.com.jvictornascimento.user.models.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDto(
        String name,
        String email
) {
}
