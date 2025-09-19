package com.atividadde1.atividade1.models.mappers;

import com.atividadde1.atividade1.models.DTOs.UserRequestDTO;
import com.atividadde1.atividade1.models.DTOs.UserResponseDTO;
import com.atividadde1.atividade1.models.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .imagePath(user.getImagePath())
                .isActive(user.getIsActive())
                .posts(user.getPosts())
                .build();
    }

    public static User toEntity(UserRequestDTO userDTO) {
        return User.builder()
                .username(userDTO.username())
                .email(userDTO.email())
                .imagePath(userDTO.imagePath())
                .isActive(userDTO.isActive())
                .build();
    }

    public static User updateUser(UserRequestDTO userDTO, User user) {
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setImagePath(userDTO.imagePath());
        user.setIsActive(userDTO.isActive());
        return user;
    }
}
