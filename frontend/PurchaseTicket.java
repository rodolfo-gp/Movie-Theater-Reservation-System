package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseTicket {
    
    public void createPurchasePage() {

        JFrame purchasePage = new JFrame();
        purchasePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        purchasePage.setSize(300, 300);
        purchasePage.setLayout(new BorderLayout());

        //if user not logged in 
        JTextField email = new JTextField();
        JTextField card_digits = new JTextField();
        JTextField ccv_code = new JTextField();
        JButton submit = new JButton();

        
    }
}
