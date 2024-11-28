package frontend;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisteredUser {

    private static RegisteredUser currentUser;
    private static boolean loginStatus;

    private String email;       // Corresponds to email VARCHAR(255) NOT NULL, Primary Key
    private String password;    // Corresponds to pass_word VARCHAR(255) NOT NULL
    private String lastName;    // Corresponds to last_name VARCHAR(255) NOT NULL
    private String firstName;   // Corresponds to first_name VARCHAR(255) NOT NULL

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
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public static boolean login() {
        RegisteredUser user = RegisteredUser.getUser();
        try {
            URL url = new URL("http://localhost:8080/users/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Manually create JSON string
            String jsonRequest = "{\"email\":\"" + user.getEmail() + "\", \"password\":\"" + user.getPassword() + "\"}";

            OutputStream os = conn.getOutputStream();
            os.write(jsonRequest.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Manually parse the JSON response
                String responseString = response.toString();
                if (responseString.contains("\"message\":\"Successful login\"")) {
                    String firstName = extractValue(responseString, "firstName");
                    String lastName = extractValue(responseString, "lastName");

                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setlogedin(true);
                    return true;
                }
            }

            user.setlogedin(false);
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            user.setlogedin(false);
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
        currentUser.setlogedin(true);
        return currentUser.get_is_logedIn();
    }
}
