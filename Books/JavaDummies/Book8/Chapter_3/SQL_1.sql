USE movies;

SELECT * FROM movie ORDER BY year;

SELECT * FROM movie WHERE year <= 1980 ORDER BY year DESC;

SELECT * FROM movie WHERE year < 1970 OR year > 1970 ORDER BY year DESC;

SELECT * FROM movie WHERE id = 7;

SELECT * FROM movie WHERE title LIKE "%princess%";

SELECT COUNT(*), MIN(year), MAX(year) FROM movie;

SELECT COUNT(*) AS Num_Movies_Before_1970 FROM movie WHERE year < 1970;






