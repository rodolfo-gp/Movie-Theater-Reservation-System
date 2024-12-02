package com.example.spring_boot_ensf480_api_server.models;

import java.io.Serializable;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Seats")
public class Seat implements Serializable{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "seat_row")
    private int seat_row;

    @Column(name = "seat_column")
    private int seat_column;

    @Column(name = "booked")
    private boolean booked;

    @Column(name = "showroom_id")
    private short showroom_id;

    @Column(name = "theater_id")
    private int theater_id;

    @Column(name = "date_and_time", columnDefinition = "DATETIME") 
    private LocalDateTime date_and_time;
    
    public Seat(){
        
    }

    public Seat(int id, int seat_row, int seat_column, boolean booked, short showroom_id, int theater_id, LocalDateTime date_and_time) { 
        this.id = id; 
        this.seat_row = seat_row;
        this.seat_column = seat_column;
        this.booked = booked; 
        this.showroom_id = showroom_id;
        this.theater_id = theater_id;
        this.date_and_time = date_and_time; }

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getSeatRow() {
        return seat_row;
    }

    public void setSeatRow(int seatRow) {
        this.seat_row = seatRow;
    }

    public int getSeatColumn() {
        return seat_column;
    }

    public void setSeatColumn(int seat_column) {
        this.seat_column = seat_column;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public short getShowroomId() {
        return showroom_id;
    }

    public void setShowroomId(short showroomId) {
        this.showroom_id = showroomId;
    }

    public LocalDateTime getDateAndTime() {
        return date_and_time;
    }

    public void setDateAndTime(LocalDateTime date_and_time) {
        this.date_and_time = date_and_time;
    }

    
}
