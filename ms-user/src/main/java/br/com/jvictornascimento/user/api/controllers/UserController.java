package br.com.jvictornascimento.user.api.controllers;

import br.com.jvictornascimento.user.api.controllers.request.UserAdminDto;
import br.com.jvictornascimento.user.api.controllers.request.UserDto;
import br.com.jvictornascimento.user.api.controllers.request.UserUpdateDto;
import br.com.jvictornascimento.user.api.controllers.response.UserResponseDto;
import br.com.jvictornascimento.user.domain.services.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController()
@RequestMapping("/users")
public class UserController {
    private final UserServiceImp service;

    public UserController(UserServiceImp service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> insertUser (@RequestBody @Valid UserDto userDto){
        var newData = service.insert(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.userId()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }
    @PostMapping("/admins")
    public ResponseEntity<UserResponseDto> insertUserAdmin (@RequestBody @Valid UserAdminDto userAdminDto){
        var newData = service.insertUserAdmin(userAdminDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.userId()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id")UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable(name = "id")UUID id, @RequestBody @Valid UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(service.update(id, userUpdateDto));
    }

}
