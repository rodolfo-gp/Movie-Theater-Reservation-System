package frontend;

import java.util.ArrayList;

public class Theater {
    private String name;
    private String location;
    private ArrayList<Movie> movies;
    //private ArrayList<Showroom> rooms;

    public Theater(){
        //this.rooms = new ArrayList<>();
        this.movies = new ArrayList<>();
    }   

    public ArrayList<Movie> getMovies(){
        return this.movies;
    }

    public String getLocation(){
        return this.location;
    }

    public String getName(){
        return this.name;
    }
    /* 
    public ArrayList<Showroom> getShowrooms(){
        return this.rooms;
    }
    */
    public void setName(String inname){
        this.name = inname;
    }

    public void setLocation(String inlocation){
        this.location = inlocation;
    }

    public void setMovies(ArrayList<Movie> inMovies){
        this.movies = inMovies;
    }
    /* 
    public void setRooms(ArrayList<Showroom> inrooms){
        this.movies = inrooms;
    }    
*/
    public void addMovies(Movie newMovie){
        this.movies.add(newMovie);
    }

    
}
