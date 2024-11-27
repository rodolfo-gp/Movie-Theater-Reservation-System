package com.example.spring_boot_ensf480_api_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring_boot_ensf480_api_server.models.Show;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    
    // Finds shows by movie name (case-insensitive)
    List<Show> findByMovieNameIgnoreCase(String movieName);

    List<Show> findByTheaterId(int theaterId);

    List<Show> findByMovieNameIgnoreCaseAndTheaterId(String movieName, int theaterId);


}
