package frontend;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;


public class TicketDetail {
    
    public void createReceipt(Ticket tck, String email, String card) 
    {

        // Create a JFrame
        JFrame receiptFrame = new JFrame("Receipt");
        receiptFrame.setSize(400, 300);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiptFrame.setLayout(new BorderLayout());
        receiptFrame.setLocationRelativeTo(null);

        // Add a title label
        JLabel titleLabel = new JLabel("Receipt", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        receiptFrame.add(titleLabel, BorderLayout.NORTH);

        // Create a panel for receipt details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add ticket information
        JLabel ticketLabel = new JLabel("Ticket Details:");
        ticketLabel.setFont(new Font("Arial", Font.BOLD, 16));
        detailsPanel.add(ticketLabel);

        JLabel ticketInfoLabel = new JLabel(tck.toString()); // Ensure Ticket has a meaningful toString() method
        ticketInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(ticketInfoLabel);

        // Add email information
        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(emailLabel);

        // Add card information (mask the card except last 4 digits)
        String maskedCard = "**** **** **** " + card.substring(card.length() - 4);
        JLabel cardLabel = new JLabel("Card: " + maskedCard);
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(cardLabel);

        // Add total price if available in the Ticket object
        JLabel priceLabel = new JLabel("Total Price: $" + tck.getPrice()); 
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsPanel.add(priceLabel);

        // Add a button to close the receipt
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.BOLD, 24 ));
        closeButton.addActionListener(e -> receiptFrame.dispose());
        detailsPanel.add(Box.createVerticalStrut(10)); // Add some space
        detailsPanel.add(closeButton);

        receiptFrame.add(detailsPanel, BorderLayout.CENTER);

        // Make the frame visible
        receiptFrame.setVisible(true);
    }

}

