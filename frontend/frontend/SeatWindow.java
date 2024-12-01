package frontend;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class SeatWindow  {
    
    public void createSeats() {


        //GET SEAT MAP
        //this is mock data
        ArrayList<ArrayList<Seat>> seatMap = new ArrayList<>();
        char rowChar = 'A';

        for (int i = 0; i < 4; i++) {
            ArrayList<Seat> row = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                row.add(new Seat(rowChar, j));
            }
            seatMap.add(row);
            rowChar++; 
        }

        JFrame seatPage =  new JFrame();

        seatPage.setTitle("Seat Booking System");
        seatPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seatPage.setSize(800, 600);
        seatPage.setLayout(new GridLayout(4, 5, 5, 5)); // Grid layout for the seats
        seatPage.setLocationRelativeTo(null);

        // Add buttons for each seat
        for (ArrayList<Seat> row : seatMap) {
            for (Seat seat : row) {
                JButton seatButton = new JButton(seat.getRow() + "" + seat.getNumber());
                seatButton.setFont(new Font("Arial", Font.BOLD, 24));
                seatButton.setOpaque(true);
                seatButton.setBorderPainted(false);
                updateButtonColor(seatButton, seat.getBooked());

                // Add action listener to toggle booking status
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        seat.setBooked(!seat.getBooked()); // Toggle booking status
                        updateButtonColor(seatButton, seat.getBooked());
                        seatPage.setVisible(false);
                        PurchaseTicket t = new PurchaseTicket();
                        t.createPurchasePage();
                    }
                });

                seatPage.add(seatButton);
            }
        }

        seatPage.setVisible(true); // Display the JFrame
    }

    private void updateButtonColor(JButton button, boolean booked) {
        if (booked) {
            button.setBackground(Color.RED); // Booked seats are red
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.GREEN); // Available seats are green
            button.setForeground(Color.BLACK);
        }
    }

}

