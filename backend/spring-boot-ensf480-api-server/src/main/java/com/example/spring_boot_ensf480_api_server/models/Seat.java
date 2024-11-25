package com.example.spring_boot_ensf480_api_server.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seat implements Serializable{
    @Id
    private Long id;
    private char seat_row;
    private int number;
    private boolean booked;
    
    public Seat(){
        
    }
    public Seat(char seat_row, int number) {
        this.seat_row = seat_row;
        this.number = number;
        this.booked = false;
    }

    public char getRow() {
        return this.seat_row;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public void setBooked(boolean booking) {
        this.booked = booking;
    }
    public void setId(long id) {
        this.id = id;
    }
}