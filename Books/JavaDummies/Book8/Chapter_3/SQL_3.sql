-- No 'USE' command in PostgreSQL. Switch databases with \c in psql

-- Drop the table if it already exists
DROP TABLE IF EXISTS friend;

-- Create table friend
CREATE TABLE friend (
                        lastname VARCHAR(50),
                        firstname VARCHAR(50),
                        movieid INT
);

-- Insert values using single quotes for strings
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 3);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 5);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 9);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Mondello', 'Lumpy', 2);
INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 3);

-- Use JOIN for better clarity
SELECT firstname, lastname, title
FROM movie
         JOIN friend ON movie.id = friend.movieid;

-- Use single quotes for string values
SELECT title
FROM movie
         JOIN friend ON movie.id = friend.movieid
WHERE lastname = 'Haskell';

-- Select distinct rows
SELECT DISTINCT lastname, firstname
FROM friend;

-- Delete records from the movie table
DELETE FROM movie WHERE id = 10;
SELECT * FROM movie;

-- Delete records from the friend table
DELETE FROM friend WHERE lastname = 'Haskell';
SELECT * FROM friend;

-- Update price for a specific movie
UPDATE movie
SET price = 180.95
WHERE id = 8;

-- Update friend table data
UPDATE friend
SET lastname = 'Bully', firstname = 'Big'
WHERE firstname = 'Wally';

-- Update all movie prices by increasing by 10%
UPDATE movie
SET price = price * 1.1;
SELECT * FROM movie;
