ALTER TABLE SERVICIO
	ADD CONSTRAINT FK_SERVICIO
		FOREIGN KEY (CLIENTE)
		REFERENCES CLIENTE (ID);