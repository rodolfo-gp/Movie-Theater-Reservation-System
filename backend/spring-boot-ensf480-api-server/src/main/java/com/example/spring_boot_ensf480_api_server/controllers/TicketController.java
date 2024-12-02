package com.example.spring_boot_ensf480_api_server.controllers;

import com.example.spring_boot_ensf480_api_server.models.Ticket;
import com.example.spring_boot_ensf480_api_server.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;  // Import List
import java.util.Optional;  // Import Optional

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    // Get all tickets
    @GetMapping("/")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    // Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new ticket
    @PostMapping("/")
public ResponseEntity<String> createTicket(@RequestBody Ticket ticket) {
    // Validate ticket price
    ticket.printTicketDetails();
    if (ticket.getTicketPrice() == null) {
        return new ResponseEntity<>("Ticket price is required.", HttpStatus.BAD_REQUEST);
    }

    // Check if a ticket already exists for the given show_id, seat_row, and seat_column
    Optional<Ticket> existingTicket = ticketRepository.findByShowIdAndSeatRowAndSeatColumn(ticket.getShowId(), ticket.getSeatRow(), ticket.getSeatColumn());
    if (existingTicket.isPresent()) {
        // Seat is already taken
        return new ResponseEntity<>("The seat is already taken.", HttpStatus.BAD_REQUEST);
    }

    // Save the new ticket
    ticketRepository.save(ticket);

    // Return success message
    return new ResponseEntity<>("Ticket successfully created.", HttpStatus.CREATED);
}

}
