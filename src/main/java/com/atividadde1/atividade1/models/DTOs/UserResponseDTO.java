package com.atividadde1.atividade1.models.DTOs;

import com.atividadde1.atividade1.models.Post;
import lombok.Builder;

import java.util.List;

@Builder
public record UserResponseDTO(Long id,
                              String username,
                              String email,
                              String imagePath,
                              String message,
                              Boolean isActive,
                              List<Post> posts) {
}
