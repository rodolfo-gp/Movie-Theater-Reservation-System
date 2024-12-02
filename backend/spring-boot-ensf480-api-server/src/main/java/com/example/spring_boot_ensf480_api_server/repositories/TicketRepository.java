package com.example.spring_boot_ensf480_api_server.repositories;

import com.example.spring_boot_ensf480_api_server.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Custom method to find a ticket by showId, seatRow, and seatColumn
    Optional<Ticket> findByShowIdAndSeatRowAndSeatColumn(int showId, short seatRow, short seatColumn);
}
