package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MoviePage {

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

        // --- Mock Movie Data Setup ---
        Date_time movieReleaseDate = new Date_time(2023, 11, 20);
        Date_time showtime1 = new Date_time(2023, 11, 30, 19, 30);
        Date_time showtime2 = new Date_time(2023, 12, 1, 21, 0);

        Showtime st1 = new Showtime(showtime1, 1);
        Showtime st2 = new Showtime(showtime2, 2);

        ArrayList<Showtime> showtimesList = new ArrayList<>();
        showtimesList.add(st1);
        showtimesList.add(st2);

        Movie movie1 = new Movie("The Grand Adventure", movieReleaseDate, "An epic journey.", "John Doe", showtimesList);
        Movie movie2 = new Movie("Comedy Nights", new Date_time(2023), "A hilarious comedy.", "Jane Smith", new ArrayList<>());

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);

        // --- Display Movies ---
        for (Movie movie : movieList) {
            JPanel row = new JPanel(new BorderLayout());
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            row.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel name = new JLabel(movie.getName());
            name.setFont(new Font("Arial", Font.BOLD, 16));
            row.add(name, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            JButton detailButton = new JButton("Movie Details");
            detailButton.addActionListener(e -> {
                MovieDetails details = new MovieDetails();
                details.createWindow(movie);
                System.out.println("Movie details clicked for: " + movie.getName());
            });

            JButton buyTicketButton = new JButton("Buy Ticket");
            buyTicketButton.addActionListener(e -> {
                ShowtimeDisplay s = new ShowtimeDisplay();
                s.show_Showtimes(movie);
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

        // Add "Browse Theaters" button at the bottom
        JButton browseTheatersButton = new JButton("Browse Theaters");
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
