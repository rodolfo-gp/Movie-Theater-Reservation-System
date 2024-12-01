package frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDetails {
    
    // Method to create a window with movie details
    public void createWindow(Movie le_movie) {
        
        // Create a new frame for the movie details window
        JFrame details = new JFrame();
        details.setSize(400, 300);  // Set size of the window
        details.setTitle(le_movie.getName());  // Set title of the window (movie name)
        details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the window is closed
        details.setLayout(new GridLayout(4, 2));  // Use a grid layout for placing components
        
        // Labels to display movie details
        JLabel rel = new JLabel("Release Date: ");
        JLabel release = new JLabel(le_movie.getRelease_date().toString());  // Get the formatted release date from Date_time
        
        JLabel dir = new JLabel("Director: ");
        JLabel director = new JLabel(le_movie.getDirector());  // Get the director of the movie
        
        // A button to go back to the previous screen (close the details window)
        JButton back = new JButton("Back");
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details.dispose();  // Close the details window
            }
        });

        // Add the labels and button to the window
        details.add(rel);
        details.add(release);
        details.add(dir);
        details.add(director);
        details.add(back);  // Add the back button

        details.setVisible(true);  // Make the window visible
    }
}
