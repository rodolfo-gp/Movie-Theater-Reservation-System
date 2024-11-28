package frontend;

public class RegisteredUser {

    private static RegisteredUser currentUser;
    
    private boolean LogedIn;
    private String email;       // Corresponds to email VARCHAR(255) NOT NULL, Primary Key
    private String username;    // Corresponds to username VARCHAR(255) NOT NULL UNIQUE
    private String password;    // Corresponds to pass_word VARCHAR(255) NOT NULL
    private String lastName;    // Corresponds to last_name VARCHAR(255) NOT NULL
    private String firstName;   // Corresponds to first_name VARCHAR(255) NOT NULL

    // Default constructor (initializes all fields to null)
    public RegisteredUser() {
        this.email = null;
        this.username = null;
        this.password = null;
        this.lastName = null;
        this.firstName = null;
        this.LogedIn = false;
    }

    // Parameterized constructor
    public RegisteredUser(String email, String username, String password, String lastName, String firstName) {
        this.email = email != null ? email : null;
        this.username = username != null ? username : null;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    private void setlogedin(boolean status){
        currentUser.LogedIn = status;
    }
    public boolean get_is_logedIn() {
        return currentUser.LogedIn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static synchronized RegisteredUser getUser() {
        if (currentUser == null) {
            currentUser = new RegisteredUser(); 
        }
        return currentUser;
    }
    public static boolean logIn(){
        currentUser.setlogedin(true);
        
        return currentUser.get_is_logedIn();
    }
    public static boolean signUp(){
        currentUser.setlogedin(true);
        
        return currentUser.get_is_logedIn();
    }
}
