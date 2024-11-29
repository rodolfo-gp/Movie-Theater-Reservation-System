package frontend;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisteredUser {

    private static RegisteredUser currentUser;
    private static boolean loginStatus;
    private static String messege;

    private String email;       // Corresponds to email VARCHAR(255) NOT NULL, Primary Key
    private String password;    // Corresponds to pass_word VARCHAR(255) NOT NULL
    private String lastName;    // Corresponds to last_name VARCHAR(255) NOT NULL
    private String firstName;   // Corresponds to first_name VARCHAR(255) NOT NULL
    private boolean renewed;

    // Default constructor (initializes all fields to null)
    public RegisteredUser() {
        this.email = null;
        this.password = null;
        this.lastName = null;
        this.firstName = null;
        RegisteredUser.loginStatus = false;
    }

    // Parameterized constructor
    public RegisteredUser(String email, String password, String lastName, String firstName) {
        this.email = email != null ? email : null;
        this.password = password != null ? password : null;
        this.lastName = lastName != null ? lastName : null;
        this.firstName = firstName != null ? firstName : null;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        setlogedin(false);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        setlogedin(false);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setlogedin(boolean status){
        RegisteredUser.loginStatus = status;
    }

    public boolean get_is_logedIn() {
        return RegisteredUser.loginStatus;
    }

    public static synchronized RegisteredUser getUser() {
        if (currentUser == null) {
            currentUser = new RegisteredUser(); 
        }
        return currentUser;
    }

    public static String getMessege(){
        if (RegisteredUser.messege == null) {
            return "No message available";  // Default message when null
        }
        return RegisteredUser.messege;
    }
    
    private void setMessege(String m){
        RegisteredUser.messege = m;
    }

    public static boolean login() {
        RegisteredUser user = RegisteredUser.getUser();
        user.setMessege("");
        try {
            // The URL to your login endpoint
            URL url = new URL("http://localhost:8080/users/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");  // PUT method for login
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Manually create JSON string to send with the login request
            String jsonRequest = "{\"email\":\"" + user.getEmail() + "\", \"password\":\"" + user.getPassword() + "\"}";

            // Send the request
            OutputStream os = conn.getOutputStream();
            os.write(jsonRequest.getBytes());
            os.flush();
            os.close();

            // Get the response code
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {  // If the response code is 200 (OK)
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the response string to extract values (firstName, lastName, message)
                String responseString = response.toString();
                if (responseString.contains("\"message\":\"Successful login\"")) {
                    // Extract the firstName, lastName, and message from the response
                    String firstName = extractValue(responseString, "firstName");
                    String lastName = extractValue(responseString, "lastName");
                    String message = extractValue(responseString, "message");

                    // Update the user details
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setMessege(message);  // Set the response message
                    user.setlogedin(true);  // Set login status to true

                    return true;  // Successful login
                }
            }

            // If the login failed (either response code is not 200 or message isn't "Successful login")
            user.setlogedin(false);  // Set login status to false
            user.setMessege("Login failed. Invalid credentials or server error.");  // Default failure message
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            user.setlogedin(false);  // Set login status to false if an exception occurs
            user.setMessege("Error occurred during login: " + e.getMessage());  // Set error message
            return false;
        }
    }

    

    // Helper function to extract values from the JSON response
    private static String extractValue(String json, String key) {
        int startIndex = json.indexOf("\"" + key + "\":\"") + key.length() + 4;
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    public static boolean signUp() {
        RegisteredUser user = RegisteredUser.getUser();
        user.setMessege("");  // Clear the previous message
    
        try {
            // The URL to your signup endpoint
            URL url = new URL("http://localhost:8080/users/signup");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
    
            // Manually create the JSON string to send to the backend
            String jsonRequest = "{\"email\":\"" + user.getEmail() + "\", " +
                                 "\"password\":\"" + user.getPassword() + "\", " +
                                 "\"firstName\":\"" + user.getFirstName() + "\", " +
                                 "\"lastName\":\"" + user.getLastName() + "\"}";
    
            // Send the request
            OutputStream os = conn.getOutputStream();
            os.write(jsonRequest.getBytes());
            os.flush();
            os.close();
    
            // Get the response code
            int responseCode = conn.getResponseCode();
    
            // Read the response message (plain text) based on success or error response
            BufferedReader in;
            if (responseCode == 200) {
                // Successful response
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                // Error response
                in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
    
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
    
            String responseString = response.toString();
    
            if (responseCode == 200) {  // Successful sign-up
                user.setMessege(responseString);  // Set the success message (e.g., "User registered successfully!")
                user.setlogedin(true);  // Set login status to true after successful sign-up
                return true;
            } else {
                user.setMessege(responseString);  // Set the error message (e.g., "Error: Email is already registered.")
                user.setlogedin(false);  // Set login status to false if sign-up failed
                return false;
            }
    
        } catch (Exception e) {
            e.printStackTrace();
            user.setMessege("Error: Unable to sign up. " + e.getMessage());  // Set a meaningful error message
            user.setlogedin(false);  // Set login status to false in case of exception
            return false;
        }
    }
    
    
    
    
}
