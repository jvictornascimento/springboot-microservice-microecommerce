package br.com.jvictornascimento.user.services.user;

import br.com.jvictornascimento.user.dtos.request.UserAdminDto;
import br.com.jvictornascimento.user.dtos.request.UserDto;
import br.com.jvictornascimento.user.dtos.request.UserUpdateDto;
import br.com.jvictornascimento.user.dtos.response.UserResponseDto;
import org.springframework.transaction.annotation.Transactional;

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
