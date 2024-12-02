package frontend;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ShowtimeDisplay {
    
    public void show_Showtimes(Movie le_movie, Theater currtheater) {
        JFrame showtimePage = new JFrame("Showtimes");
        showtimePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showtimePage.setSize(300, 150);
        showtimePage.setLayout(new BorderLayout());
        showtimePage.setLocationRelativeTo(null);

        JButton confirm = new JButton("Confirm Showtime");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showtimePage.dispose();
                SeatWindow s = new SeatWindow();
                s.createSeats();
            }
        });

        showtimePage.add(confirm, BorderLayout.PAGE_END);

        ArrayList<Showtime> shows = Showtime.getShowTimes(le_movie, currtheater);

        ArrayList<String> times = new ArrayList<>();

        for (Showtime showtyme: shows) {
            times.add(showtyme.getShowTime().toString());
        }

        String[] showtimes_final = new String[times.size()];
        showtimes_final = times.toArray(showtimes_final);

        JComboBox<String> showsBox = new JComboBox<String>(showtimes_final);
        showtimePage.add(showsBox, BorderLayout.PAGE_START);
        showtimePage.setVisible(true);
    }
}
