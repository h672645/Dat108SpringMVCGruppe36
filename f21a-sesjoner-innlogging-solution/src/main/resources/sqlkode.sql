-- 1. Select the schema: oblig4
SET search_path = oblig4;

-- 2. Drop and create a new table "Deltagere" if it already exists
DROP TABLE IF EXISTS Deltager;
CREATE TABLE Deltager (
    mobil VARCHAR(8) primary key,
    fornavn VARCHAR(24),
    etternavn VARCHAR(24),
    passord VARCHAR(255),
	salt VARCHAR(255),
    kjonn VARCHAR(6)
);

-- 3. The "Deltagere" table is created with the specified columns.

-- 4. Add 5 imaginative "Deltager" examples
--INSERT INTO Deltager (mobil, fornavn, etternavn, passord, kjonn)
--VALUES
--    ('12345678', 'John', 'Doe', 'secret123', 'mann'),
--    ('23456789', 'Jane', 'Smith', 'pass456', 'kvinne'),
--    ('34567890', 'Alice', 'Johnson', 'examplepwd', 'kvinne'),
--    ('45678901', 'Bob', 'Brown', 'secure567', 'mann'),
--    ('56789012', 'Eva', 'Davis', 'mypassword', 'kvinne');
