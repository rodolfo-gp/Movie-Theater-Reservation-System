package com.example.spring_boot_ensf480_api_server.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Theaters")
public class Theater implements Serializable{
    @Id
    @Column(name = "theater_id", nullable = false)
    private int theater_id;

    @Column(name = "theater_name", nullable = false)
    private String name;

    @Column(name = "theater_address", nullable = false)
    private String address;

    @Column(name = "theater_city", nullable = false)
    private String city;

    @Column(name = "province_name", nullable = false)
    private String province;
    
    @ManyToMany(mappedBy = "theaters") 
    private Set<Movie> movies;

    public Theater(){

    }

    public Theater(Integer id, String theater_name, String theater_address, String theater_city, String province_name){
        this.theater_id=id;
        this.name=theater_name;
        this.address=theater_address;
        this.city=theater_city;
        this.province=province_name;
    }
    

   
    // Getters and Setters

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}


