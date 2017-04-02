create database if not exists `amazonsystemdb`;

use amazonsystemdb;

CREATE TABLE Customer(        
       Username     VARCHAR (20)     NOT NULL UNIQUE,
       Password     CHAR(32)         NOT NULL,
       Age          INT              NOT NULL,
       phoneNumber  VARCHAR(19)      NOT NULL,
       UserMSG      TEXT(501)           , 
       Email        VARCHAR(50)         ,
       PRIMARY KEY (Username)              
);

CREATE TABLE Administer(
       Username             VARCHAR (20)     NOT NULL UNIQUE,
       Password             CHAR (32)        NOT NULL,
       PRIMARY KEY (Username)
);

CREATE TABLE ProductType(
       TypeID       INT              NOT NULL UNIQUE,
       TypeText     VARCHAR (50)     NOT NULL,
       PRIMARY KEY (TypeID)
); 

CREATE TABLE Product(
       ProductID        INT             NOT NULL UNIQUE,
       ProductName      VARCHAR (50)    NOT NULL,
       TypeID           INT             NOT NULL,
       Quantity         INT             NOT NULL,
       PRIMARY KEY (ProductID)                  ,
       FOREIGN KEY (TypeID) REFERENCES ProductType(TypeID),
       CHECK ( Quantity >= 0 )
);

 INSERT INTO Customer (Username,  Password, Age, phoneNumber, UserMSG, Email)
                VALUES ( 'joe'   , '1D10T', 32,  '0838643219','Ahmedabad', 'sdutbruce@outlook.com');

 INSERT INTO Administer (Username, Password )
                VALUES ('toor'   , '4uIdo0!' );
 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (1, 'Meat' );
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (2, 'Vagetable' );


INSERT INTO Product (ProductID, ProductName, TypeID, Quantity)
             VALUES (2        , 'Irish Potato', 2  ,  223       );

INSERT INTO Product (ProductID, ProductName, TypeID, Quantity )
             VALUES (2        , 'Chinese Potato', 2  ,  43       );

INSERT INTO Product (ProductID, ProductName, TypeID, Quantity )
             VALUES (1        , 'Irish Beef' , 1  ,  140        );


SELECT * FROM Customer;
SELECT * FROM Administer;
SELECT * FROM Product;
SELECT * FROM ProductType;
