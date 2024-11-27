package com.example.spring_boot_ensf480_api_server.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Shows", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"show_id", "ticket_price"})
})
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Integer id;  // Using Integer for the INT AUTO_INCREMENT

    @Column(name = "ticket_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal ticketPrice;  // Represents DECIMAL(10, 2)

    @Column(name = "theater_id", nullable = false)
    private int theaterId;  // Foreign key to Theaters table

    @Column(name = "showroom_id", nullable = false)
    private short showroomId;  // Foreign key to Showrooms table

    @Column(name = "movie_name", nullable = false)
    private String movieName;  // Foreign key to Movies table

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;  // Corresponds to TIMESTAMP

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public short getShowroomId() {
        return showroomId;
    }

    public void setShowroomId(short showroomId) {
        this.showroomId = showroomId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    // Default Constructor
    public Show() {
    }

    // Constructor with all fields (except ID for new entries)
    public Show(BigDecimal ticketPrice, int theaterId, short showroomId, String movieName, LocalDateTime dateAndTime) {
        this.ticketPrice = ticketPrice;
        this.theaterId = theaterId;
        this.showroomId = showroomId;
        this.movieName = movieName;
        this.dateAndTime = dateAndTime;
    }

    // Constructor with all fields (including ID for updates or full initialization)
    public Show(Integer id, BigDecimal ticketPrice, int theaterId, short showroomId, String movieName, LocalDateTime dateAndTime) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.theaterId = theaterId;
        this.showroomId = showroomId;
        this.movieName = movieName;
        this.dateAndTime = dateAndTime;
    }
}
