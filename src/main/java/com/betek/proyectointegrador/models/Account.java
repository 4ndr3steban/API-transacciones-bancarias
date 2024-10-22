package com.betek.proyectointegrador.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity(name = "ACCOUNTS")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Account {

    @Id
    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "owner_id", nullable = false)
    private Integer ownerId;

    @ManyToOne
    @JoinColumn(name = "owner_id", insertable = false, updatable = false, nullable = false)
    private User owner;

    @OneToMany(mappedBy = "parentAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Pocket> pockets;
}
