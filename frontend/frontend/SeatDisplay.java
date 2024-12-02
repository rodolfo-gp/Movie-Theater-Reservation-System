package frontend;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatDisplay extends JFrame {

    //private Seat[][] seats;

    public SeatDisplay(String showtime) {
        ArrayList<Seat> seats = Seat.getSeatsForShowtime(showtime);
        setTitle("Seat Display");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to hold the seats in a grid layout
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(5,15, 5, 5));

        // Add each seat to the grid
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                Seat seat = seats.get( i + j * 15);
                JLabel seatLabel = new JLabel(seatLabelText(seat), SwingConstants.CENTER);

                // Set background color based on booking status
                if (seat.getBooked()) {
                    seatLabel.setBackground(Color.RED); // Booked seats in red
                    seatLabel.setForeground(Color.WHITE);
                } else {
                    seatLabel.setBackground(Color.GREEN); // Available seats in green
                    seatLabel.setForeground(Color.BLACK);
                }

                seatLabel.setOpaque(true); // Make background color visible
                seatPanel.add(seatLabel);
            }
        }

        // Add the seat panel to the frame
        add(seatPanel);
        setVisible(true);
    }

    // Helper method to format the seat label text
    private String seatLabelText(Seat seat) {
        String status = seat.getBooked() ? "Booked" : "Available";
        return String.format("Seat %c%d\n%s", seat.getRow(), seat.getCloumn(), status);
    }

    // public static void main(String[] args) {
    //     // Sample 2D array of Seat objects for testing
    //     Seat[][] seats = {
    //         { new Seat('A', 1), new Seat('A', 2), new Seat('A', 3) },
    //         { new Seat('B', 1), new Seat('B', 2), new Seat('B', 3) },
    //         { new Seat('C', 1), new Seat('C', 2), new Seat('C', 3) }
    //     };

    //     // Mark some seats as booked for demonstration
    //     seats[0][1].setBooked(true);
    //     seats[2][2].setBooked(true);

    //     // Display the seats in a JFrame
    //     SwingUtilities.invokeLater(() -> new SeatDisplay(seats));
    // }
}

