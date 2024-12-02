package com.example.spring_boot_ensf480_api_server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;

@Entity  // Marks this class as a JPA entity
@Table(name = "Tickets")  // Maps to the Tickets table in the database
public class Ticket {

    @Id
    private int ticketId;  // Primary key

    private short seatRow;
    private short seatColumn;
    private int showId;
    
    @NotNull(message = "Ticket price cannot be null") // Add this annotation
    private BigDecimal ticketPrice;


    @Column(nullable = true)  // Can be null
    private String customerEmail;  

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public short getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(short seatRow) {
        this.seatRow = seatRow;
    }

    public short getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(short seatColumn) {
        this.seatColumn = seatColumn;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
