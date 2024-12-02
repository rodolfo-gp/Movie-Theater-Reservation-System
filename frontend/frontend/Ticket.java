package frontend;

//import org.json.*;

public class Ticket {
    private int ticket_ID;
    private int row;
    private int column;
    private int show_ID;
    private float price;
    private String user_email;
    static int ticketcount = 0;

    public Ticket(){
        this.ticket_ID = ticketcount;
        ticketcount++;
    }

    public Ticket(int tID, int row, int column, int sID, float price, String email){
        this.ticket_ID = tID;
        this.row = row;
        this.column = column;
        this.show_ID = sID;
        this.price = price;
        this.user_email = email;
    }


 // Getter for ticket_ID
    public int getTicket_ID() {
        return ticket_ID;
    }

    // Setter for ticket_ID
    public void setTicket_ID(int ticket_ID) {
        this.ticket_ID = ticket_ID;
    }

    // Getter for row
    public int getRow() {
        return row;
    }

    // Setter for row
    public void setRow(int row) {
        this.row = row;
    }

    // Getter for column
    public int getColumn() {
        return column;
    }

    // Setter for column
    public void setColumn(int column) {
        this.column = column;
    }

    // Getter for show_ID
    public int getShow_ID() {
        return show_ID;
    }

    // Setter for show_ID
    public void setShow_ID(int show_ID) {
        this.show_ID = show_ID;
    }

    // Getter for price
    public float getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(float price) {
        this.price = price;
    }

    // Getter for user_email
    public String getUser_email() {
        return user_email;
    }

    // Setter for user_email
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
