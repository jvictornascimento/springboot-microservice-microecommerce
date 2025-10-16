package br.com.jvictornascimento.user.domain.services;

import br.com.jvictornascimento.user.api.controllers.request.UserAdminDto;
import br.com.jvictornascimento.user.api.controllers.request.UserDto;
import br.com.jvictornascimento.user.api.controllers.request.UserUpdateDto;
import br.com.jvictornascimento.user.api.controllers.response.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDto insert(UserDto userDto);

    UserResponseDto insertUserAdmin(UserAdminDto userAdminDto);

    UserResponseDto update(UUID id, UserUpdateDto userUpdateDto);

    void delete(UUID id);
    UserResponseDto findById(UUID id);
    List<UserResponseDto> findAll();

    List<UserResponseDto> findUserOfTypeClient();

    List<UserResponseDto> findUserOfTypeSeller();
}
