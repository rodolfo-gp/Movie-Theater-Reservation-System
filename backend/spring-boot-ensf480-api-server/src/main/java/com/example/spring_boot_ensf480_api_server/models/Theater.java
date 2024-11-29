package com.example.spring_boot_ensf480_api_server.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Theater implements Serializable{
    @Id
    @Column(name = "theater_id", nullable = false)
    private int theater_id;

    @Column(name = "theater_name", nullable = false)
    private String Name;

    @Column(name = "theater_address", nullable = false)
    private String address;

    @Column(name = "theater_city", nullable = false)
    private String city;

    @Column(name = "province_name", nullable = false)
    private String province;


    public Theater(){

    }

    public Theater(int id, String theater_name, String theater_address, String theater_city, String province_name){
        this.theater_id=id;
        this.Name=theater_name;
        this.address=theater_address;
        this.city=theater_city;
        this.province=province_name;
    }
    
}
