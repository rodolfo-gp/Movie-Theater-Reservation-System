package frontend;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieDetails {
    
    public void createWindow(Movie le_movie)) {
        
        JFrame details = new JFrame();
        details.setSize(400, 300);
        details.setTitle(le_movie.getTitle());
        details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        details.setLayout(new GridLayout(3, 2));

        JLabel rel = new JLabel("Relesase Date: ");
        JLabel release = new JLabel(le_movie.release_date.displayTime());

        JLabel dir = new JLabel("Director: ");
        JLabel director = new JLabel(le_movie.getDirector());

        JLabel des = new JLabel("Description: ");
        JLabel description = new JLabel(le_movie.getDesc());

        details.add(rel);
        details.add(release);
        detials.add(dir);
        details.add(director);
        details.add(des);
        details.add(description);

        details.setVisible(true);
        


          




    }

}
