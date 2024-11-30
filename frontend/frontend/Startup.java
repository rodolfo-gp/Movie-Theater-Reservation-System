package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Startup implements BaseWindow {
    public static String baseURL = "localhost:8080";
    private JFrame loginPage;

    @Override
    public void createWindow() {
        RegisteredUser user = RegisteredUser.getUser();
        loginPage = new JFrame("Login");
        loginPage.setSize(1080, 720);
        loginPage.setLocationRelativeTo(null); //centers window
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setLayout(new GridLayout(4, 2));

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
                if (email.isEmpty() || password.isEmpty()) {
                    resultLabel.setText("Please fill in all the fields.");
                } else {
                    user.setEmail(email);
                    user.setPassword(password);
                    System.out.println("Attempting Login...");
                    boolean isLoggedIn = RegisteredUser.login();  // Ensure login status
                    String message = RegisteredUser.getMessege();
                    resultLabel.setText(message != null ? message : "Login failed. Try again.");
                }
            }    
        });
        

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpPage.showSignUp(loginPage);  // Show sign-up in the same window
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPage.setVisible(false);
                MoviePage m = new MoviePage();
                m.createWindow(null);
            }
        });

        loginPage.add(emailLabel);
        loginPage.add(emailField);
        loginPage.add(passLabel);
        loginPage.add(passField);
        loginPage.add(logInButton);
        loginPage.add(resultLabel);
        loginPage.add(signupButton);
        loginPage.add(guestButton);

        loginPage.setVisible(true);
    }

    public static void main(String[] args) {
        Startup test = new Startup();
        test.createWindow();
    }
}
