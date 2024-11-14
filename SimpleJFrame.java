import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class SimpleJFrame {

    public static void main(String[] args) {
        Random rand = new Random();
        // Create a new JFrame
        JFrame frame = new JFrame("Movie Test");

        // Set the size of the frame
        frame.setSize(1600, 800);

        // Set default close operation to exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new button
        JButton button = new JButton("click if not gay");

        // Add an action listener to the button
        /* 
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog on button click
                //JOptionPane.showMessageDialog(frame, "try again");
                button.setBounds(rand.nextInt(1200), rand.nextInt(700), 160, 40);
            }
        });
        */

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBounds(rand.nextInt(1200), rand.nextInt(700), 160, 40);
            }
        });


        // Add button to the frame
        frame.add(button);

        // Set the layout to null
        frame.setLayout(null);

        // Set button size and location
        button.setBounds(150, 120, 160, 40);

        // Make the frame visible
        frame.setVisible(true);
    }
}
