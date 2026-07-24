-- Assumed table:
-- covid_cases(country VARCHAR(100), report_date DATE,
-- confirmed INT, deaths INT, recovered INT)

-- Use Case 21: View
CREATE OR REPLACE VIEW LatestCovidData AS
SELECT c.country,c.report_date,c.confirmed,c.deaths,c.recovered
FROM covid_cases c
JOIN (
SELECT country,MAX(report_date) md
FROM covid_cases
GROUP BY country
)x
ON c.country=x.country AND c.report_date=x.md;

DELIMITER $$

-- Use Case 22: Mortality Rate Function
CREATE FUNCTION CalculateMortalityRate(
p_country VARCHAR(100),
p_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
DECLARE r DECIMAL(10,2);
SELECT IFNULL((deaths/NULLIF(confirmed,0))*100,0)
INTO r
FROM covid_cases
WHERE country=p_country AND report_date=p_date;
RETURN r;
END$$

-- Use Case 23: Stored Procedure
CREATE PROCEDURE UpdateCovidStats(
IN p_country VARCHAR(100),
IN p_date DATE,
IN p_confirmed INT,
IN p_deaths INT,
IN p_recovered INT
)
BEGIN
UPDATE covid_cases
SET confirmed=p_confirmed,
deaths=p_deaths,
recovered=p_recovered
WHERE country=p_country
AND report_date=p_date;
END$$

-- Use Case 24: Recovery Rate Function
CREATE FUNCTION CalculateRecoveryRate(
p_country VARCHAR(100)
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
DECLARE r DECIMAL(10,2);
SELECT IFNULL((recovered/NULLIF(confirmed,0))*100,0)
INTO r
FROM covid_cases
WHERE country=p_country
ORDER BY report_date DESC
LIMIT 1;
RETURN r;
END$$

-- Use Case 25: Audit Table + Trigger
CREATE TABLE covid_audit(
audit_id INT AUTO_INCREMENT PRIMARY KEY,
country VARCHAR(100),
report_date DATE,
old_confirmed INT,
new_confirmed INT,
old_deaths INT,
new_deaths INT,
old_recovered INT,
new_recovered INT,
changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER CovidAuditTrigger
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
INSERT INTO covid_audit(
country,report_date,
old_confirmed,new_confirmed,
old_deaths,new_deaths,
old_recovered,new_recovered
)
VALUES(
OLD.country,OLD.report_date,
OLD.confirmed,NEW.confirmed,
OLD.deaths,NEW.deaths,
OLD.recovered,NEW.recovered
);
END$$

DELIMITER ;
