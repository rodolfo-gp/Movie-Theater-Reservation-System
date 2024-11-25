package src;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class MoviePage implements BaseWindow {
    
    public void createWindow() {

        JFrame moviePage = new JFrame();

        moviePage.setTitle("Movie Browser");
        moviePage.setSize(1600, 900);
        moviePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviePage.setLayout(new BorderLayout());

        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        ArrayList<String> movies = new ArrayList<String>();
        movies.add("Greg");
        movies.add("Boss Baby");
        movies.add("Shrek");

        for (String movie : movies) {
            JPanel movieItem = createMovieItem(movie);
            moviePanel.add(movieItem);
        }

        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        moviePage.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        moviePage.setVisible(true);
    }


    private JPanel createMovieItem(String movieName) {
            JPanel movieItem = new JPanel(new BorderLayout());
            movieItem.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            movieItem.setPreferredSize(new Dimension(750, 50)); // Set size for uniformity
    
            JLabel movieLabel = new JLabel(movieName);
            movieLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            movieLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    
            // Add components to the item panel
            movieItem.add(movieLabel, BorderLayout.CENTER);
    
            return movieItem;
        }
    




        
    }


