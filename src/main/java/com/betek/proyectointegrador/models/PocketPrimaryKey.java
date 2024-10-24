package com.betek.proyectointegrador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Embeddable
public class PocketPrimaryKey implements Serializable {

    @Column(name = "pocket_number", nullable = false)
    private String pocketNumber;

    @Column(name = "parent_account_number", nullable = false)
    private String parentAccountNumber;
}
