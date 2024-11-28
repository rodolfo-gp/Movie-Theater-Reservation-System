package com.example.spring_boot_ensf480_api_server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Registered_Users")
public class User {

    @Id
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "pass_word", nullable = false, length = 255)
    private String password;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    // Default constructor
    public User() {
    }

    // Constructor with fields
    public User(String email, String password, String lastName, String firstName) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // Getters and Setters
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

    // toString() method
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
