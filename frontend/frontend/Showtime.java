package frontend;

public class Showtime {
    public Date_time show_time;
    public int showroom_num;

   
    public Showtime(Date_time show_time, int showroom_num) {
        this.show_time = show_time;
        this.showroom_num = showroom_num;
    }

    public Date_time getShowTime() {
        return show_time;
    }

    public int getShowroomNum() {
        return showroom_num;
    }
    
}
