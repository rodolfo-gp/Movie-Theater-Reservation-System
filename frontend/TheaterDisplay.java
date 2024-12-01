package frontend;

import javax.swing.*;

import frontend.BaseWindow;
import frontend.Startup;
import frontend.Theater;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TheaterDisplay implements BaseWindow{
 
    @Override
    public void createWindow(Movie Selected_Movie) {
        // Create the main frame for the movie page
        JFrame theaterPage = new JFrame("Theater Browser");
        theaterPage.setSize(1080, 720);
        theaterPage.setLocationRelativeTo(null);  // Center the window
        theaterPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theaterPage.setLayout(new BorderLayout());

        JPanel theaterPanel = new JPanel();
        theaterPanel.setLayout(new BoxLayout(theaterPanel, BoxLayout.Y_AXIS));

        ArrayList<Theater> theaters = new ArrayList<>();
        theaters.add("Westtown");
        theaters.add("Easttown");
        theaters.add("Downtown");
        theaters.add("Uptown");
        
        for (String theater : theaters){
            JButton theaterButton = new JButton(theater);
            theaterButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the button
            theaterButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));  // Stretch to full width


            // Action Listener for each movie button (left blank for now)
            theaterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Leave this blank for now
                    System.out.println(theater + " button clicked");
                }
            });

            // Add some padding around each button
            theaterButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add the button to the panel
            theaterPanel.add(theaterButton);
        }

        // Add the movie panel to a scrollable pane
        JScrollPane scrollPane = new JScrollPane(theaterPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        theaterPage.add(scrollPane, BorderLayout.CENTER);

        // Create a "Return to Home" button at the bottom
        JButton returnHomeButton = new JButton("Return to Home");
        returnHomeButton.setPreferredSize(new Dimension(theaterPage.getWidth(), 50));
        returnHomeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listener for "Return to Home" button
        returnHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theaterPage.dispose();  // Close the movie page window
                Startup startup = new Startup();
                startup.createWindow();  // Return to home screen
            }
        });

        // Add the "Return to Home" button at the bottom of the frame
        theaterPage.add(returnHomeButton, BorderLayout.SOUTH);

        // Make the frame visible
        theaterPage.setVisible(true);
    }

    public static void main(String[] args) {
        Startup test = new Startup();
        test.createWindow();
    }
}
