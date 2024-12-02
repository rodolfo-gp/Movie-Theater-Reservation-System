package frontend;

import java.util.ArrayList;

public class Theater {
    private String name;
    private String location;
    private int theater_id;
    private ArrayList<Movie> movies;
    //private ArrayList<Showroom> rooms;

    public Theater(){
        this.name = "This is dafault Theater Name";
        this.location = "default";
        this.theater_id = -1;
        this.movies = new ArrayList<>();
    }
    public Theater(String name, String location){
        this.name = name;
        this.location = location;
        this.theater_id = -1;
        this.movies = new ArrayList<>();
    }
    public Theater(String name, String location, int id){
        this.name = name;
        this.location = location;
        this.theater_id = id;
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
    public int getTheaterId(){
        return this.theater_id;
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
    public void setTheaterId(int id){
        this.theater_id = id;
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
