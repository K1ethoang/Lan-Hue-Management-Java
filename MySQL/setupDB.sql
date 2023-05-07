-- Tạo DB
CREATE DATABASE IF NOT EXISTS LanHueManagement;

-- Sử dụng DB
USE LanHueManagement;

-- 				Tạo bảng Customer
-- DROP TABLE Customer;
CREATE TABLE IF NOT EXISTS Customer(
	CustomerID INT UNSIGNED AUTO_INCREMENT,
    `Name` VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(10) NOT NULL,
    Sex BIT NOT NULL,
    UN_CitizenNumber VARCHAR(12),
    Address TEXT NOT NULL,
    CONSTRAINT PkCustomer_CustomerID PRIMARY KEY (CustomerId),
    CONSTRAINT UnCustomer_UN_CitizenNumber UNIQUE (UN_CitizenNumber),
    CONSTRAINT CkCustomer_PhoneNumber CHECK (LENGTH(PhoneNumber) = 10),
    CONSTRAINT CkCustomer_UN_CitizenNumber CHECK (LENGTH(UN_CitizenNumber) = 12)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Customer;
-- NSERT INTO Customer(Name,PhoneNumber,UN_CitizenNumber,Address) VALUES ("Hoàng Gia Kiệt", "0784265174", "123123123123", "123");

-- 				Tạo bảng PaymentStatus
-- DROP TABLE PaymentStatus;
CREATE TABLE IF NOT EXISTS PaymentStatus(
	PaymentStatusID INT UNSIGNED AUTO_INCREMENT,
    UN_StatusCode INT NOT NULL,
    StatusName VARCHAR(100) NOT NULL,
    CONSTRAINT PkPaymentStatus_PaymentStatusID PRIMARY KEY (PaymentStatusID),
    CONSTRAINT UnPaymentStatus_UN_StatusCode UNIQUE (UN_StatusCode)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE PaymentStatus;
-- INSERT INTO PaymentStatus (UN_StatusCode, StatusName) VALUES (-1, "Sắp tới");

-- 				Tạo bảng HappenStatus
-- DROP TABLE HappenStatus;
CREATE TABLE IF NOT EXISTS HappenStatus(
	HappenStatusID INT UNSIGNED AUTO_INCREMENT,
    UN_StatusCode INT NOT NULL,
    StatusName VARCHAR(100) NOT NULL,
    CONSTRAINT PkHappenStatus_HappenStatusID PRIMARY KEY (HappenStatusID),
    CONSTRAINT UnHappenStatus_UN_StatusCode UNIQUE (UN_StatusCode)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE HappenStatus;
-- INSERT INTO HappenStatus (UN_StatusCode, StatusName) VALUES (0, "Chưa thanh toán");

--				Tạo bảng `Role`
-- DROP TABLE Role;
CREATE TABLE IF NOT EXISTS Role(
	RoleID INT UNSIGNED AUTO_INCREMENT,
    RoleName VARCHAR(255) NOT NULL,
    CONSTRAINT PkRole_RoleID PRIMARY KEY (RoleID)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Role;
-- INSERT INTO Role (UN_RoleCode, RoleName) VALUES ("CT1", "Chạy tiệc")

--				Tạo bảng TypeDish
-- DROP TABLE TypeDish;
CREATE TABLE IF NOT EXISTS TypeDish(
	TypeDishID INT UNSIGNED AUTO_INCREMENT,
	UN_TypeName VARCHAR(200) NOT NULL,
    CONSTRAINT PkTypeDish_TypeDishID PRIMARY KEY (TypeDishID),
    CONSTRAINT UnTypeDish_UN_TypeName UNIQUE (UN_TypeName)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE TypeDish;
-- INSERT INTO TypeDish (UN_TypeName) VALUES ("Tráng miệng");

-- 				Tạo bảng Staff
-- DROP TABLE Staff;
CREATE TABLE IF NOT EXISTS Staff(
	StaffID INT UNSIGNED AUTO_INCREMENT,
    `Name` VARCHAR(255) NOT NULL,
    Sex BIT NOT NULL,
    PhoneNumber VARCHAR(10) NOT NULL,
	UN_CitizenNumber VARCHAR(12) UNIQUE,
    Address VARCHAR(300),
    RoleID INT UNSIGNED,
    CONSTRAINT PkStaff_StaffID PRIMARY KEY (StaffID),
    CONSTRAINT FkStaff_RoleID FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Staff;
-- INSERT INTO Staff (Name, PhoneNumber, UN_CitizenNumber, Address) VALUES ("Nguyễn Văn A", "037415782", "123123123123", "Quận 9, TP. Hồ Chí Minh");

-- 				Tạo bảng Dish
-- DROP TABLE Dish;
CREATE TABLE IF NOT EXISTS Dish(
	DishID INT UNSIGNED AUTO_INCREMENT,
    DishName VARCHAR(255) NOT NULL,
    Price DOUBLE DEFAULT 0,
    TypeDishID INT UNSIGNED,
    CONSTRAINT PkDish_DishID PRIMARY KEY (DishID),
    CONSTRAINT FkDish_TypeDishID FOREIGN KEY (TypeDishID) REFERENCES TypeDish(TypeDishID)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Dish;
-- INSERT INTO Dish (DishName) VALUES ("Cơm chiên cá mặn");

-- 				Tạo bảng TypeParty
-- DROP TABLE TypeParty;
CREATE TABLE IF NOT EXISTS TypeParty(
	TypePartyID INT UNSIGNED AUTO_INCREMENT,
    UN_TypeName VARCHAR(100) NOT NULL,
    CONSTRAINT PkTypeParty_TypePartyID PRIMARY KEY (TypePartyID) ,
    CONSTRAINT UnTypeParty_UN_TypeName UNIQUE (UN_TypeName)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE TypeParty;
-- INSERT INTO TypeParty (UN_TypeName) VALUES ("Tiệc cưới");

-- 				Tạo bảng Party
-- DROP TABLE Party;
CREATE TABLE IF NOT EXISTS Party(
	PartyID INT UNSIGNED AUTO_INCREMENT,
    PartyName TEXT,
    TableNumber TINYINT UNSIGNED,
    `Date` DATE,
    `Time` TIME,
    Location TEXT,
    Note TEXT,
    CustomerID INT UNSIGNED,
    HappenStatusID INT UNSIGNED,
    PaymentStatusID INT UNSIGNED,
    TypePartyID INT UNSIGNED,
    CONSTRAINT PkParty_PartyID PRIMARY KEY (PartyID),
    CONSTRAINT FkParty_CustomerID FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    CONSTRAINT FkParty_HappenStatusID FOREIGN KEY (HappenStatusID) REFERENCES HappenStatus(HappenStatusID),
    CONSTRAINT FkParty_PaymentStatusID FOREIGN KEY (PaymentStatusID) REFERENCES PaymentStatus(PaymentStatusID),
    CONSTRAINT FkParty_TypePartyID FOREIGN KEY (TypePartyID) REFERENCES TypeParty(TypePartyID),
    CONSTRAINT CkParty_Date CHECK (`Date` > sysdate()),
    CONSTRAINT CkParty_TableNumber CHECK (TableNumber >= 2)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Party;

-- 				Tạo bảng Invoice
-- DROP TABLE Invoice;
CREATE TABLE Invoice(
	InvoiceID INT UNSIGNED AUTO_INCREMENT,
    `Time` TIMESTAMP,
    Total DOUBLE DEFAULT 0,
	StaffID INT UNSIGNED,
    PartyID INT UNSIGNED,
    CustomerID INT UNSIGNED,
    CONSTRAINT PkInvoice_InvoiceID PRIMARY KEY (InvoiceID),
    CONSTRAINT FkInvoice_PartyID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
	CONSTRAINT FkInvoice_CustomerID FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
) DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
-- TRUNCATE TABLE Invoice;

-- 				Tạo bảng OderItem
-- DROP TABLE OderItem;
-- CREATE TABLE OderItem(
-- 	PartyID INT UNSIGNED,
--     DishID INT UNSIGNED,
--     CONSTRAINT PkOrderItem_PartyID_DishID PRIMARY KEY (PartyID,DishID),
--     CONSTRAINT FkOrderItem_PartyID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
--     CONSTRAINT FkOrderItem_DishID FOREIGN KEY (DishID) REFERENCES Dish(DishID)
-- );
-- TRUNCATE TABLE OderItem;

-- 				Tạo bảng Order
-- DROP TABLE Order;
CREATE TABLE `Order`(
	PartyID INT UNSIGNED,
    DishID INT UNSIGNED,
    CONSTRAINT PkOrder_PartyID_DishID PRIMARY KEY (PartyID,DishID),
    CONSTRAINT FkOrder_PartyID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
    CONSTRAINT FkOrder_DishID FOREIGN KEY (DishID) REFERENCES Dish(DishID)
);

-- 				Tạo bảng DetailInvoice
-- DROP TABLE DetailInvoice;
CREATE TABLE DetailInvoice(
	DetailInvoiceID INT UNSIGNED AUTO_INCREMENT,
    `Number` TINYINT UNSIGNED,
    UnitPrice DOUBLE,
    Total DOUBLE,
    DishID INT UNSIGNED,
    InvoiceID INT UNSIGNED,
    CONSTRAINT PkDetailInvoice_DetailInvoiceID PRIMARY KEY (DetailInvoiceID),
    CONSTRAINT FkDetailInvoice_DishID FOREIGN KEY (DishID) REFERENCES Dish(DishID),
    CONSTRAINT FkDetailInvoice_InvoiceID FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID)
) AUTO_INCREMENT=1;
-- TRUNCATE TABLE DetailInvoice;

-- 				Tạo bảng Work
-- DROP TABLE Work;
CREATE TABLE Work(
	PartyID INT UNSIGNED,
    StaffID INT UNSIGNED,
    Salary DOUBLE DEFAULT 0,
    CONSTRAINT PkWork_PartyID_StaffID PRIMARY KEY (PartyID,StaffID),
    CONSTRAINT FkWork_DishID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
    CONSTRAINT FkWork_InvoiceID FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);
-- TRUNCATE TABLE Work;

-- 				Tạo bảng Account
-- DROP TABLE Account;
CREATE TABLE Account(
	AccountID INT UNSIGNED AUTO_INCREMENT,
    UN_Username VARCHAR(255) NOT NULL,
    `Password` TEXT NOT NULL,
	Email VARCHAR(255),
    StaffID INT UNSIGNED,
	RoleID INT UNSIGNED,
    CONSTRAINT PkAccount_AccountID PRIMARY KEY (AccountID),
    CONSTRAINT UnAccount_UN_Username UNIQUE (UN_Username),
    CONSTRAINT FkAccount_StaffID FOREIGN KEY (StaffID) REFERENCES Staff(StaffID),
	CONSTRAINT FkAccount_RoleID FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
) AUTO_INCREMENT=1;
-- TRUNCATE TABLE Account;

INSERT INTO `lanhuemanagement`.`account` (`AccountID`, `UN_Username`, `Password`) VALUES 
('1', 'admin', 'admin123'),
('2', 'staff', 'staff123')
;

-- use lanhuemanagement;
-- SELECT p.*, tp.UN_TypeName AS typeParty, c.name AS customerName, c.phoneNumber as customerPhoneNumber,
-- hp.UN_StatusCode AS happenCode, hp.statusName AS happenName, 
-- ps.UN_StatusCode AS paymentCode, ps.statusName AS paymentName
-- FROM party p
-- JOIN customer c ON p.customerID = c.customerID
-- JOIN happenStatus hp ON p.HappenStatusID = hp.HappenStatusID
-- JOIN paymentStatus ps ON p.PaymentStatusID = ps.PaymentStatusID
-- JOIN typeParty tp ON p.typePartyID = tp.typePartyID
-- ORDER BY p.partyID DESC;

-- SELECT * FROM customer
-- WHERE CustomerID = 1;

-- SELECT * FROM TypeParty WHERE TypePartyID=1;
-- SELECT * FROM Party
-- ORDER BY PartyID DESC;

-- SELECT * FROM HappenStatus WHERE HappenStatusID = 1;
-- SELECT * FROM PaymentStatus WHERE PaymentStatusID = 1;

-- DELETE FROM Party WHERE PartyID = 1;

-- use lanhuemanagement;
-- SELECT *
-- FROM typeparty;



SELECT AUTO_INCREMENT as `nextID`
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = database()
AND TABLE_NAME = "dish";

-- 											Trigger

