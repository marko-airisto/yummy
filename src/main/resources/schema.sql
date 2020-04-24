DROP TABLE recipe;
DROP TABLE regimen;
DROP TABLE main;

CREATE TABLE recipe (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
rid BIGINT,
mid BIGINT,
ingredient TEXT(4200000000) NOT NULL,
instruction TEXT(4200000000) NOT NULL,
createdby VARCHAR(250) NOT NULL)
ENGINE=InnoDB;

INSERT INTO recipe (name, rid, mid, ingredient, instruction, createdby) VALUES 
('Koesoppa', 1, 1, 'Lihaa, vettä, kasviksia', 'Sekoita keskenään ja lämmitä', 'user001');

CREATE TABLE regimen (
rid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL)
ENGINE=InnoDB;

INSERT INTO regimen (name) VALUES 
('Laktoositon'), ('Kasvis'), ('Gluteeniton');

CREATE TABLE main (
mid BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL)
ENGINE=InnoDB;

INSERT INTO main (name) VALUES 
('Sika'), ('Nauta'), ('Tofu');