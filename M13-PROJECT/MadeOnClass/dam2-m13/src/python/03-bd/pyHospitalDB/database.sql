DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS hospital;
CREATE TABLE hospital (hospital_id serial NOT NULL PRIMARY KEY, nom VARCHAR (100) NOT NULL);
INSERT INTO hospital (hospital_id, nom) VALUES (1, 'Hospital de l''Alt Penedès');
INSERT INTO hospital (hospital_id, nom) VALUES (2, 'Hospital de Terrassa');
INSERT INTO hospital (hospital_id, nom) VALUES (3, 'Hospital d''Amposta');
INSERT INTO hospital (hospital_id, nom) VALUES (4, 'Hospital San Joan de Dèu');
CREATE TABLE doctor (doctor_id serial NOT NULL PRIMARY KEY,	hospital_id integer NOT NULL, nom VARCHAR (100) NOT NULL, cognoms varchar(200) NOT NULL, data_alta DATE NOT NULL, salari INTEGER NOT NULL, FOREIGN KEY (hospital_id) REFERENCES hospital(hospital_id));
INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari ) VALUES (1, 'David', 'Galiana', '2005-2-10', '40000');
INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari ) VALUES (1, 'Enrique', 'Penadès', '2001-4-11', '47000');
INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari ) VALUES (2, 'Raül', 'Mollà', '2000-1-3', '45000');
INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari ) VALUES (3, 'Pere', 'Grau', '1979-2-7', '30000');
INSERT INTO doctor (hospital_id, nom, cognoms, data_alta, salari ) VALUES (4, 'Arnau', 'Vimbodí', '1978-2-28', '80000');