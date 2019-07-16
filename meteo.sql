CREATE USER meteo IDENTIFIED BY meteo;
grant dba to meteo;

CREATE TABLE PREVISIONS(
	idPrevision VARCHAR(10),
	datePrevision TIMESTAMP,
	descPrevision VARCHAR(30),
	tempMax Decimal(10,2),
	tempMin Decimal(10,2),
	idRegion VARCHAR(10),
	PRIMARY KEY (idPrevision),
	FOREIGN KEY(idRegion) REFERENCES REGION(idRegion)
);



CREATE TABLE REGION(
	idRegion VARCHAR(10),
	nomRegion VARCHAR(20),
	tempMoyenRegion DECIMAL(10,2),
	PRIMARY KEY(idRegion)
);


INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('1','Analamanga',20);
INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('2','Itasy',18);
INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('3','Vakinakaratra',17);
INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('4','Bongolava',30);
INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('5','Betsimisaraka',29);
INSERT INTO REGION(idRegion,nomRegion,tempMoyenRegion) VALUES ('6','Androy',33);



INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('1','30-05-2019 00:00:00','matin:averse:aprmidi:couvert',25,18,'1');
INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('2','30-05-2019 00:00:00','matin:pluie:aprmidi:eclairci',22,15,'2');
INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('3','30-05-2019 00:00:00','matin:averse:aprmidi:soleil',20,14,'3');
INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('4','30-05-2019 00:00:00','matin:degage:aprmidi:orage',28,20,'4');
INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('5','30-05-2019 00:00:00','matin:crachat:aprmidi:pluie',29,22,'5');
INSERT INTO PREVISIONS(idPrevision,datePrevision,descPrevision,tempMax,tempMin,idRegion)
VALUES ('6','30-05-2019 00:00:00','matin:degage:aprmidi:soleil',33,25,'6');