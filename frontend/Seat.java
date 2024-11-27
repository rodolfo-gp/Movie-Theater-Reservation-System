package frontend;
public class Seat {
    private char row;
    private int number;
    private boolean booked;

    public Seat(char row, int number) {
        this.row = row;
        this.number = number;
        this.booked = false;
    }

    public char getRow() {
        return this.row;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean getBooked() {
        return this.booked;
    }

    public void setBooked(boolean booking) {
        this.booked = booking;
    }
}
