package com.betek.proyectointegrador.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "POCKETS")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Pocket {

    @EmbeddedId
    private PocketPrimaryKey pocketPrimaryKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "parent_account_number", insertable = false, updatable = false, nullable = false)
    private Account parentAccount;
}
