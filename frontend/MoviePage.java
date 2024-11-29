package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MoviePage implements BaseWindow {

    @Override
    public void createWindow() {
        // Create the main frame for the movie page
        JFrame moviePage = new JFrame("Movie Browser");
        moviePage.setSize(1080, 720);
        moviePage.setLocationRelativeTo(null);  // Center the window
        moviePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviePage.setLayout(new BorderLayout());

        // Create a panel to hold movie buttons
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        // Mock list of movies (this will later be fetched from a server)
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Deadpool");
        movies.add("Boss Baby");
        movies.add("Shrek");
        movies.add("Cars");
        movies.add("The Lego Movie");
        movies.add("Finding Fahmi");

        // Add each movie as a button
        for (String movie : movies) {
            JButton movieButton = new JButton(movie);
            movieButton.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the button
            movieButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));  // Stretch to full width

            // Action Listener for each movie button (left blank for now)
            movieButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Leave this blank for now
                    System.out.println(movie + " button clicked");
                }
            });

            // Add some padding around each button
            movieButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add the button to the panel
            moviePanel.add(movieButton);
        }

        // Add the movie panel to a scrollable pane
        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        moviePage.add(scrollPane, BorderLayout.CENTER);

        // Create a "Return to Home" button at the bottom
        JButton returnHomeButton = new JButton("Return to Home");
        returnHomeButton.setPreferredSize(new Dimension(moviePage.getWidth(), 50));
        returnHomeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listener for "Return to Home" button
        returnHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moviePage.dispose();  // Close the movie page window
                Startup startup = new Startup();
                startup.createWindow();  // Return to home screen
            }
        });

        // Add the "Return to Home" button at the bottom of the frame
        moviePage.add(returnHomeButton, BorderLayout.SOUTH);

        // Make the frame visible
        moviePage.setVisible(true);
    }
}
