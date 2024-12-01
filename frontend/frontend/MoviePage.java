package frontend;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoviePage {
    
    public void createWindow(Theater selectedTheatre) {

        JFrame moviePage = new JFrame();

        moviePage.setTitle("Movie Browser");
        moviePage.setSize(1600, 900);
        moviePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviePage.setLayout(new BorderLayout());

        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        //NEW MOCK DATA//

    // Create some Date_time objects for movies and showtimes
        Date_time movieReleaseDate = new Date_time(2023, 11, 20); // No specific hour/minute
        Date_time showtime1 = new Date_time(2023, 11, 30, 19, 30); // 7:30 PM
        Date_time showtime2 = new Date_time(2023, 12, 1, 21, 0); // 9:00 PM

        // Create showtime objects
        Showtime st1 = new Showtime(showtime1, 1);
        Showtime st2 = new Showtime(showtime2, 2);

        // Add showtimes to a movie
        ArrayList<Showtime> showtimesList = new ArrayList<>();
        showtimesList.add(st1);
        showtimesList.add(st2);

        // Create Movie objects
        Movie movie1 = new Movie("The Grand Adventure", movieReleaseDate, "An epic journey.", "John Doe", showtimesList);
        Movie movie2 = new Movie("Comedy Nights", new Date_time(2023), "A hilarious comedy.", "Jane Smith", new ArrayList<>());

        // Add movies to a list
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);

        // Create Theater objects and associate movies with them
        Theater theater1 = new Theater();
        theater1.setName("Cineplex");
        theater1.setLocation("40th Street");
        theater1.setMovies(movieList);

        Theater theater2 = new Theater();
        theater2.setName("Gronk theatre");
        theater2.setLocation("Brazil");
        theater2.addMovies(movie2);

        // Add theaters to a list
        ArrayList<Theater> theaterList = new ArrayList<>();
        theaterList.add(theater1);
        theaterList.add(theater2);

        //creating seperate list for conversion into string list
        ArrayList<String> theaterNameList = new ArrayList<>();
        for (Theater tht : theaterList) {
            theaterNameList.add(tht.getName());
        }

        
        JPanel theatrePanel = new JPanel();
        theatrePanel.setLayout(new BorderLayout());

        String[] theatresArray = new String[theaterNameList.size()];
        theatresArray = theaterNameList.toArray(theatresArray);

        JComboBox<String> theatreSelect = new JComboBox<String>(theatresArray);
        theatrePanel.add(theatreSelect, BorderLayout.LINE_END);
        moviePage.add(theatrePanel, BorderLayout.LINE_END);

        //checks for theater then gets it's movie list
        if (selectedTheatre != null) {
            movieList = selectedTheatre.getMovies();
        }


        for (Movie movie : movieList) {

            JPanel row = new JPanel(new BorderLayout());
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            JLabel name = new JLabel(movie.getName());
            name.setPreferredSize(new Dimension(100, 30));
            row.add(name, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton detailButton = new JButton("deez nuts");
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MovieDetails details = new MovieDetails();
                    details.createWindow(movie);
                    System.out.println("Button pressed");
                }
            });

            JButton buyTicketButton = new JButton("Buy Ticket");
            buyTicketButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ShowtimeDisplay s = new ShowtimeDisplay();
                    s.show_Showtimes(movie);
                }
            });

            

            buttonPanel.add(detailButton);
            buttonPanel.add(buyTicketButton);
            

            row.add(buttonPanel, BorderLayout.CENTER);

            row.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            moviePanel.add(row);

        }
        JButton theatreButton = new JButton("Select Theater");
        theatreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TheaterDisplay t = new TheaterDisplay();
                t.createWindow(theaterList);
                moviePage.setVisible(false);
                }
            });
        
        moviePage.add(theatreButton);
        JScrollPane scrollPane = new JScrollPane(moviePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
        moviePage.add(scrollPane, BorderLayout.LINE_START);

        // Make the frame visible
        moviePage.setVisible(true);
    }     
}


