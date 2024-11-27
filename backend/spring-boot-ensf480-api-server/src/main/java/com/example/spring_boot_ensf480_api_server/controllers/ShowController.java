package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Show;
import com.example.spring_boot_ensf480_api_server.repositories.ShowRepository;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    // Get all shows
    @GetMapping("/movies")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    // Get shows by movie name
    @GetMapping("/movies/{movieName}")
    public List<Show> getShowsByMovieName(@PathVariable String movieName) {
        return showRepository.findByMovieNameIgnoreCase(movieName);
    }

    // // Get shows by theater id
    @GetMapping("/theater/{theaterId}")
    public List<Show> getShowsByTheaterId(@PathVariable int theaterId) {
        return showRepository.findByTheaterId(theaterId);
    }

    @GetMapping("/movie-and-theater/{movieName}/{theaterId}")
    public List<Show> getShowsByMovieAndTheater(@PathVariable String movieName, @PathVariable int theaterId) {
        return showRepository.findByMovieNameIgnoreCaseAndTheaterId(movieName, theaterId);
    }


}
