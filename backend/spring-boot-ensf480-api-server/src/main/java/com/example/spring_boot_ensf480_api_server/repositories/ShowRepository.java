package com.example.spring_boot_ensf480_api_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot_ensf480_api_server.models.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
    // No need to define findAll(), it’s inherited from JpaRepository
}
