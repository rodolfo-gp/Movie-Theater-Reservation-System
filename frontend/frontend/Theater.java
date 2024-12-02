package frontend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public static void getTheater(){
        try { // The URL to your theater endpoint 
            URL url = new URL("http://localhost:8080/theater/"); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
            conn.setRequestMethod("GET"); 
            // GET method to retrieve the theater 
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

    public static void main(String[] args) {
        Theater.getTheater();
    }
}
