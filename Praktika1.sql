




CREATE DATABASE shop_bd1;
use shop_bd1;

CREATE TABLE `goods` (
  `idGoods` int NOT NULL AUTO_INCREMENT,
  `goodName` varchar(45) NOT NULL,
  `goodCount` int NOT NULL DEFAULT '0',
  `goodPrice` float NOT NULL,
  PRIMARY KEY (`idGoods`)
);

CREATE TABLE `discount` (
  `idDiscount` int NOT NULL AUTO_INCREMENT,
  `amountDiscount` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idDiscount`)
);

CREATE TABLE `customers` (
  `idCustomer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `discountId` int NOT NULL,
  PRIMARY KEY (`idCustomer`),
  KEY `FK_Discount` (`discountId`),
  CONSTRAINT `FK_Discount` FOREIGN KEY (`discountId`) REFERENCES `discount` (`idDiscount`)
);

CREATE TABLE `orders` (
  `idOrders` int NOT NULL AUTO_INCREMENT,
  `CustomerId` int NOT NULL,
  `GoodId` int NOT NULL,
  `CreatedAt` date DEFAULT NULL,
  PRIMARY KEY (`idOrders`),
  KEY `FK_Customers` (`CustomerId`),
  KEY `FK_Goods` (`GoodId`),
  CONSTRAINT `FK_Customers` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`idCustomer`),
  CONSTRAINT `FK_Goods` FOREIGN KEY (`GoodId`) REFERENCES `goods` (`idGoods`)
);

CREATE TABLE `position` (
  `idPosition` int NOT NULL AUTO_INCREMENT,
  `namePosition` varchar(45) NOT NULL,
  PRIMARY KEY (`idPosition`)
);

CREATE TABLE `departament` (
  `idDepartament` int NOT NULL AUTO_INCREMENT,
  `nameDepartament` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartament`)
);

CREATE TABLE `employees` (
  `idEmployees` int NOT NULL AUTO_INCREMENT,
  `surName` varchar(45) DEFAULT NULL,
  `DepartamentId` int NOT NULL,
  `PositionId` int NOT NULL,
  PRIMARY KEY (`idEmployees`),
  KEY `FK_Departament` (`DepartamentId`),
  KEY `FK_Position` (`PositionId`),
  CONSTRAINT `FK_Departament` FOREIGN KEY (`DepartamentId`) REFERENCES `departament` (`idDepartament`),
  CONSTRAINT `FK_Position` FOREIGN KEY (`PositionId`) REFERENCES `position` (`idPosition`)
);

INSERT INTO `shop_bd1`.`departament`(`idDepartament`,`name`)
VALUES
(0,"Fish");
INSERT INTO `shop_bd1`.`departament`(`idDepartament`,`name`)
VALUES
(0,"Milk");
INSERT INTO `shop_bd1`.`departament`(`idDepartament`,`name`)
VALUES
(0,"Meet");

INSERT INTO `shop_bd1`.`position` (`idPosition`,`name`)
VALUES
(0,"Seller");
INSERT INTO `shop_bd1`.`position` (`idPosition`,`name`)
VALUES
(0,"Cleaner");

INSERT INTO `shop_bd1`.`employees`(`idEmployees`,`surName`,`DepartamentId`,`PositionId`)
VALUES
(0,"Surname2",3,1);

INSERT INTO `shop_bd`.`discount` (`idDiscount`,`amountDiscount`)
VALUES
(0,0);
INSERT INTO `shop_bd`.`discount` (`idDiscount`,`amountDiscount`)
VALUES
(0,10);
INSERT INTO `shop_bd`.`discount` (`idDiscount`,`amountDiscount`)
VALUES
(0,25);
INSERT INTO `shop_bd`.`discount` (`idDiscount`,`amountDiscount`)
VALUES
(0,50);

INSERT INTO `shop_bd`.`goods`
(`idGoods`,`goodName`,`goodCount`,`goodPrice`)
VALUES
(0,"Chees",100,20.0);

INSERT INTO `shop_bd`.`goods`
(`idGoods`,`goodName`,`goodCount`,`goodPrice`)
VALUES
(0,"Milk",75,3.0);

INSERT INTO `shop_bd`.`goods`
(`idGoods`,`goodName`,`goodCount`,`goodPrice`)
VALUES
(0,"Potato",100,1.0);

INSERT INTO `shop_bd`.`goods`
(`idGoods`,`goodName`,`goodCount`,`goodPrice`)
VALUES
(0,"Tomato",50,5.0);

INSERT INTO `shop_bd`.`goods`
(`idGoods`,`goodName`,`goodCount`,`goodPrice`)
VALUES
(0,"Trout",100,20.0);

INSERT INTO `shop_bd`.`customers`
(`idCustomer`,`name`,`surname`,`goodID`)
VALUES
(0,"Edward","Sidorenko",1);


SELECT * FROM `shop_bd`.`employees` JOIN position ON idPosition = PositionId JOIN departament ON idDepartament = DepartamentId ;

SELECT * FROM shop_bd.orders JOIN customers on idCustomer = CustomerId JOIN goods on idGoods = GoodId;











