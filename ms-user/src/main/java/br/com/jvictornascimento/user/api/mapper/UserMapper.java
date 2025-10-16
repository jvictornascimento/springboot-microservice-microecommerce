package br.com.jvictornascimento.user.api.mapper;

import br.com.jvictornascimento.user.api.controllers.request.UserAdminDto;
import br.com.jvictornascimento.user.api.controllers.request.UserDto;
import br.com.jvictornascimento.user.api.controllers.response.UserResponseDto;
import br.com.jvictornascimento.user.domain.models.UserModel;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {
    UserResponseDto fromOut(UserModel userModel);
    UserModel fromEntity(UserDto userDto);
    UserModel fromEntity(UserAdminDto userAdminDto);
}
