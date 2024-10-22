package com.betek.proyectointegrador.repositories;

import com.betek.proyectointegrador.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
