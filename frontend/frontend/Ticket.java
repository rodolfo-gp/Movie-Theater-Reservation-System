package frontend;

//import org.json.*;

public class Ticket {
    private int ticket_ID;
    private float price;
    //private Payment payment;
    static int ticketcount = 0;

    public Ticket(){
        this.ticket_ID = ticketcount;
        ticketcount++;
    }

    public void setPrice(float inprice){
        this.price = inprice;
    }
    /* 
    public void setPayment(float inpayment){
        this.payment = inpayment;
    }
    */
    public float getPrice(){
        return this.price;
    }

    public int getTicket_ID(){
        return this.ticket_ID;
    }
}
