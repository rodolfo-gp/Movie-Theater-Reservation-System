package frontend;
import javax.lang.model.type.NullType;
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

import frontend.RegisteredUser;


public class Startup implements BaseWindow {
    public static String baseURL = "localhost:8080";

    @Override
    public void createWindow() {

        RegisteredUser user = RegisteredUser.getUser();

        JFrame loginpage = new JFrame();

        loginpage.setTitle("Login");
        loginpage.setSize(1080, 720);
        // Set default close operation to exit
        loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout to null
        loginpage.setLayout(new GridLayout(4, 2));

        JLabel emailLabel = new JLabel("Enter your email:");
        JTextField emailField = new JTextField();
        
        JLabel passLabel = new JLabel("Enter your password:");
        JTextField passField = new JTextField();
        
        JButton logInButton = new JButton("Login");
        JLabel resultLabel = new JLabel("");

        JButton signupButton = new JButton("Sign Up");
        JButton guestButton = new JButton("Browse movies and more");

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passField.getText();
                user.setEmail(email);
                user.setPassword(password);
                System.out.println("Attempting Login...");
                RegisteredUser.logIn();
                if (user.get_is_logedIn()) {
                    System.out.println("login sucessful");
                    resultLabel.setText("login sucessful");
                    
                }else{
                    System.out.println("login failed");
                    resultLabel.setText("login failed");
                }
                
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = passField.getText();
                user.setEmail(email);
                user.setPassword(password);
                System.out.println("Attempting signup...");
                boolean b = RegisteredUser.signUp();
                if (b) {
                    System.out.println("signup sucessful");
                    RegisteredUser.logIn();
                    resultLabel.setText("signup sucessful, you are now logged in");
                    
                }else{
                    System.out.println("signup failed");
                    resultLabel.setText("signup failed");
                }
                
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

        

        loginpage.add(emailLabel);
        loginpage.add(emailField);
        loginpage.add(passLabel);
        loginpage.add(passField);
        loginpage.add(logInButton);
        loginpage.add(resultLabel);
        loginpage.add(signupButton);
        loginpage.add(guestButton);

        // Make the frame visible
        loginpage.setVisible(true);
    }
    

    public static void main(String[] args) {
        Startup test = new Startup();
        test.createWindow();
    }
}
