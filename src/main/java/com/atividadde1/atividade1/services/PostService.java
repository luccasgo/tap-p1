package com.atividadde1.atividade1.services;

import com.atividadde1.atividade1.models.DTOs.PostRequestDTO;
import com.atividadde1.atividade1.models.DTOs.PostResponseDTO;
import com.atividadde1.atividade1.models.Post;
import com.atividadde1.atividade1.models.mappers.PostMapper;
import com.atividadde1.atividade1.repositories.PostRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDTO> findAll(Long id) {
        List<Post> posts = postRepository.findAllByUserIdOrderByDateDesc(id);
        return PostMapper.toDTOs(posts);
    }

    public PostResponseDTO create(PostRequestDTO postDTO) {
        Post post = PostMapper.toEntity(postDTO);
        postRepository.save(post);
        return PostMapper.toDTO(post);
    }

    public PostResponseDTO update(Post post) {
//        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
