CREATE DATABASE IF NOT EXISTS proyectoBDAlvaro;
USE proyectoBDAlvaro;

																			-- CREACION DE LAS TABLAS
-- BORRAR TODOS LOS DATOS DE LA TABLA PARA CREARLAS OTRA VEZ
CREATE TABLE IF NOT EXISTS Encargado(

	id INT NOT NULL AUTO_INCREMENT,
	nombre varchar(30),
    apellidos varchar(40),
    edad INT,
	
    CONSTRAINT pk_Encargado PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Cafeteria(

	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30),
	fecApert DATE,
    costePedidoMensu DECIMAL (5,2),
    idEncargado INT,
	
    CONSTRAINT pk_Cafeteria PRIMARY KEY (id),
    
	CONSTRAINT fk_Cafeteria_Encargado FOREIGN KEY (idEncargado) REFERENCES Encargado(id) 
);

CREATE TABLE IF NOT EXISTS Gato(

	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30),
	raza VARCHAR(30),
    edad INT,
    idCafeteria INT,
	
    CONSTRAINT pk_Gato PRIMARY KEY (id),
    
	CONSTRAINT fk_Gato_Cafeteria FOREIGN KEY (idCafeteria) REFERENCES Cafeteria(id) 
);
																			-- INSERCION DE LAS TABLAS

INSERT INTO Encargado
			(id, nombre, apellidos, edad)
		VALUES
			(1, 'Alberto', 'Flores', 20),
            (2, 'Lara', 'López', 22),
            (3, 'Juán', 'Rico', 18),
            (4, 'Ana', 'Coronado', 19),
            (5, 'Cinthya', 'Sánchez', 24),
            (6, 'Juana', 'García', 21),
            (7, 'Pepe', 'Flores', 18),
            (8, 'Adrián', 'Navarro', 26),
            (9, 'Frán', 'Martínez', 29),
            (10, 'María', 'López', 17),
            (11, 'Marina', 'Carmona', 21),
            (12, 'Irene', 'Lopez', 28),
            (13, 'Clara', 'Alguacil', 18),
            (14, 'Natalia', 'Alvarez', 56);
            
INSERT INTO Cafeteria
			(id, nombre, fecApert, costePedidoMensu, idEncargado)
		VALUES
			(1, 'Tudela', '2013/06/14', 378.90, 1),
            (2, 'Bonbon', '2017/12/01', 500.00, 2),
            (3, 'Gatuno', '2020/01/20', 608.79, 3),
            (4, 'Michife', '2022/05/21', 189.79, 4),
            (5, 'Miuas', '2023/01/21', 876.79, 5);
            
INSERT INTO Gato
			(id, nombre, raza, edad, idCafeteria)
		VALUES
			(1, 'Nino','Persa', 3, 1),
            (2, 'kity','Siames', 1, 1),
            (3, 'Luna','Shortair', 5, 1),
            (4, 'Frido','Asiático', 4, 1),
            (5, 'Isis','Ruso', 8, 1),
            (6, 'Mishi','Balinés', 2, 2),
            (7, 'Uma','Bengalí', 9, 2),
            (8, 'Joya','Birmano', 6, 2),
            (9, 'Zoe','Bombay', 1, 2),
            (10, 'Coco','Siberiano', 5, 2),
            (11, 'Vela','Gambino', 3, 3),
            (12, 'Pelusa','Elfo', 2, 3),
            (13, 'Rosa','Lobo', 1, 3),
            (14, 'Tito','Americano', 7, 3),
            (15, 'Rayo','Belga', 4, 3),
            (16, 'Flash','Ceilan', 5, 4),
            (17, 'Romeo','Thau', 2, 4),
            (18, 'Verdi','Neva', 6, 4),
            (19, 'Dafne','Bombay', 1, 4),
            (20, 'Atenea','Persa', 8, 4);
            



/*
DROP TABLE Gato;
DROP TABLE Cafeteria;
DROP TABLE Encargado;
*/	