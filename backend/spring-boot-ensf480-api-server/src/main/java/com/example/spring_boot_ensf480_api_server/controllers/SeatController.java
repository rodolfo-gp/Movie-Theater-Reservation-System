package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Seat;
import com.example.spring_boot_ensf480_api_server.repositories.SeatRepository;

@RestController
@RequestMapping("/Seat")

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
            
            if(!s.isBooked()){ //ensures that seat will no be booked twice
                //book the seat
                s.setBooked(true);
            }else{
                //give message that seat is already booked
               ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found");
            }
        }    
    }

    //find all seats avalable for that show room
    @GetMapping("/findSeat")
    public List<Seat> findAllAvailableSeats(int showroom) {
   
    List<Seat> seatlist = findAllSeats(); // Assuming findAllSeats() retrieves all the seats
    List<Seat> availableSeats = new ArrayList<>();

    // Loop through each seat and match the showrooms 
    for (Seat seat : seatlist) {
        if (!seat.isBooked() && seat.getShowroomId() == showroom) {
            availableSeats.add(seat);
        }
    }
    return availableSeats;
}

}
