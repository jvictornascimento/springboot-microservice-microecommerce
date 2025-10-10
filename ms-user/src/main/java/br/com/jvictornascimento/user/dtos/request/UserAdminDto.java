package br.com.jvictornascimento.user.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserAdminDto(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password
) {}
