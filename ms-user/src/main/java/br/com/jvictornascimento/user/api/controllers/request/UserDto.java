package br.com.jvictornascimento.user.api.controllers.request;

import br.com.jvictornascimento.user.domain.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank(message = "Name required") String name,
        @NotBlank(message = "Email required") @Email String email,
        @NotNull(message = "Type required") UserType type
) {
}
