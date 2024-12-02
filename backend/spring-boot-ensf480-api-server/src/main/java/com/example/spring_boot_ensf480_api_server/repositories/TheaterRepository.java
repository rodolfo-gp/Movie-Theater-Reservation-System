package com.example.spring_boot_ensf480_api_server.repositories;

import com.example.spring_boot_ensf480_api_server.models.Theater;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    List<Theater> findByMovies_MovieName(String movieName);
    
}






