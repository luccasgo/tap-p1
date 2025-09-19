package com.atividadde1.atividade1.models.mappers;


import com.atividadde1.atividade1.models.DTOs.PostRequestDTO;
import com.atividadde1.atividade1.models.DTOs.PostResponseDTO;
import com.atividadde1.atividade1.models.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface PostMapper {

    public static PostResponseDTO toDTO(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .text(post.getText())
                .date(post.getDate())
                .userId(post.getUser().getId())
                .username(post.getUser().getUsername())
                .build();

    }

    public static List<PostResponseDTO> toDTOs(List<Post> posts) {
        List<PostResponseDTO> dtos = new ArrayList<>();
        for (Post post : posts) {
            dtos.add(PostResponseDTO.builder()
                    .id(post.getId())
                    .text(post.getText())
                    .date(post.getDate())
                    .userId(post.getUser().getId())
                    .username(post.getUser().getUsername())
                    .build());
        }
        return dtos;
    }

    public static Post toEntity(PostRequestDTO postDTO) {
        return Post.builder()
                .text(postDTO.text())
                .date(LocalDateTime.now())
                .user(postDTO.user())
                .build();

    }

    public static Post updatePost(PostRequestDTO postDTO,Post post) {
        post.setText(postDTO.text());
        return post;
    }
}
