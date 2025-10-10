package br.com.jvictornascimento.user.services.user;

import br.com.jvictornascimento.user.dtos.request.UserAdminDto;
import br.com.jvictornascimento.user.dtos.request.UserDto;
import br.com.jvictornascimento.user.dtos.request.UserUpdateDto;
import br.com.jvictornascimento.user.dtos.response.UserResponseDto;
import br.com.jvictornascimento.user.models.enums.UserType;
import br.com.jvictornascimento.user.producers.UserProducer;
import br.com.jvictornascimento.user.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements IUserService {
    private final UserRepository repository;
    private final IUserMapper userMapper;
    private final UserProducer producer;

    public UserServiceImp(UserRepository repository, IUserMapper userMapper, UserProducer producer) {
        this.repository = repository;
        this.userMapper = userMapper;
        this.producer = producer;
    }
    @Override
    @Transactional
    public UserResponseDto insert(UserDto userDto) {
        if (userDto.type() == UserType.ADMIN) {
            throw new RuntimeException("ADMIN users can't be created via this method");
        }

        var user = repository.save(userMapper.fromEntity(userDto));
        producer.publishMessageEmail("User registered successfully!", user);
        return userMapper.fromOut(user);
    }
    @Override
    public UserResponseDto insertUserAdmin(UserAdminDto userAdminDto){
        var user = userMapper.fromEntity(userAdminDto);
        user.setType(UserType.ADMIN);
        //adicionar um encriptador para a senha quando inserir o spring security
        producer.publishMessageEmail("User registered successfully!", user);
        return userMapper.fromOut(repository.save(user));

    }

    @Override
    @Transactional
    public UserResponseDto update(UUID id, UserUpdateDto userUpdateDto) {
        var user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.setName(userUpdateDto.name() != null ? userUpdateDto.name() : user.getName());
        user.setEmail(userUpdateDto.email() != null ? userUpdateDto.email() : user.getEmail());
        producer.publishMessageEmail("User updated successfully!", user);

        return userMapper.fromOut(user);
    }


    @Override
    @Transactional
    public void delete(UUID id) {
        var user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        repository.delete(user);
    }

    @Override
    public UserResponseDto findById(UUID id) {
        var user = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        return userMapper.fromOut(user);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return repository.findAll().stream().map(userMapper::fromOut).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDto> findUserOfTypeClient(){
        return repository.findAll().stream()
                .filter(u-> u.getType().equals(UserType.CLIENT))
                .map(userMapper::fromOut)
                .collect(Collectors.toList());
    }
    @Override
    public List<UserResponseDto> findUserOfTypeSeller(){
        return repository.findAll().stream()
                .filter(u-> u.getType().equals(UserType.SELLER))
                .map(userMapper::fromOut)
                .collect(Collectors.toList());
    }


}
