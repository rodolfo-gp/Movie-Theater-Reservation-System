package com.example.spring_boot_ensf480_api_server.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_ensf480_api_server.models.Seat;
import com.example.spring_boot_ensf480_api_server.repositories.SeatRepository;


@RestController
@RequestMapping("/Seat")

public class SeatController {
    @Autowired
    private SeatRepository seatRepository;
    
    
    public SeatController(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    @GetMapping("/")
    public List<Seat> findAllSeats(){
        return seatRepository.findAll();
    }
    
    //customer already knows what seat they want (they have slected from a map) so we know id 
    public void bookSeat(Integer id){//get theater //showroom
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
    @GetMapping("/findSeat/{showroom}")
    public List<Seat> findAllAvailableSeats(@PathVariable int showroom) {
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
    


@GetMapping("/{showtime}") 
public List<Seat> findSeatsforShowtime(@PathVariable String showtime) { 
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
     LocalDateTime dateAndTime = LocalDateTime.parse(showtime, formatter); 
     if (dateAndTime == null) { throw new IllegalArgumentException("The date and time must not be null");
     } 
     List<Seat> seatsForShow = new ArrayList<>(); 
     List<Seat> allSeats = findAllSeats(); for (Seat seat : allSeats) { 
        LocalDateTime seatDateAndTime = seat.getDateAndTime(); 
        if (seatDateAndTime != null && seatDateAndTime.equals(dateAndTime)) { 
            seatsForShow.add(seat); 
        } } 
            
        return seatsForShow; }

}
