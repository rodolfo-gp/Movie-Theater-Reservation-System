package frontend;
public class Date_time {
    public int year;
    public int month;
    public int day;
    public Integer hour; // Set to Integer to allow null values
    public Integer minute;

    public Date_time(int month, int day, int hour, int minute) {
        this.year = 0;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    //second ctor for when you don't need minute and hour (movie release dates)
    public Date_time(int month, int day) {
        this.year = 0;
        this.month = month;
        this.day = day;
        this.hour = null;    
        this.minute = null;
    }

    //for when you need a release date (just year)
    public Date_time(int year) {
        this.year = year;
        this.month = 0;
        this.day = 0;
        this.hour = null;    
        this.minute = null;
    } 

    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public String displayTime() {
        String time = null;
        if (year == 0) {
            time = month + "/" + day + " " + hour + ":" + minute;
            return time;
        }
        else {
            time = String.valueOf(year);
            return time;
        }
    }
}
