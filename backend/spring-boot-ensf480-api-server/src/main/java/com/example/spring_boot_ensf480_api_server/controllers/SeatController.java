package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Seat;
import com.example.spring_boot_ensf480_api_server.repositories.SeatRepository;

@RestController
@RequestMapping("/api/v1/Seat")

public class SeatController {

    private SeatRepository seatRepository;
    
    public SeatController(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    @GetMapping("/")
    public List<Seat> findAllSeats(){
        return (List<Seat>) seatRepository.findAll();
    }
}
