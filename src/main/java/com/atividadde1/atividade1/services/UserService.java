package com.atividadde1.atividade1.services;

import com.atividadde1.atividade1.models.DTOs.UserRequestDTO;
import com.atividadde1.atividade1.models.DTOs.UserResponseDTO;
import com.atividadde1.atividade1.models.User;
import com.atividadde1.atividade1.models.mappers.UserMapper;
import com.atividadde1.atividade1.repositories.UserRepository;
import com.atividadde1.atividade1.utils.Menssages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(UserRequestDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    public List<UserResponseDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userDTOs = new ArrayList<>();
        if(users != null){
            for(User user : users){
                userDTOs.add(UserMapper.toDTO(user));
            }
        }
        return userDTOs;
    }

    public UserResponseDTO findById(Long id) {
        User user =  userRepository.findById(id).orElse(null);
        if(user == null){
            throw  new RuntimeException(Menssages.USER_NOT_FOUND);
        }
        return  UserMapper.toDTO(user);
    }

    public UserResponseDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserResponseDTO userDTO = null;
        if(user == null){
            throw  new RuntimeException(Menssages.USER_NOT_FOUND);
        }
        return UserMapper.toDTO(user);
    }

    public UserResponseDTO update(UserRequestDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.email());
        if (user == null) {
            throw new RuntimeException(Menssages.USER_NOT_FOUND);
        }
        User auxUser = UserMapper.updateUser(userDTO, user);
        userRepository.save(auxUser);
        return UserMapper.toDTO(auxUser);
    }

    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException(Menssages.USER_NOT_FOUND);
        }
            userRepository.deleteById(id);
    }

    public void deleteByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException(Menssages.USER_NOT_FOUND);
        }
        user.setIsActive(false);
        userRepository.save(user);
    }

}
