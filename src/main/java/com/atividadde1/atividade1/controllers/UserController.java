package com.atividadde1.atividade1.controllers;

import com.atividadde1.atividade1.models.DTOs.UserRequestDTO;
import com.atividadde1.atividade1.models.DTOs.UserResponseDTO;
import com.atividadde1.atividade1.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private ResponseEntity<List<UserResponseDTO>> getUsers() {
        return new ResponseEntity<List<UserResponseDTO>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO userDTO) {
        return new ResponseEntity<>(userService.create(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<UserResponseDTO> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
