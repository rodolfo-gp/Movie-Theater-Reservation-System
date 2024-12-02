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


INSERT INTO Seats (id, seat_row, seat_column, booked, showroom_id, theater_id, date_and_time)
VALUES 
    (1011, 2, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1021, 2, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1031, 2, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1041, 2, 4, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1051, 2, 5, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1061, 2, 6, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1071, 2, 7, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1081, 2, 8, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1091, 2, 9, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1101, 2, 10, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1111, 2, 11, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1121, 2, 12, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1131, 2, 13, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1141, 2, 14, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (1151, 2, 15, FALSE, 1, 1, '2024-12-25 18:00:00'),

    (2011, 3, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2021, 3, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2031, 3, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2041, 3, 4, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2051, 3, 5, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2061, 3, 6, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2071, 3, 7, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2081, 3, 8, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2091, 3, 9, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2101, 3, 10, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2111, 3, 11, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2121, 3, 12, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2131, 3, 13, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2141, 3, 14, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (2151, 3, 15, FALSE, 1, 1, '2024-12-25 18:00:00'),

    (3011, 4, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3021, 4, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3031, 4, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3041, 4, 4, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3051, 4, 5, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3061, 4, 6, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3071, 4, 7, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3081, 4, 8, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3091, 4, 9, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3101, 4, 10, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3111, 4, 11, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3121, 4, 12, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3131, 4, 13, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3141, 4, 14, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (3151, 4, 15, FALSE, 1, 1, '2024-12-25 18:00:00'),

    (4011, 5, 1, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4021, 5, 2, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4031, 5, 3, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4041, 5, 4, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4051, 5, 5, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4061, 5, 6, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4071, 5, 7, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4081, 5, 8, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4091, 5, 9, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4101, 5, 10, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4111, 5, 11, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4121, 5, 12, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4131, 5, 13, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4141, 5, 14, FALSE, 1, 1, '2024-12-25 18:00:00'),
    (4151, 5, 15, FALSE, 1, 1, '2024-12-25 18:00:00');
