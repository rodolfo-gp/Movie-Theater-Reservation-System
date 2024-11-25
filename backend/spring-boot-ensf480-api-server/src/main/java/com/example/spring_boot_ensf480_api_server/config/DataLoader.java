package com.example.spring_boot_ensf480_api_server.config;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.spring_boot_ensf480_api_server.repositories.SeatRepository;
import com.example.spring_boot_ensf480_api_server.models.Seat;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void run(String ...args) throws Exception{
        List<Seat>  seats = (List<Seat>) seatRepository.findAll();
        if(seats.size() ==0){
            char a='A';
            Seat seat1 = new Seat(a, 1);
            seat1.setId(1);
            seatRepository.save(seat1);

            
        }
        

    }
}
