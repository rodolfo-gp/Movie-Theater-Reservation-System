package src;
import javax.swing.*;
import java.awt.*;

public class SeatDisplay extends JFrame {

    private Seat[][] seats;

    public SeatDisplay(Seat[][] seats) {
        this.seats = seats;
        setTitle("Seat Display");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to hold the seats in a grid layout
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(seats.length, seats[0].length, 5, 5));

        // Add each seat to the grid
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                Seat seat = seats[i][j];
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
        return String.format("Seat %c%d\n%s", seat.getRow(), seat.getNumber(), status);
    }

    public static void main(String[] args) {
        // Sample 2D array of Seat objects for testing
        Seat[][] seats = {
            { new Seat('A', 1), new Seat('A', 2), new Seat('A', 3) },
            { new Seat('B', 1), new Seat('B', 2), new Seat('B', 3) },
            { new Seat('C', 1), new Seat('C', 2), new Seat('C', 3) }
        };

        // Mark some seats as booked for demonstration
        seats[0][1].setBooked(true);
        seats[2][2].setBooked(true);

        // Display the seats in a JFrame
        SwingUtilities.invokeLater(() -> new SeatDisplay(seats));
    }
}

