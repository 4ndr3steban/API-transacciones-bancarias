package com.betek.proyectointegrador.repositories;

import com.betek.proyectointegrador.models.Pocket;
import com.betek.proyectointegrador.models.PocketPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, PocketPrimaryKey> {
}
