package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring_boot_ensf480_api_server.models.Theater;
import com.example.spring_boot_ensf480_api_server.repositories.TheaterRepository;


@RestController
@RequestMapping("/theaters")

public class TheaterController {

    private final TheaterRepository theaterRepository;

    public TheaterController(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }
    
    //find all the theaters
    @GetMapping("/")
    public List<Theater> getAllTheaters() {
         return theaterRepository.findAll();
    }



     // Get all theaters showing movie
    @GetMapping("/{movieName}")
    public List<Theater> getTheatersByMovieName(@PathVariable String movieName) {
        return theaterRepository.findByMovies_MovieName(movieName);
    }

}

