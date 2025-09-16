package com.atividadde1.atividade1.models;


import com.atividadde1.atividade1.utils.Constans;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @Column(length = Constans.MESSAGE_LENGTH)
    private String message;

    private Boolean isActive = true;

}
