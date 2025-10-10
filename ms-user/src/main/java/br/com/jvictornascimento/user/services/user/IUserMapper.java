package br.com.jvictornascimento.user.services.user;

import br.com.jvictornascimento.user.dtos.request.UserAdminDto;
import br.com.jvictornascimento.user.dtos.request.UserDto;
import br.com.jvictornascimento.user.dtos.response.UserResponseDto;
import br.com.jvictornascimento.user.models.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IUserMapper {
    UserResponseDto fromOut(UserModel userModel);
    UserModel fromEntity(UserDto userDto);
    UserModel fromEntity(UserAdminDto userAdminDto);
}
