package com.atividadde1.atividade1.models.DTOs;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostResponseDTO(Long id,
                              String text,
                              LocalDateTime date,
                              Long userId,
                              String username) {
}
