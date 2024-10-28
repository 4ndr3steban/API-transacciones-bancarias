package com.betek.proyectointegrador.controllers;

import com.betek.proyectointegrador.dtos.UserDto;
import com.betek.proyectointegrador.dtos.transfers.TransferResponseDto;
import com.betek.proyectointegrador.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Endpoint que permite crear un usuario para hacer pruebas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "El usuario se creo de forma exitosa",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "400" , description = "Hubo error de logica en la aplicacion o ingresaste mal los datos"),
    })
    @PostMapping("/createuser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

}
