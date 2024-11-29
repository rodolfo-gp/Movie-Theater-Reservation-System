package com.example.spring_boot_ensf480_api_server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @Column(name = "movie_name", nullable = false, length = 255)
    private String movieName;

    @Column(name = "director", length = 255)
    private String director;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany 
    private Set<Theater> theaters;
    // Default constructor
    public Movie() {
    }

    // Constructor
    public Movie(String movieName, String director, LocalDate releaseDate) {
        this.movieName = movieName;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    // Getters and Setters
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // toString() method for easy debugging
    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", director='" + director + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public Set<Theater> getTheaters() { 
        return theaters; 
    } 

    public void setTheaters(Set<Theater> theaters) {      
        this.theaters = theaters;
    }
}