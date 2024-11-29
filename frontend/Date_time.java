package frontend;

public class Date_time {
    public int year;
    public int month;
    public int day;
    public Integer hour; // Set to Integer to allow null values
    public Integer minute;

    // Constructor when hour and minute are provided
    public Date_time(int month, int day, int hour, int minute) {
        this.year = 0;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    // Constructor when only month and day are provided (for release date)
    public Date_time(int month, int day) {
        this.year = 0;
        this.month = month;
        this.day = day;
        this.hour = null;
        this.minute = null;
    }

    // Constructor when only year is provided (for year-only date)
    public Date_time(int year) {
        this.year = year;
        this.month = 0;
        this.day = 0;
        this.hour = null;
        this.minute = null;
    }

    // Getters
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

    // Display time as a String
    public String displayTime() {
        String time = null;
        if (year == 0) {
            if (hour != null && minute != null) {
                time = month + "/" + day + " " + hour + ":" + (minute < 10 ? "0" + minute : minute);
            } else {
                time = month + "/" + day;
            }
        } else {
            time = year + (month == 0 && day == 0 ? "" : "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
        }
        return time;
    }

    // Static method to parse a date string in the format "YYYY-MM-DD" or "YYYY-MM-DDTHH:MM"
    public static Date_time parseDate(String dateString) {
        if (dateString.contains("T")) {
            // Date with time, e.g. "2024-11-29T15:30"
            String[] dateTimeParts = dateString.split("T");
            String[] dateParts = dateTimeParts[0].split("-");
            String[] timeParts = dateTimeParts[1].split(":");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);

            return new Date_time(month, day, hour, minute);
        } else {
            // Date without time, e.g. "2024-11-29"
            String[] dateParts = dateString.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            return new Date_time(month, day);
        }
    }
}
