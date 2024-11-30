package frontend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.color.*;

public class PurchaseTicket {
    
    public void createPurchasePage() {

        JFrame purchasePage = new JFrame();
        purchasePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        purchasePage.setLocationRelativeTo(null);  // Center the window
        purchasePage.setSize(600, 900);
        purchasePage.setLayout(new BorderLayout());

        JPanel purchasePanel = new JPanel();
        purchasePanel.setLayout(new BoxLayout(purchasePanel, BoxLayout.Y_AXIS)); 

        //if user not logged in 
        JTextField email = new JTextField();
        JTextField card_digits = new JTextField();
        JTextField ccv_code = new JTextField();
        JButton submit = new JButton("submit");

        email.setAlignmentX(Component.CENTER_ALIGNMENT); 
        email.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        email.setAlignmentY(0);
        email.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(email);
        
        card_digits.setAlignmentX(Component.CENTER_ALIGNMENT);
        card_digits.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        card_digits.setAlignmentY(200);
        card_digits.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(card_digits);

        ccv_code.setAlignmentX(Component.CENTER_ALIGNMENT); 
        ccv_code.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        ccv_code.setAlignmentY(400);
        ccv_code.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(ccv_code);
        
        
        submit.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);  
        submit.setAlignmentY(900);
        submit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        purchasePanel.add(submit);

        JScrollPane scrollPane = new JScrollPane(purchasePanel);
        purchasePage.add(scrollPane, BorderLayout.CENTER);

        purchasePage.add(purchasePanel);
        
        purchasePage.setVisible(true);
        
    }
    public static void main(String[] args) {
        PurchaseTicket test = new PurchaseTicket();
        test.createPurchasePage();
    }
}
