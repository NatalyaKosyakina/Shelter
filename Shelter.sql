DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE HumanFriends;
USE HumanFriends;

DROP TABLE IF EXISTS HumanFriends;
CREATE TABLE HumanFriends (
Specie VARCHAR(45) NOT NULL PRIMARY KEY,
 AnimalType VARCHAR(45) NOT NULL
 );
 
 INSERT INTO HumanFriends (Specie, AnimalType) VALUES
('Dog', 'Pet'), 
('Cat', 'Pet'), 
('Hamster', 'Pet'), 
('Horse', 'Pack Animal'), 
('Camel', 'Pack Animal'), 
('Donkey', 'Pack Animal');


DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
Specie VARCHAR(45) NOT NULL, 
AnimalName VARCHAR(45) NOT NULL, 
birthdate DATE, 
comands TEXT, 
FOREIGN KEY (Specie) REFERENCES HumanFriends(Specie) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Pets (Specie, name, birthdate, comands) VALUES
('Dog', 'Rex', '2022-10-26', 'Sit, Aport, Voice, Fass'),
('Dog', 'Bond', '2019-03-08', 'Sit, Lay down, Fass'), 
('Cat', 'Murka', '2018-07-15', 'Voice, Lay down, Jump'),
('Cat', 'Tom', '2021-09-19', 'Run, Jump'), 
('Hamster', 'Pinky', '2023-02-01', 'Run, Lay down, Jump');

DROP TABLE IF EXISTS PackAnimals;
CREATE TABLE PackAnimals (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
Specie VARCHAR(45) NOT NULL, 
AnimalName VARCHAR(45) NOT NULL, 
birthdate DATE, 
comands TEXT, 
FOREIGN KEY (Specie) REFERENCES HumanFriends(Specie) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO PackAnimals (Specie, name, birthdate, comands) VALUES
('Horse', 'Tornado', '2022-05-04', 'Walk, Gallop, Trot'),
('Horse', 'Anilin', '2021-08-02', 'Walk, Gallop, Canter'),
('Camel', 'Sandy', '2016-11-03', 'Walk, Carry Load'),
('Horse', 'Bemby', '2023-01-04', 'Walk'), 
('Donkey', 'Isaak', '2021-03-21', 'Walk, Bray, Kick'),
('Camel', 'Dune', '2016-11-06', 'Walk, Sit'),
('Donkey', 'Hodja', '2019-04-17', 'Walk, Bray, Carry Load');

CREATE OR REPLACE VIEW YoungAnimals AS
(SELECT specie, Animalname, birthdate,
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))) AS age 
FROM Pets 
WHERE 
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2)))>=12 AND 
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2)))<36
UNION ALL SELECT specie, Animalname, birthdate,
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))) AS age
FROM PackAnimals
WHERE 
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2)))>=12 AND 
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2)))<36
ORDER BY specie);


CREATE OR REPLACE VIEW Spreadsheet AS
(SELECT AnimalType, HumanFriends.Specie AS Specie, Animalname, birthdate,
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))) AS age_in_month, comands
FROM Pets 
JOIN HumanFriends ON Pets.Specie=HumanFriends.Specie
UNION ALL 
SELECT AnimalType, HumanFriends.Specie AS Specie, Animalname, birthdate,
((YEAR(CURRENT_DATE)-YEAR(birthdate))*12-(RIGHT(CURRENT_DATE,5)<RIGHT(birthdate,5))+(MONTH(CURRENT_DATE)-MONTH(birthdate))-(RIGHT(CURRENT_DATE,2)<RIGHT(birthdate,2))) AS age_in_month, comands
FROM PackAnimals 
JOIN HumanFriends ON PackAnimals.Specie=HumanFriends.Specie
ORDER BY Type);