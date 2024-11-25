package src;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;


public class LoginStartUp implements BaseWindow {
    @Override
    public void createWindow() {

        // this is all a test for login

        JFrame loginpage = new JFrame();

        loginpage.setTitle("Login");
        loginpage.setSize(400, 300);
        // Set default close operation to exit
        loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout to null
        loginpage.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Enter your name:");
        JTextField userField = new JTextField();
        
        JLabel passLabel = new JLabel("Enter your password:");
        JTextField passField = new JTextField();
        
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("");

        JButton signupButton = new JButton("Sign Up");
        JButton guestButton = new JButton("Continue as guest");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String password = passField.getText();
                resultLabel.setText("Submitted: " + user + ", " + password);
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginpage.setVisible(false);
                MoviePage m = new MoviePage();
                m.createWindow();
            }
        });

        

        loginpage.add(userLabel);
        loginpage.add(userField);
        loginpage.add(passLabel);
        loginpage.add(passField);
        loginpage.add(submitButton);
        loginpage.add(resultLabel);
        loginpage.add(signupButton);
        loginpage.add(guestButton);

        // Make the frame visible
        loginpage.setVisible(true);
    }
    

    public static void main(String[] args) {
        LoginStartUp test = new LoginStartUp();
        test.createWindow();
    }
}
