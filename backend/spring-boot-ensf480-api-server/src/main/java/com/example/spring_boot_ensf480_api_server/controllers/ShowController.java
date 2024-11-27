package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Show;
import com.example.spring_boot_ensf480_api_server.repositories.ShowRepository;

@RestController
@RequestMapping("shows")
public class ShowController {

    private final ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping("/")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
