package com.atividadde1.atividade1.models;


import com.atividadde1.atividade1.utils.Constans;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> posts;

}
