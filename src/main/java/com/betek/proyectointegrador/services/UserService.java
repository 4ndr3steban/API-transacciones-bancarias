package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.dtos.UserDto;
import com.betek.proyectointegrador.exceptions.BusinessException;
import com.betek.proyectointegrador.exceptions.ErrorMessage;
import com.betek.proyectointegrador.models.User;
import com.betek.proyectointegrador.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto){

        if (userDto.getId()==null || userDto.getName()==null || userDto.getEmail()==null || userDto.getEmail()==null){
            throw new BusinessException(ErrorMessage.BAD_REQUEST);
        }

        ArrayList<Integer> registeredIds = new ArrayList<>();

        userRepository.findAll().stream()
                .forEach(user -> registeredIds.add(user.getId()));

        if(registeredIds.contains(userDto.getId())){
            throw new BusinessException(ErrorMessage.BAD_REQUEST);
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

    public UserDto getUser(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new BusinessException(ErrorMessage.BAD_REQUEST);
        }

        UserDto userDto = user.map(current -> UserDto.builder()
                .id(current.getId())
                .name(current.getName())
                .email(current.getEmail())
                .address(current.getAddress())
                .build())
                .orElseThrow(() ->new BusinessException((ErrorMessage.INTERNAL_ERROR)));

        return userDto;
    }

    public void deleteUser(Integer id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new BusinessException(ErrorMessage.BAD_REQUEST);
        }

        userRepository.deleteById(id);
    }


}
