package com.betek.proyectointegrador.dtos;


import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    private Integer id;
    private String name;
    private String email;
    private String address;
}
