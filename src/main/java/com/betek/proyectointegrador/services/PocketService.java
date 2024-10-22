package com.betek.proyectointegrador.services;

import com.betek.proyectointegrador.repositories.PocketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PocketService {

    private final PocketRepository pocketRepository;
}
