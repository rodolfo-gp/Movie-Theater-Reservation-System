-- Insert data into Provinces
INSERT INTO Provinces (province_name, sale_tax_percent, country, currency)
VALUES 
    ('Alberta', 5.00, 'Canada', 'CAD'),
    ('British Columbia', 8.00, 'Canada', 'CAD'),
    ('Ontario', 13.00, 'Canada', 'CAD'),
    ('Gronk', 99.99, 'North Korea', 'KRW');

-- Insert data into Theaters
INSERT INTO Theaters (theater_name, theater_address, theater_city, province_name)
VALUES 
    ('Cineplex Calgary', '123 Main St', 'Calgary', 'Alberta');

-- Insert data into Movies
INSERT INTO Movies (movie_name, director, release_date)
VALUES 
    ('Inception', 'Christopher Nolan', '2010-07-16'),
    ('The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31'),
    ('Avengers: Endgame', 'Anthony Russo, Joe Russo', '2019-04-26'),
    ('Boss Baby', 'Tom McGrath', '2017-03-25');

-- Insert data into Showrooms
INSERT INTO Showrooms (showroom_id, theater_id, num_rows, num_columns)
VALUES 
    (1, 1, 5, 15),
    (2, 1, 5, 15),
    (3, 1, 5, 15);

-- Insert data into Shows and retrieve auto-incremented show_id
INSERT INTO Shows (theater_id, ticket_price, showroom_id, movie_name, date_and_time)
VALUES 
    (1, 15.80, 1, 'Inception', '2024-12-25 18:00:00'),
    (1, 17.80, 1, 'The Matrix', '2024-12-26 20:00:00'),
    (1, 22.80, 2, 'Avengers: Endgame', '2024-12-27 15:30:00'),
    (1, 6.80, 3, 'Boss Baby', '2024-12-24 15:30:00');

-- Get `show_id` dynamically for Tickets
SET @show_id_inception = (SELECT show_id FROM Shows WHERE movie_name = 'Inception');
SET @show_id_matrix = (SELECT show_id FROM Shows WHERE movie_name = 'The Matrix');
SET @show_id_avengers = (SELECT show_id FROM Shows WHERE movie_name = 'Avengers: Endgame');
SET @show_id_bossbaby = (SELECT show_id FROM Shows WHERE movie_name = 'Boss Baby');

-- Insert data into Registered_Users
INSERT INTO Registered_Users (email, pass_word, last_name, first_name)
VALUES 
    ('jdoe@example.com', 'password123', 'Doe', 'John'),
    ('asmith@example.com', 'mypassword', 'Smith', 'Alice'),
    ('bwhite@example.com', 'securepass', 'White', 'Brian'),
    ('obamna@gov.ca', 'iloveisis', 'Obama', 'Barrack');

-- Insert data into CreditCards
INSERT INTO CreditCards (CardNumber, ExpirationDate, CVV, email)
VALUES 
    ('1234567890123456', '2026-12-31', 123, 'jdoe@example.com'),
    ('9876543210987654', '2025-08-15', 456, 'asmith@example.com'),
    ('1111222233334444', '2027-05-20', 789, 'jdoe@example.com'),
    ('1321654986516549', '2027-06-20', 420, 'obamna@gov.ca');

-- Insert data into Tickets using dynamic show_ids
INSERT INTO Tickets (seat_row, seat_column, show_id, ticket_price, Customer_email)
VALUES 
    (5, 6, @show_id_inception, 15.80, 'jdoe@example.com'), -- John Doe booking for Inception
    (4, 8, @show_id_matrix, 17.80, 'asmith@example.com'),  -- Alice booking for The Matrix
    (4, 15, @show_id_avengers, 22.80, NULL),               -- Reserved seat, no customer
    (4, 5, @show_id_bossbaby, 6.80, 'obamna@gov.ca');      -- Barrack booking for Boss Baby


INSERT INTO Seats (id, seat_row, seat_column, booked, showroom_id, theater_id, dateAndTime)
VALUES 
    (11, 1, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (12, 1, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (13, 1, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (14, 2, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (15, 2, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (16, 2, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    
    (21, 1, 1, FALSE, 2, 1, '2024-12-25 18:00:00'),
    (22, 1, 2, FALSE, 2, 1, '2024-12-25 18:00:00'),
    (23, 1, 3, FALSE, 2, 1, '2024-12-25 18:00:00'),
    (24, 2, 1, FALSE, 2, 1, '2024-12-25 18:00:00'),
    (25, 2, 2, FALSE, 2, 1, '2024-12-25 18:00:00'),
    (26, 2, 3, FALSE, 2, 1, '2024-12-25 18:00:00');
