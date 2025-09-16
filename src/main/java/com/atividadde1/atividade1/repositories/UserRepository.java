package com.atividadde1.atividade1.repositories;

import com.atividadde1.atividade1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);

    User findByEmail(String email);
}
