CREATE TABLE CLIENTE (
	ID CHAR(15) NOT NULL,
	NOMBRE CHAR(20) NOT NULL,
	APELLIDO CHAR(20) NOT NULL,
	DIRECCION VARCHAR(60),
	GENERO BOOLEAN NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL,
	TIPO_SANGRE SMALLINT NOT NULL,
	RH BOOLEAN NOT NULL,
	EPS CHAR(5) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE SERVICIO (
	CLIENTE CHAR(15) NOT NULL,
	ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	DESCRIPCION VARCHAR(100) NOT NULL,
	PRIMARY KEY (CLIENTE, ID)
);

CREATE TABLE EPS (
	ID INT NOT NULL,
	NOMBRE CHAR(20) NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE EJERCICIO (
    CLIENTE CHAR(15) NOT NULL,
    DIA INT NOT NULL,
    NOMBRE CHAR(15) NOT NULL,
    SERIES INT NOT NULL,
    REPETICIONES INT NOT NULL,
    PESO    INT,
    PRIMARY KEY (NOMBRE)
);