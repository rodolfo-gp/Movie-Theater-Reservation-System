USE ensf480_term_project_movies_db;

-- Insert data into Provinces
INSERT INTO Provinces (province_name, sale_tax_percent, country, currency)
VALUES 
    ('Alberta', 5.00, 'Canada', 'CAD'),
    ('British Columbia', 8.00, 'Canada','CAD'),
    ('Ontario', 13.00, 'Canada','CAD'),
    ('Gronk', 99.99, 'North korea','KRW');

-- Insert data into Theaters
INSERT INTO Theaters (theater_name, theater_address, theater_city, province_name)
VALUES 
    ('Cineplex Calgary', '123 Main St', 'Calgary', 'Alberta'),
    ('Landmark Vancouver', '456 Granville St', 'Vancouver', 'British Columbia'),
    ('Cineplex Toronto', '789 Yonge St', 'Toronto', 'Ontario'),
    ('Grug Theater', '420 Skibbidi St', 'Pyongyang', 'Gronk');

-- Insert data into Movies
INSERT INTO Movies (movie_name, director, release_date)
VALUES 
    ('Inception', 'Christopher Nolan', '2010-07-16'),
    ('The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31'),
    ('Avengers: Endgame', 'Anthony Russo, Joe Russo', '2019-04-26'),
    ('Boss Baby', 'Kim jong Un', '2017-03-25');

-- Insert data into Showrooms
INSERT INTO Showrooms (showroom_id, theater_id, num_rows, num_columns)
VALUES 
    (1, 1, 10, 15),
    (2, 1, 8, 12),
    (1, 2, 12, 20),
    (1, 3, 15, 25),
    (1, 4, 30, 25);

-- Insert data into Shows
INSERT INTO Shows (theater_id, ticket_price ,showroom_id, movie_name, date_and_time, seat_map)
VALUES 
    (1, 15.80, 1, 'Inception',  '2024-12-25 18:00:00', JSON_ARRAY()),
    (1, 17.80, 2, 'The Matrix', '2024-12-26 20:00:00', JSON_ARRAY()),
    (2, 22.80, 1, 'Avengers: Endgame', '2024-12-27 15:30:00', JSON_ARRAY()),
    (4, 6.80, 1, 'Boss Baby', '2024-12-24 15:30:00', JSON_ARRAY()),
    (4, 6.80, 1, 'Boss Baby', '2024-12-25 15:30:00', JSON_ARRAY()),
    (4, 6.80, 1, 'Boss Baby', '2024-12-26 15:30:00', JSON_ARRAY()),
    (4, 6.80, 1, 'Boss Baby', '2024-12-27 15:30:00', JSON_ARRAY());

-- Insert data into Registered_Users
INSERT INTO Registered_Users (email, username, pass_word, last_name, first_name)
VALUES 
    ('jdoe@example.com', 'jdoe', 'password123', 'Doe', 'John'),
    ('asmith@example.com', 'asmith', 'mypassword', 'Smith', 'Alice'),
    ('bwhite@example.com', 'bwhite', 'securepass', 'White', 'Brian'),
    ('obamna@gov.ca','obamna','iloveisis','Barrack','Obama');

-- Insert data into CreditCards
INSERT INTO CreditCards (CardNumber, ExpirationDate, CVV, email)
VALUES 
    ('1234567890123456', '2026-12-31', 123, 'jdoe@example.com'),
    ('9876543210987654', '2025-08-15', 456, 'asmith@example.com'),
    ('1111222233334444', '2027-05-20', 789, 'jdoe@example.com'),
    ('1321654986516549', '2027-06-20', 420, 'obamna@gov.ca');

-- Insert data into Tickets
INSERT INTO Tickets (seat_row, seat_column, show_id, Customer_email)
VALUES 
    (5, 6, 1, 'jdoe@example.com'),
    (7, 8, 2, 'asmith@example.com'),
    (10, 15, 3, NULL),
    (5, 5, 4, 'obamna@gov.ca'),
    (5, 5, 5, 'obamna@gov.ca'),
    (5, 5, 6, 'obamna@gov.ca'),
    (5, 5, 7, 'obamna@gov.ca');
