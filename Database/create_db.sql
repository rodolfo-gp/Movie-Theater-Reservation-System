DROP DATABASE IF EXISTS ensf480_term_project_movies_db;
CREATE DATABASE ensf480_term_project_movies_db;

USE ensf480_term_project_movies_db;

-- Create Provinces table
DROP TABLE IF EXISTS Provinces;
CREATE TABLE Provinces (
    province_name VARCHAR(255) NOT NULL, -- PK
    sale_tax_percent DECIMAL(5, 2),
    country VARCHAR(255),
    currency VARCHAR(10),
    PRIMARY KEY (province_name)
);

-- Create Theaters table
DROP TABLE IF EXISTS Theaters;
CREATE TABLE Theaters (
    theater_id INT NOT NULL AUTO_INCREMENT, -- PK
    theater_name VARCHAR(255) NOT NULL,
    theater_address VARCHAR(255) NOT NULL,
    theater_city VARCHAR(255),
    province_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (theater_id),
    CONSTRAINT fk_province_name FOREIGN KEY (province_name) REFERENCES Provinces(province_name)
);

-- Create Movies table
DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies (
    movie_name VARCHAR(255) NOT NULL, -- PK
    director VARCHAR(255),
    release_date DATE,
    PRIMARY KEY (movie_name)
);

-- Create Showrooms table
DROP TABLE IF EXISTS Showrooms;
CREATE TABLE Showrooms (
    showroom_id SMALLINT NOT NULL, -- Part of composite primary key
    theater_id INT NOT NULL,       -- Part of composite primary key
    num_rows SMALLINT NOT NULL,
    num_columns SMALLINT NOT NULL,
    PRIMARY KEY (showroom_id, theater_id), -- Composite primary key
    CONSTRAINT fk_theater FOREIGN KEY (theater_id) REFERENCES Theaters(theater_id)
);

-- Create Shows table
DROP TABLE IF EXISTS Shows;
CREATE TABLE Shows (
    show_id INT AUTO_INCREMENT PRIMARY KEY,
    ticket_price DECIMAL(10, 2),
    theater_id INT NOT NULL,
    showroom_id SMALLINT NOT NULL,
    movie_name VARCHAR(255) NOT NULL,
    date_and_time TIMESTAMP, 
    CONSTRAINT fk_theater_id FOREIGN KEY (theater_id) REFERENCES Theaters(theater_id),
    CONSTRAINT fk_showroom_id FOREIGN KEY (showroom_id, theater_id) REFERENCES Showrooms(showroom_id, theater_id),
    CONSTRAINT fk_movie_name FOREIGN KEY (movie_name) REFERENCES Movies(movie_name),
    -- Create unique index for ticket_price and show_id to support the foreign key in Tickets
    UNIQUE (show_id, ticket_price)
);

-- Create Registered_Users table
DROP TABLE IF EXISTS Registered_Users;
CREATE TABLE Registered_Users (
    email VARCHAR(255) NOT NULL, -- PK
    pass_word VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (email)
);

-- Create Tickets table
DROP TABLE IF EXISTS Tickets;
CREATE TABLE Tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    seat_row SMALLINT,
    seat_column SMALLINT,
    show_id INT NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL,
    Customer_email VARCHAR(255), -- Can be NULL
    FOREIGN KEY (Customer_email) REFERENCES Registered_Users(email),
    -- Foreign key now works because of the unique index in Shows table
    FOREIGN KEY (show_id, ticket_price) REFERENCES Shows(show_id, ticket_price)
);

-- Create CreditCards table
DROP TABLE IF EXISTS CreditCards;
CREATE TABLE CreditCards (
    CardId INT AUTO_INCREMENT PRIMARY KEY,
    CardNumber VARCHAR(16) NOT NULL,
    ExpirationDate DATE NOT NULL,
    CVV INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT fk_Email FOREIGN KEY (email) REFERENCES Registered_Users(email) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Seats;
CREATE TABLE Seats (
    id INT NOT NULL,                        
    seat_row INT NOT NULL,                  
    seat_column INT NOT NULL,               
    booked BOOLEAN DEFAULT FALSE,           
    showroom_id SMALLINT NOT NULL,          
    theater_id INT NOT NULL,                
    date_and_time DATETIME NOT NULL,          
    PRIMARY KEY (id),                       
    CONSTRAINT fk_showroom FOREIGN KEY (showroom_id, theater_id) 
        REFERENCES Showrooms(showroom_id, theater_id) 
);
