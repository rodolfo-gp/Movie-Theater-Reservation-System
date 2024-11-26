package src;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class SeatWindow implements BaseWindow {
    @Override
    public void createWindow() {

        //test array

        int[][] array = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 0, 1, 1},
            {1, 1, 0, 0}
        };

        JFrame seatMapFrame = new JFrame();
        seatMapFrame.setSize(600, 500);
        //get seats from sql
        seatMapFrame.setLayout(new GridLayout(array.length, array[0].length));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                // seat is taken
                if (array[i][j] == 1) {
                    JLabel seatLabel = new JLabel("Taken");
                    seatLabel.setBackground(Color.RED);
                    seatLabel.setOpaque(true);
                    seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    seatMapFrame.add(seatLabel);
                }
                //seat is not taken
                else {
                    JButton button = new JButton("$");
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    int row = i;
                    int col = j;

                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(seatMapFrame,
                            "Button pressed at (" + row + ", " + col + ")");
                        }
                    });

                    seatMapFrame.add(button);


                }
            }

        }
        seatMapFrame.setVisible(true);
    }
}
