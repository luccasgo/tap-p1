package com.atividadde1.atividade1.models.DTOs;

import com.atividadde1.atividade1.models.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostRequestDTO(Long id,
                             String text,
                             LocalDateTime date,
                             User user) {
}
