package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MoviePage {

    public static Theater selectedTheater;

    public void createWindow() {
        // Create the main frame for the movie page
        JFrame moviePage = new JFrame("Movie Browser");
        moviePage.setSize(1600, 900);
        moviePage.setLocationRelativeTo(null);
        moviePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviePage.setLayout(new BorderLayout());

        // Panel to hold the list of movies
        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        ArrayList<Movie> movieList = Movie.getMovies();

        if (selectedTheater == null) {  // If no theater selected, default to the first theater
            selectedTheater = new Theater();
            selectedTheater.setTheaterId(1);
            selectedTheater.setName("Cineplex Calgary Default");
            selectedTheater.setLocation("123 Default St");
        }

        // --- Display Movies ---
        for (Movie movie : movieList) {
            JPanel row = new JPanel(new BorderLayout());
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            row.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

            JLabel name = new JLabel(movie.getName());
            name.setFont(new Font("Arial", Font.BOLD, 32));
            row.add(name, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            JButton detailButton = new JButton("Movie Details");
            detailButton.setFont(new Font("Arial", Font.BOLD, 24));
            detailButton.addActionListener(e -> {
                MovieDetails details = new MovieDetails();
                details.createWindow(movie);
                System.out.println("Movie details clicked for: " + movie.getName());
            });

            JButton buyTicketButton = new JButton("Buy Ticket");
            buyTicketButton.setFont(new Font("Arial", Font.BOLD, 24));
            buyTicketButton.addActionListener(e -> {
                ShowtimeDisplay s = new ShowtimeDisplay();
                s.show_Showtimes(movie, selectedTheater);
                System.out.println("Buy ticket clicked for: " + movie.getName());
            });

            buttonPanel.add(detailButton);
            buttonPanel.add(buyTicketButton);
            row.add(buttonPanel, BorderLayout.EAST);

            moviePanel.add(row);
            moviePanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Add spacing between rows
        }

        // Scroll pane for movie panel
        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Add the scroll pane to the frame
        moviePage.add(scrollPane, BorderLayout.CENTER);

        // --- Display Selected Theater Information ---
        JPanel theaterInfoPanel = new JPanel();
        theaterInfoPanel.setLayout(new GridLayout(2, 1));
        theaterInfoPanel.setBorder(BorderFactory.createTitledBorder("Selected Theater"));

        JLabel theaterNameLabel = new JLabel("Theater: " + selectedTheater.getName());
        theaterNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        theaterInfoPanel.add(theaterNameLabel);

        JLabel theaterLocationLabel = new JLabel("Address: " + selectedTheater.getLocation());
        theaterLocationLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        theaterInfoPanel.add(theaterLocationLabel);

        moviePage.add(theaterInfoPanel, BorderLayout.NORTH);

        // Add "Browse Theaters" button at the bottom
        JButton browseTheatersButton = new JButton("Browse Theaters");////////////////////////////////This needs revamp
        browseTheatersButton.setPreferredSize(new Dimension(moviePage.getWidth(), 50));
        browseTheatersButton.addActionListener(e -> {
            ArrayList<Theater> theaterList = new ArrayList<>();  // Populate this with actual data
            theaterList.add(new Theater("Calgary Cineplex", "123 st"));
            TheaterDisplay t = new TheaterDisplay();
            t.createWindow(theaterList);
            moviePage.dispose();
        });

        moviePage.add(browseTheatersButton, BorderLayout.SOUTH);

        // Make the frame visible
        moviePage.setVisible(true);
    }
}
