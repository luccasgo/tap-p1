package com.atividadde1.atividade1.models.DTOs;

public record UserDTO(String username,
                      String email,
                      String imagePath,
                      String message,
                      Boolean isActive){

}
