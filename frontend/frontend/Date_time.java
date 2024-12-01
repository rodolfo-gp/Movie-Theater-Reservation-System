package frontend;

public class Date_time {
    public int year;
    public int month;
    public int day;
    public Integer hour;  // Set to Integer to allow null values
    public Integer minute;

    // Constructor with full date and time
    public Date_time(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    // Constructor for release dates (without hour and minute)
    public Date_time(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = null;    
        this.minute = null;
    }

    // Constructor for just a year (default month and day to 1)
    public Date_time(int year) {
        this.year = year;
        this.month = 1;
        this.day = 1;
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

    // Override toString() method to display date and time
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%04d-%02d-%02d", year, month, day)); // YYYY-MM-DD

        // Only append time if hour and minute are not null
        if (hour != null && minute != null) {
            result.append(String.format(" %02d:%02d", hour, minute)); // HH:MM
        }
        return result.toString();
    }
}
