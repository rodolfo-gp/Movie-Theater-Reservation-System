package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring_boot_ensf480_api_server.models.Theater;
import com.example.spring_boot_ensf480_api_server.repositories.TheaterRepository;


@RestController
@RequestMapping("/theater")

public class TheaterController {

    private TheaterRepository theaterRepository;
    
    //find all the theaters
    @GetMapping("/theater/findAllTheaters")
    public List<Theater> findAllTheaters(){
        return (List<Theater>) theaterRepository.findAll();
    }
     // Get all theaters showing movie
    @GetMapping("/theater/{movieName}")
    public List<Theater> getShowsByMovieName(@PathVariable String movieName) {
        return theaterRepository.findMovie(movieName);
    }

}
