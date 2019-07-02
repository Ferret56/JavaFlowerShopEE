CREATE TABLE USERS(
      "ID" INT NOT NULL,
      "USERNAME" VARCHAR2(50) NOT NULL,
      "PASSWORD" VARCHAR2(50) NOT NULL,
      "ROLE" INT NOT NULL REFERENCES ROLES('ID'),
       PRIMARY KEY("ID")
);

----------------------------- 0 for the USER------------------------------------
----------------------------- 1 for the ADMIN-----------------------------------
INSERT INTO USERS(ID, USERNAME, PASSWORD, ROLE) VALUES (1,'admin','admin',1 );



CREATE TABLE ROLES(
    "ID" INT NOT NULL,
    "ROLE_TYPE" VARCHAR2(10) NOT NULL,
    PRIMARY KEY("ID")
 );

 INSERT INTO ROLES(ID, ROLE_TYPE) VALUES (0,'USER');
 INSERT INTO ROLES(ID, ROLE_TYPE) VALUES (1,'ADMIN');
