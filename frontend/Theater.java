package src;

import org.json.*;
import java.util.ArrayList;

public class Theater {
    private String name;
    private String location;
    private ArrayList<Movies> movies;
    private ArrayList<Showroom> rooms;

    public Theater(){
        this.rooms = new ArrayList<>();
        this.movies = new ArrayList<>();
    }   

    public ArrayList<Movies> getMovies(){
        return this.movies;
    }

    public String getLocation(){
        return this.location;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Showroom> getShowrooms(){
        return this.rooms;
    }

    public void setName(String inname){
        this.name = inname;
    }

    public void setLocation(String inlocation){
        this.location = inlocation;
    }

    public void setMovies(ArrayList<Movies> inMovies){
        this.movies = inMovies;
    }

    public void setRooms(ArrayList<Showroom> inrooms){
        this.movies = inrooms;
    }    

    public void addMovies(Movies newMovie){
        this.movies.add(newMovie);
    }

    
}
