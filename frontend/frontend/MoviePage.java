package frontend;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class MoviePage implements BaseWindow {
    
    public void createWindow() {

        JFrame moviePage = new JFrame();

        moviePage.setTitle("Movie Browser");
        moviePage.setSize(1600, 900);
        moviePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviePage.setLayout(new BorderLayout());

        JPanel moviePanel = new JPanel();
        moviePanel.setLayout(new BoxLayout(moviePanel, BoxLayout.Y_AXIS));

        //test with mock array list

        ArrayList<String> movies = new ArrayList<String>();
        movies.add("Deadpool");
        movies.add("Boss Baby");
        movies.add("Shrek");
        movies.add("Cars");
        movies.add("The Lego Movie");
        movies.add("Finding Fahmi");


        //add theatres----
        ArrayList<String> theatres = new ArrayList<String>();
        theatres.add("Chungus");
        theatres.add("That feeling when knee surgery tommorrow");
        theatres.add("Bingus");
        
        JPanel theatrePanel = new JPanel();
        theatrePanel.setLayout(new BorderLayout());

        String[] theatresArray = new String[theatres.size()];
        theatresArray = theatres.toArray(theatresArray);

        JComboBox<String> theatreSelect = new JComboBox<String>(theatresArray);
        theatrePanel.add(theatreSelect, BorderLayout.LINE_END);
        moviePage.add(theatrePanel, BorderLayout.LINE_END);
        //  end------

        for (String movie : movies) {

            JPanel row = new JPanel(new BorderLayout());
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            JLabel name = new JLabel(movie);
            name.setPreferredSize(new Dimension(100, 30));
            row.add(name, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton detailButton = new JButton("deez nuts");
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button pressed");
                }
            });

            JButton buyTicketButton = new JButton("Buy Ticket");
            buyTicketButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /* 
                    ShowtimeDisplay s = new ShowtimeDisplay();
                    s.show_Showtimes(movie);*/
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
                t.createWindow();
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


