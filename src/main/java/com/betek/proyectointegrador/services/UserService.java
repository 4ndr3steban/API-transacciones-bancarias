package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.dtos.UserDto;
import com.betek.proyectointegrador.exceptions.BussinessException;
import com.betek.proyectointegrador.models.User;
import com.betek.proyectointegrador.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){

        if (userDto.getName().equals("Andres")){
            throw new BussinessException("no puedo ser yo");
        }
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .address(userDto.getAddress())
                .build();

        userRepository.save(user);
        return userDto;
    }
}
