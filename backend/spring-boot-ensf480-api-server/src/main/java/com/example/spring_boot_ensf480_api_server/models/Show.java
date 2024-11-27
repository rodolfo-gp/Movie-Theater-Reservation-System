package com.example.spring_boot_ensf480_api_server.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;

    @Column(name = "ticket_price", nullable = false)
    private BigDecimal ticketPrice;

    @Column(name = "theater_id", nullable = false)
    private int theaterId;

    @Column(name = "showroom_id", nullable = false)
    private short showroomId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "date_and_time")
    private LocalDateTime dateAndTime;

    @Column(name = "seat_map", columnDefinition = "JSON")
    private String seatMap;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(String seatMap) {
        this.seatMap = seatMap;
    }

    // Default Constructor (No-args)
    public Show() {
    }

    // Constructor with all fields (except ID for new entries)
    public Show(BigDecimal ticketPrice, int theaterId, short showroomId, String movieName, LocalDateTime dateAndTime, String seatMap) {
        this.ticketPrice = ticketPrice;
        this.theaterId = theaterId;
        this.showroomId = showroomId;
        this.movieName = movieName;
        this.dateAndTime = dateAndTime;
        this.seatMap = seatMap;
    }

    // Constructor with all fields (including ID, for updates or full initialization)
    public Show(Long id, BigDecimal ticketPrice, int theaterId, short showroomId, String movieName, LocalDateTime dateAndTime, String seatMap) {
        this.id = id;
        this.ticketPrice = ticketPrice;
        this.theaterId = theaterId;
        this.showroomId = showroomId;
        this.movieName = movieName;
        this.dateAndTime = dateAndTime;
        this.seatMap = seatMap;
    }
}
