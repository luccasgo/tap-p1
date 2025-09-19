package com.atividadde1.atividade1.controllers;

import com.atividadde1.atividade1.models.DTOs.PostRequestDTO;
import com.atividadde1.atividade1.models.DTOs.PostResponseDTO;
import com.atividadde1.atividade1.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    private PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list/{userId}")
    private ResponseEntity<List<PostResponseDTO>> getPostsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<List<PostResponseDTO>>(postService.findAll(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    private ResponseEntity<PostResponseDTO> create(@RequestBody PostRequestDTO postDTO) {
        return new ResponseEntity<>(postService.create(postDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    private ResponseEntity<PostResponseDTO> updatePost(@RequestBody PostRequestDTO postDTO) {
        try{
            return new ResponseEntity<>(postService.update(postDTO), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<PostResponseDTO> delete(@PathVariable Long id) {
        try{
            postService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
