package com.atividadde1.atividade1.models.mappers;


import com.atividadde1.atividade1.models.DTOs.PostRequestDTO;
import com.atividadde1.atividade1.models.DTOs.PostResponseDTO;
import com.atividadde1.atividade1.models.Post;

import java.util.ArrayList;
import java.util.List;

public interface PostMapper {

    public static PostResponseDTO toDTO(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .text(post.getText())
                .date(post.getDate())
                .user(post.getUser())
                .build();

    }

    public static List<PostResponseDTO> toDTOs(List<Post> posts) {
        List<PostResponseDTO> dtos = new ArrayList<>();
        for (Post post : posts) {
            dtos.add(PostResponseDTO.builder()
                    .id(post.getId())
                    .text(post.getText())
                    .date(post.getDate())
                    .user(post.getUser())
                    .build());
        }
        return dtos;
    }

    public static Post toEntity(PostRequestDTO postDTO) {
        return Post.builder()
                .text(postDTO.text())
                .date(postDTO.date())
                .user(postDTO.user())
                .build();

    }
}
