package com.atividadde1.atividade1.repositories;

import com.atividadde1.atividade1.models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserIdOrderByDateDesc(Long id);
}
