package com.atividadde1.atividade1.models.DTOs;

import lombok.Builder;

@Builder
public record UserRequestDTO(String username,
                             String email,
                             String imagePath,
                             String message,
                             Boolean isActive){

}
