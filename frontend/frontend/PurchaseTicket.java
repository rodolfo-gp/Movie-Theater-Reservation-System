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
        JTextField email_Field = new JTextField();
        JTextField card_digit_Field = new JTextField();
        JTextField ccv_code_Field = new JTextField();
        JButton submit = new JButton("submit");

        JLabel text = new JLabel("Email");
        text.setAlignmentX(Component.LEFT_ALIGNMENT);
        email_Field.setAlignmentX(Component.CENTER_ALIGNMENT); 
        email_Field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        email_Field.setAlignmentY(0);
        email_Field.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(text);
        purchasePanel.add(email_Field);
        
        text = new JLabel("Card Number");
        card_digit_Field.setAlignmentX(Component.CENTER_ALIGNMENT);
        card_digit_Field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
        card_digit_Field.setAlignmentY(200);
        card_digit_Field.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(text);
        purchasePanel.add(card_digit_Field);

        text = new JLabel("CCV");
        ccv_code_Field.setAlignmentX(Component.CENTER_ALIGNMENT); 
        ccv_code_Field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        ccv_code_Field.setAlignmentY(400);
        ccv_code_Field.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));
        purchasePanel.add(text);
        purchasePanel.add(ccv_code_Field);

        //create ticket
        Ticket tck = new Ticket();
        tck.setPrice(9.99f);
    
        
        submit.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); 
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);  
        submit.setAlignmentY(900);
        submit.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchasePage.setVisible(false);
                String email = email_Field.getText();
                String code = card_digit_Field.getText();
                TicketDetail td = new TicketDetail();
                td.createReceipt(tck, email, code);
            }
        });

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
