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
    
    //customer already knows what seat they want (they have slected from a map) so we know id 
    public void bookSeat(String id){//get theater //showroom
        Seat s;
        Optional<Seat> optionalSeat = seatRepository.findById(id); 
        if (optionalSeat.isPresent()) { 
            s = optionalSeat.get();
            
            if(s.getBooked()==false){ //ensures that seat will no be booked twice
                //book the seat
                s.setBooked(true);
            }else{
                //give message that seat is already booked
            }
        }    
    }

    //find all seats avalable for that show room/theater 
    public List<Seat> findAllAvailableSeats(int showroom, int theater) { 
        //find if seat id starts with theaternum and showroom
        List<Seat> seatlist= findAllSeats();
        List<Seat> availableSeats = new ArrayList<>();

            
        for(int i=0;i<seatlist.size();i++){
            ////seat id = theater, showroom, row number, seat number
            //find seats that id's start with correct theater and showroom 
            if(seatlist.get(i).getid().startsWith(Integer.toString(theater)+Integer.toString(showroom))==true){
                availableSeats.add(seatlist.get(i));
            };
        }
        return availableSeats;
    }
}
