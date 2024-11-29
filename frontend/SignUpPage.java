package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage {
    
    public static void showSignUp(JFrame parentFrame) {
        // Close the current frame
        parentFrame.dispose();
        RegisteredUser user = RegisteredUser.getUser();

        // Create a new frame for the Sign-Up page
        JFrame signUpFrame = new JFrame("Sign-Up Page");
        
        // Set the size of the new frame
        signUpFrame.setSize(1080, 720);  // Set the size to a fixed value like 1080x720
        
        // Position the frame at the center of the screen
        signUpFrame.setLocationRelativeTo(null);  // Center the window
        
        // Set default close operation
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel for the Sign-Up page
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        // Labels for user input fields
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        
        // Text fields for user input
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        
        // Text area to display result
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false); // Make result area non-editable
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        
        // Buttons
        JButton signUpButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Login/Home");
        
        // Add components to the panel
        signUpPanel.add(firstNameLabel);
        signUpPanel.add(firstNameField);
        signUpPanel.add(lastNameLabel);
        signUpPanel.add(lastNameField);
        signUpPanel.add(emailLabel);
        signUpPanel.add(emailField);
        signUpPanel.add(passwordLabel);
        signUpPanel.add(passwordField);
        signUpPanel.add(signUpButton);
        signUpPanel.add(loginButton);
        
        // Add result area
        signUpPanel.add(resultArea);

        // Add the panel to the new frame
        signUpFrame.getContentPane().add(signUpPanel);

        // Set the new frame visible
        signUpFrame.setVisible(true);

        // Button action listener for the Sign-Up button
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String email = emailField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                
                // Basic validation
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    resultArea.setText("Please fill in all the fields.");
                } else {
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setPassword(password);
                    RegisteredUser.signUp();
                    resultArea.setText(RegisteredUser.getMessege());
                    
                }
            }
        });

        // Button action listener for the Login/Home button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current SignUp window
                signUpFrame.dispose();
                
                // Launch the Login/Home screen
                Startup s = new Startup();
                s.createWindow();  // Assuming this method will create the login or home window
            }
        });
    }
}
