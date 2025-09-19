package com.atividadde1.atividade1.services;

import com.atividadde1.atividade1.models.DTOs.PostRequestDTO;
import com.atividadde1.atividade1.models.DTOs.PostResponseDTO;
import com.atividadde1.atividade1.models.Post;
import com.atividadde1.atividade1.models.mappers.PostMapper;
import com.atividadde1.atividade1.repositories.PostRepository;
import com.atividadde1.atividade1.utils.Menssages;
import org.springframework.stereotype.Service;

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

    public PostResponseDTO findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException(Menssages.POST_NOT_FOUND);
        }
        return PostMapper.toDTO(post);
    }

    public PostResponseDTO create(PostRequestDTO postDTO) {
        Post post = PostMapper.toEntity(postDTO);
        postRepository.save(post);
        return PostMapper.toDTO(post);
    }

    public PostResponseDTO update(PostRequestDTO postDTO) {
        Post post = postRepository.findById(postDTO.id()).orElse(null);
        if (post == null) {
           throw new RuntimeException(Menssages.POST_NOT_FOUND);
        }
        Post auxPost = PostMapper.updatePost(postDTO, post);
        postRepository.save(auxPost);
        return PostMapper.toDTO(auxPost);
    }

    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException(Menssages.POST_NOT_FOUND);
        }
        postRepository.deleteById(id);
    }
}
