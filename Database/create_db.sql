DROP DATABASE IF EXISTS ensf480_term_project_movies_db;
CREATE DATABASE IF NOT EXISTS ensf480_term_project_movies_db;

USE ensf480_term_project_movies_db;


DROP TABLE IF EXISTS Theaters;
CREATE TABLE Theaters (
    theater_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    release_date DATE NOT NULL,
    PRIMARY KEY (movie_name),
);

DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies (
    movie_name VARCHAR(255) NOT NULL, -- Primary key
    director VARCHAR(255) , -- Unique value
    release_date DATE NOT NULL,
    PRIMARY KEY (movie_name),
);

DROP TABLE IF EXISTS Registered_Users;
CREATE TABLE Registered_Users (
    Email VARCHAR(255) NOT NULL, -- Primary key
    Username VARCHAR(255) NOT NULL, -- Unique value
    Pass_word VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    PRIMARY KEY (Email),
    CONSTRAINT uc_Username UNIQUE (Username) -- Ensure unique usernames
);

DROP TABLE IF EXISTS CreditCards;
CREATE TABLE CreditCards (
    CardId INT NOT NULL AUTO_INCREMENT, -- Primary key
    CardNumber VARCHAR(16) NOT NULL,   -- Partial key
    ExpirationDate DATE NOT NULL,
    CVV INT NOT NULL,
    Email VARCHAR(255) NOT NULL, -- Foreign key referencing Registered_Users
    PRIMARY KEY (CardId),
    CONSTRAINT fk_Email FOREIGN KEY (Email) REFERENCES Registered_Users(Email)
);


INSERT INTO Registered_Users (Email, Username, Pass_word, LastName, FirstName)
VALUES
    ('jdoe@example.com', 'jdoe', 'password123', 'Doe', 'John'),
    ('asmith@example.com', 'asmith', 'mypassword', 'Smith', 'Alice');

-- Insert data into CreditCards
INSERT INTO CreditCards (CardNumber, ExpirationDate, CVV, Email)
VALUES 
    ('1234567890123456', '2026-12-31', 123, 'jdoe@example.com'),
    ('9876543210987654', '2025-08-15', 456, 'asmith@example.com'),
    ('1111222233334444', '2027-05-20', 789, 'jdoe@example.com'); -- Multiple cards for one user
