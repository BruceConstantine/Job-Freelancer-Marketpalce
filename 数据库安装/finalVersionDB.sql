drop   database if exists `amazonsystemdb`;
create database if not exists `amazonsystemdb`; /*This is not signal qoutation ''', but the '`' on your the most left & up key on the keyboard;*/
use amazonsystemdb;

CREATE TABLE Customer(    
       Id     		INT 		     NOT NULL UNIQUE,		
       Username     VARCHAR (20)     NOT NULL UNIQUE,
       Password     VARCHAR(32)         NOT NULL,
       Age          INT              NOT NULL,
       phoneNumber  VARCHAR(19)      NOT NULL,
       UserMSG      TEXT(501)           , 
       Email        VARCHAR(50)         ,
       PRIMARY KEY (Id)              
);
INSERT INTO Customer (Id, Username,  Password, Age, phoneNumber, UserMSG, Email)
                VALUES ( 2, 'joe'   , '1D10T?', 32,  '0838643219','Ahmedabad', 'sdutbruce@outlook.com');


CREATE TABLE Administer(
       Id     				INT 		     NOT NULL UNIQUE,		
       Username             VARCHAR (20)     NOT NULL UNIQUE,
       Password             VARCHAR (32)        NOT NULL,
       PRIMARY KEY (Id)
);
INSERT INTO Administer (Id, Username , Password )
                VALUES (1 , 'toor'   , '4uIdo0!' );


CREATE TABLE ProductType(
       TypeID       INT              NOT NULL UNIQUE,
       TypeText     VARCHAR (50)     NOT NULL,
       PRIMARY KEY (TypeID)
); 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (1, 'Meat' );
 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (2, 'Vagetable' );
 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (3, 'Snack' );
				 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (4, 'Seasoning' );
				 
 INSERT INTO ProductType(TypeID, TypeText)
                 VALUES (5, 'Drink Powder' );
		
CREATE TABLE Product(
       ProductID        INT             NOT NULL UNIQUE,
       ProductName      VARCHAR (50)    NOT NULL,
       TypeID           INT             NOT NULL,
       Quantity         INT             NOT NULL,
       Price            FLOAT           NOT NULL,
       Size             INT           	NOT NULL,
       ProductDescribe  TEXT           			,
       PRIMARY KEY (ProductID)                  ,
       FOREIGN KEY (TypeID) REFERENCES ProductType(TypeID),
       CHECK ( Quantity >= 0 &&  Price >= 0 && Size >= 0) 
);
INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price, Size, ProductDescribe)
             VALUES (1        , 'Irish Potato', 2  ,  223    , 1.99 , 2000, 'Fresh f-level potatos'   );

INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (2        , 'Chinese Potato', 2  ,  43   , 5.5  , 10000, 'AAA-level potatos' );

INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (3        , 'Irish Beef' , 1  ,  140     , 4    ,  500, 'Fresh Beefs');
			 
INSERT INTO Product (ProductID, ProductName,          TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (4        , 'Chinese normal tea' , 5  ,  1010     , 2    ,  220, 'Tea from the remote China');
			 
INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (5        , 'Chinese Sprcial tea' , 5  ,  1010     , 2.4    ,  220, 'Tea from the remote China');
			 
INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (6        , 'Red Soy' ,     4  ,  1140     , 1    ,  500, 'Speciy Soy');
			 
INSERT INTO Product (ProductID, ProductName, TypeID, Quantity, Price,  Size, ProductDescribe )
             VALUES (7        , 'Chiken Powder' , 4  ,  1110     , 0.4    ,  110, 'Chiken Powders');


SELECT * FROM Customer;
SELECT * FROM Administer;
SELECT * FROM Product;
SELECT * FROM ProductType;

/* Refactor:UserID: VARCHAR(20) && Change name UserID into USERNAME */
CREATE TABLE Ordering(
       Order_ID         INT            NOT NULL,
       ProductID        INT            NOT NULL,
       Username         VARCHAR(20)    NOT NULL,
       Product_Quantity INT            NOT NULL,
       PRIMARY KEY (Order_ID, ProductID),
      -- FOREIGN KEY (Username) REFERENCES Customer(Username),
       FOREIGN KEY (Order_ID) REFERENCES Order_Record(Order_ID),
       FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
       CHECK (Product_Quantity >= 0 )
);

INSERT INTO Ordering(Order_ID, ProductID, Username, Product_Quantity)
                 VALUES (00043, 00043, 'joe', 2);

CREATE TABLE Cart(
       Username         VARCHAR(20)    NOT NULL,
       Product_ID       INT            NOT NULL,
       Product_Quantity INT            NOT NULL,
       Add_Date         TIMESTAMP      NOT NULL default CURRENT_TIMESTAMP,
       PRIMARY KEY (Username, Product_ID),
       FOREIGN KEY (Username) REFERENCES Customer(Username),
       FOREIGN KEY (Product_ID) REFERENCES Product(ProductID),
       CHECK ( Product_Quantity >= 0 )
);

INSERT INTO Cart(Username,  Product_ID, Product_Quantity)
                 VALUES ('joe', 00043, 3);


CREATE TABLE Order_Record(
       Username        VARCHAR(20)   NOT NULL,
       Order_ID        INT           NOT NULL,
       Total_Price     DOUBLE        NOT NULL,
       Order_Date      TIMESTAMP     NOT NULL default CURRENT_TIMESTAMP,
       Status          BOOLEAN       NOT NULL,
       Address         VARCHAR (50)  NOT NULL,
       FOREIGN KEY (Username) REFERENCES Customer(Username),
       PRIMARY KEY (Username, Order_ID)
);
 
INSERT INTO Order_Record(Username, Order_ID, Total_Price, Status, Address )
                  VALUES ('joe', 00043, 567.89, TRUE, 'limerrick......');

CREATE TABLE Address(
      Username         VARCHAR(20)    NOT NULL,
      Address_ID       INT           NOT NULL,
      Address          VARCHAR (50)  NOT NULL,
      FOREIGN KEY (Username) REFERENCES Customer(Username),
      PRIMARY KEY (Username, Address_ID)
);

INSERT INTO Address(Username, Address_ID, Address)
            VALUES ('joe', 000001, 'limerick..' );

SELECT * FROM Customer;
SELECT * FROM Administer;
SELECT * FROM Product;
SELECT * FROM ProductType;

SELECT * FROM Ordering;
SELECT * FROM Cart;
SELECT * FROM Order_Record;
SELECT * FROM Address;
