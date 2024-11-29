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
        JTextField email = new JTextField(BorderLayout.PAGE_START);
        JTextField card_digits = new JTextField(BorderLayout.CENTER);
        JTextField ccv_code = new JTextField(BorderLayout.PAGE_END);
        JButton submit = new JButton(BorderLayout.LINE_END);

        String emailv = email.getText();
        String card_digitsv = card_digits.getText();
        String ccv_codev = ccv_code.getText();


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emailv != null && card_digitsv != null && ccv_codev != null ) {
                    //blah blah blah
                }
                
                    
            }
        });

        purchasePage.add(email);
        purchasePage.add(card_digits);
        purchasePage.add(ccv_code);
        purchasePage.add(submit);    
        
        purchasePage.setVisible(true);
        
    }
}
