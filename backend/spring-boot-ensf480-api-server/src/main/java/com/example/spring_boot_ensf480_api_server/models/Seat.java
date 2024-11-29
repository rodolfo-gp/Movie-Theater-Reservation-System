package com.example.spring_boot_ensf480_api_server.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seat implements Serializable{
    @Id
    private String id;
    private int seat_row;
    private int seat_column;
    private boolean booked;
    
    public Seat(){
        
    }
  public Seat(int seat_row, int seat_column, int showroom, int theater) {
        //seat id = ,theater,showroom, row number, seat number
        this.seat_row = seat_row;
        this.seat_column = seat_column;
        this.booked = false;
        this.id=Integer.toString(theater)+Integer.toString(showroom)+Integer.toString(seat_row)+Integer.toString(seat_column);
    }
    public int getRow() {
        return this.seat_row;
    }

    public int getSeat_column() {
        return this.seat_column;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public void setBooked(boolean booking) {
        this.booked = booking;
    }
    public void setId(String id) {
        this.id = id;
    }
     public String getid(){
        return this.id;
 
    }
}
