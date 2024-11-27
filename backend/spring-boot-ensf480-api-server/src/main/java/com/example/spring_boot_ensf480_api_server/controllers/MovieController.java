package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Movie;
import com.example.spring_boot_ensf480_api_server.repositories.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Endpoint to get all movies
    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{movieName}")
    public Optional<Movie> getMovieByName(@PathVariable String movieName) {
        return movieRepository.findById(movieName);
    }

}
