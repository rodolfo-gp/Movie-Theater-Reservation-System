package frontend;

import frontend.Date_time;
import frontend.Showtime;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;

public class Movie {
    private String name;
    public Date_time release_Date;
    private String desc;  
    private String director;
    private ArrayList<Showtime> showtimes;

    public Movie(){
        this.showtimes = new ArrayList<>();
    }   

    public Movie(String inname, Date_time indate, String indesc, String indirector, ArrayList<Showtime> inshowtimes){
        this.name = inname;
        this.release_Date = indate;
        this.desc = indesc;
        this.director = indirector;
        this.showtimes = inshowtimes;
    }   

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getDirector(){
        return this.director;
    }

    public ArrayList<Showtime> getShowtimes(){
        return this.showtimes;
    }

    public Date_time getRelease_date(){
        return this.release_Date;
    }

    public void setName(String inname){
        this.name = inname;
    }
    
    public void setRelease_date(Date_time indate){
        this.release_Date = indate;
    }

    public void setDesc(String indesc){
        this.desc = indesc;
    }
    
    public void setShowtimes(ArrayList<Showtime> inshowtimes){
        this.showtimes = inshowtimes;
    }
    public static void getMovies(){
        try { // The URL to your movies endpoint 
            URL url = new URL("http://localhost:8080/movies/"); 
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

