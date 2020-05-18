DROP TABLE user;
DROP TABLE recipe;
DROP TABLE regimen;
DROP TABLE main;

CREATE TABLE user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
firstname VARCHAR(50) NOT NULL,
lastname VARCHAR(50) NOT NULL,
password VARCHAR(250) NOT NULL,
role VARCHAR(10) NOT NULL)
ENGINE=InnoDB;

INSERT INTO user (username, firstname, lastname, password, role) 
VALUES ('user', 'User', 'Resu', '$2a$10$zVAZ.qr1dVHN9PxuK/2NRuQuT.d5saHD7MACHFkLlr9ahO7tEcUoS', 'USER'),
('admin', 'Admin', 'Nimda', '$2a$10$vxOPLon4Coz0Hh9udbzVH.NE/dVCUw4mUKOnlf0/7kX2yMg8uzY9S', 'ADMIN');

CREATE TABLE recipe (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
preparation INT NOT NULL,
rid BIGINT,
mid BIGINT,
ingredient01 TEXT(4200000000) NOT NULL,
ingredient02 TEXT(4200000000),
ingredient03 TEXT(4200000000),
ingredient04 TEXT(4200000000),
ingredient05 TEXT(4200000000),
ingredient06 TEXT(4200000000),
ingredient07 TEXT(4200000000),
ingredient08 TEXT(4200000000),
ingredient09 TEXT(4200000000),
ingredient10 TEXT(4200000000),
ingredient11 TEXT(4200000000),
ingredient12 TEXT(4200000000),
ingredient13 TEXT(4200000000),
ingredient14 TEXT(4200000000),
ingredient15 TEXT(4200000000),
instruction TEXT(4200000000) NOT NULL,
createdby VARCHAR(250) NOT NULL)
ENGINE=InnoDB;

INSERT INTO recipe (name, preparation, rid, mid, ingredient01, ingredient02, ingredient03, instruction, createdby) VALUES 
('Koesoppa', 120, 1, 1, 'Lihaa', 'vettä', 'kasviksia', 'Sekoita keskenään ja lämmitä', 'user001');

CREATE TABLE regimen (
rid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL)
ENGINE=InnoDB;

INSERT INTO regimen (name) VALUES 
('Gluteeniton'),
('Kananmunaton'),
('Kasvis'),
('Laktoositon'),
('Lakto-ovo'),
('Maidoton'),
('Vegaani'),
('Viljaton');

CREATE TABLE main (
mid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL)
ENGINE=InnoDB;

INSERT INTO main (name) VALUES 
('Hedelmät ja marjat'),
('Kala'),
('Kana'),
('Kasvikset'),
('Liha'),
('Maitotuotteet'),
('Riista'),
('Siipikarja'),
('Tofu');