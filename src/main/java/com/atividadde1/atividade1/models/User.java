package com.atividadde1.atividade1.models;


import com.atividadde1.atividade1.utils.Constans;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = Constans.GENERAL_MAX_LENGTH, nullable = false)
    private String username;

    @Column(length = Constans.GENERAL_MAX_LENGTH,nullable = false, unique = true)
    private String email;

    @Column(length = Constans.PHOTO_PATH)
    private String imagePath;

    private Boolean isActive = true;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

}
