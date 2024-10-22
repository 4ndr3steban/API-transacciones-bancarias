package com.betek.proyectointegrador.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity(name = "USERS")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    @Id
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Account> accounts;
}