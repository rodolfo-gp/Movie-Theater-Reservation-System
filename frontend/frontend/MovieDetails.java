package frontend;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDetails {
    
    public void createWindow(Movie le_movie) {
        
        JFrame details = new JFrame();
        details.setSize(400, 300);
        details.setTitle(le_movie.getName());
        details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        details.setLayout(new GridLayout(4, 2));

        JLabel rel = new JLabel("Relesase Date: ");
        JLabel release = new JLabel(le_movie.release_Date.displayTime());

        JLabel dir = new JLabel("Director: ");
        JLabel director = new JLabel(le_movie.getDirector());

        JLabel des = new JLabel("Description: ");
        JLabel description = new JLabel(le_movie.getDesc());

        JButton back = new JButton("Back");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                details.dispose();
            }
        });


        details.add(rel);
        details.add(release);
        details.add(dir);
        details.add(director);
        details.add(des);
        details.add(description);
        details.add(back);

        details.setVisible(true);
        


          




    }

}
