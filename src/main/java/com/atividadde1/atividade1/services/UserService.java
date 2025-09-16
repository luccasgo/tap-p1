package com.atividadde1.atividade1.services;

import com.atividadde1.atividade1.models.DTOs.UserDTO;
import com.atividadde1.atividade1.models.User;
import com.atividadde1.atividade1.models.mappers.UserCreateMapper;
import com.atividadde1.atividade1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserDTO userDTO) {
        User user = UserCreateMapper.toEntity(userDTO);
        userRepository.save(user);
        return UserCreateMapper.toDTO(user);
    }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        if(users != null){
            for(User user : users){
                userDTOs.add(UserCreateMapper.toDTO(user));
            }
        }
        return userDTOs;
    }

    public UserDTO findById(Long id) {
        User user =  userRepository.findById(id).orElse(null);
        UserDTO userDTO = null;
        if(user != null){
            userDTO = UserCreateMapper.toDTO(user);
        }
        return userDTO;
    }

    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserDTO userDTO = null;
        if(user != null){
            userDTO = UserCreateMapper.toDTO(user);
        }
        return userDTO;
    }

    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setIsActive(false);
            userRepository.save(user);
        }
    }

}
