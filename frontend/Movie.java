package frontend;

import org.json.*;
import java.util.ArrayList;

public class Movie {
    private String name;
    private Date_time release_Date;
    private String desc;  
    private String director;
    private ArrayList<Showtime> showtimes;

    public Movie(){
        this.showtimes = new ArrayList<>();
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
}

