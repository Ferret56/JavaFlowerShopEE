
-------------------------------USERS TABLE--------------------------------------
CREATE TABLE USERS(
                      "ID" INT NOT NULL,
                      "USERNAME" VARCHAR2(50) NOT NULL,
                      "PASSWORD" VARCHAR2(50) NOT NULL,
                      "ROLE" INT NOT NULL,
                      "MONEY" INT NOT NULL,
                      PRIMARY KEY("ID")
);

----------------------------- 0 for the USER------------------------------------
----------------------------- 1 for the ADMIN-----------------------------------
INSERT INTO USERS(ID, USERNAME, PASSWORD, ROLE, MONEY) VALUES (1,'admin','admin',1,10000);


------------------------------ROLES TABLE---------------------------------------
CREATE TABLE ROLES(
                      "ID" INT NOT NULL,
                      "ROLE_TYPE" VARCHAR2(10) NOT NULL,
                      PRIMARY KEY("ID")
);

INSERT INTO ROLES(ID, ROLE_TYPE) VALUES (0,'USER');
INSERT INTO ROLES(ID, ROLE_TYPE) VALUES (1,'ADMIN');

-----------------------------FLOWERS TABLE--------------------------------------
CREATE TABLE FLOWERS(
                        "ID" INT NOT NULL,
                        "NAME" VARCHAR2(50) NOT NULL,
                        "PRICE" INT NOT NULL,
                        "AMOUNT" INT NOT NULL,
                        PRIMARY KEY("ID")
);

INSERT INTO FLOWERS(ID, NAME, PRICE, AMOUNT) VALUES  (1,'Roses',500,100);
INSERT INTO FLOWERS(ID, NAME, PRICE,AMOUNT) VALUES  (2,'Peons',100,80);
INSERT INTO FLOWERS(ID, NAME, PRICE,AMOUNT) VALUES  (3,'Tulips',250,120);
INSERT INTO FLOWERS(ID, NAME, PRICE,AMOUNT) VALUES  (4,'Lilies',300,50);
INSERT INTO FLOWERS(ID, NAME, PRICE,AMOUNT) VALUES  (5,'Orchid',650,45);


-----------------------------ORDERS TABLES------------------------

CREATE TABLE USER_ORDER(
                           "ID" INT NOT NULL,
                           "USER_ID" INT REFERENCES USERS("ID"),
                           "ORDER_COST" INT NOT NULL,
                           PRIMARY KEY("ID")
);

CREATE TABLE ORDER_ITEM(
                           "ID" INT NOT NULL,
                           "ORDER_ID" INT REFERENCES USER_ORDER("ID"),
                           "FLOWER_ID" INT REFERENCES FLOWERS("ID"),
                           "COUNT" INT NOT NULL,
                           PRIMARY KEY("ID")
);



