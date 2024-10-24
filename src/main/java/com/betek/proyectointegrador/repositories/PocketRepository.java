package com.betek.proyectointegrador.repositories;

import com.betek.proyectointegrador.models.Pocket;
import com.betek.proyectointegrador.models.PocketPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, PocketPrimaryKey> {
    long countByPocketPrimaryKey_ParentAccountNumber(String accountNumber);
    ArrayList<Pocket> findByPocketPrimaryKey_ParentAccountNumber(String accountNumber);

    Optional<Pocket> findByPocketPrimaryKey_PocketNumberAndPocketPrimaryKey_ParentAccountNumber(String pocketNumber, String ParentAccountNumber);
}
