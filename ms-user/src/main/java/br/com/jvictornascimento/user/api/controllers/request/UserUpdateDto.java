package br.com.jvictornascimento.user.api.controllers.request;

public record UserUpdateDto(
        String name,
        String email
) {
}
