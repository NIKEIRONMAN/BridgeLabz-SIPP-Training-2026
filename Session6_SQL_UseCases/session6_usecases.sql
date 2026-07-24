-- Session 6 : Indexing & ACID Properties

-- Use Case 26
CREATE INDEX idx_country_date
ON covid_cases(country, report_date);

CREATE INDEX idx_report_date
ON covid_cases(report_date);

-- Use Case 27
CREATE INDEX idx_infection_rate
ON covid_cases(infection_rate, country, report_date);

-- Example Query
SELECT country, infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;

-- Use Case 28
EXPLAIN
SELECT c.country,
       c.confirmed,
       v.vaccinated
FROM covid_cases c
JOIN vaccine_data v
ON c.country=v.country
AND c.report_date=v.report_date
WHERE c.country='India';

-- Use Case 29
START TRANSACTION;

INSERT INTO vaccine_data(country,report_date,vaccine_name,doses)
VALUES('India','2024-01-01','Covaxin',10000);

INSERT INTO vaccine_data(country,report_date,vaccine_name,doses)
VALUES('India','2024-01-01','Covishield',15000);

COMMIT;

-- If any statement fails
-- ROLLBACK;

-- Use Case 30

-- Dirty Read
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;
SELECT * FROM covid_cases WHERE country='India';
COMMIT;

-- Non-Repeatable Read Prevention
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;
START TRANSACTION;
SELECT confirmed FROM covid_cases WHERE country='India';
SELECT confirmed FROM covid_cases WHERE country='India';
COMMIT;

-- Phantom Read Prevention
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;
START TRANSACTION;
SELECT * FROM covid_cases
WHERE confirmed > 100000;
COMMIT;
