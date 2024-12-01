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
    private Integer showroom_id;

    @Column(name = "dateAndTime")
    private LocalDateTime dateAndTime;
    
    public Seat(){
        
    }
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

    public Integer getShowroomId() {
        return showroom_id;
    }

    public void setShowroomId(Integer showroomId) {
        this.showroom_id = showroomId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
