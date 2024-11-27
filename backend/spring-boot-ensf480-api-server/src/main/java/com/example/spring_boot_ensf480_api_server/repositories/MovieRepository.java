package com.example.spring_boot_ensf480_api_server.repositories;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot_ensf480_api_server.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
    // JpaRepository already provides findAll() and findById(String) methods.

}
