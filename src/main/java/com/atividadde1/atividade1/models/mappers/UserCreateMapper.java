package com.atividadde1.atividade1.models.mappers;

import com.atividadde1.atividade1.models.DTOs.UserDTO;
import com.atividadde1.atividade1.models.User;

public class UserCreateMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO(
                user.getUsername(),
                user.getEmail(),
                user.getMessage(),
                user.getImagePath(),
                user.getIsActive()
        );
        return dto;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setMessage(userDTO.message());
        user.setImagePath(userDTO.imagePath());
        return user;
    }
}
