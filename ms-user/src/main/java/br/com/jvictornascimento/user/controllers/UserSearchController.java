package br.com.jvictornascimento.user.controllers;

import br.com.jvictornascimento.user.dtos.request.UserAdminDto;
import br.com.jvictornascimento.user.dtos.request.UserDto;
import br.com.jvictornascimento.user.dtos.request.UserUpdateDto;
import br.com.jvictornascimento.user.dtos.response.UserResponseDto;
import br.com.jvictornascimento.user.services.user.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/users/search")
public class UserSearchController {
    private final UserServiceImp service;

    public UserSearchController(UserServiceImp service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable(name = "id")UUID id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/type/client")
    public ResponseEntity<List<UserResponseDto>> findUsersOfTypeClient(){
        return ResponseEntity.ok(service.findUserOfTypeClient());
    }
    @GetMapping("/type/seller")
    public ResponseEntity<List<UserResponseDto>> findUsersOfTypeSeller(){
        return ResponseEntity.ok(service.findUserOfTypeSeller());
    }
}
