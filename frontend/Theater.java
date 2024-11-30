package frontend;

import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
    public static void getMoviebyTheater(Movie movie){
    try { 
        String movieName = movie.getName(); 
        String urlStr = String.format("http://localhost:8080/theater/%s", movieName); 
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
        conn.setRequestMethod("GET"); 
        // GET method to retrieve movies 
        conn.setRequestProperty("Content-Type", "application/json"); 
        // Check the response code 
        int responseCode = conn.getResponseCode(); 
        System.out.println("Response Code: " + responseCode); 
        if (responseCode == HttpURLConnection.HTTP_OK) { 
            // success 
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine; StringBuilder content = new StringBuilder(); 
            while ((inputLine = in.readLine()) != null) { 
                content.append(inputLine); 
            }
            // Close Connection
            in.close(); 
            conn.disconnect(); 
            System.out.println("Movies: " + content.toString());
         }

        }catch (Exception e) {
             e.printStackTrace(); }
    }

    
}
