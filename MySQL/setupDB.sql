-- Tạo DB
DROP DATABASE IF EXISTS LanHueManagement;
CREATE DATABASE LanHueManagement
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Sử dụng DB
USE LanHueManagement;

-- Cài đặt
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


-- 				Tạo bảng Customer
CREATE TABLE IF NOT EXISTS Customer(
	CustomerID INT UNSIGNED AUTO_INCREMENT,
    `Name` VARCHAR(255) NOT NULL,
    UN_PhoneNumber VARCHAR(10) NOT NULL,
    Sex BIT NOT NULL,
    UN_CitizenNumber VARCHAR(12) NOT NULL,
    Address TEXT NOT NULL,
    CONSTRAINT PkCustomer_CustomerID PRIMARY KEY (CustomerId),
    CONSTRAINT UnCustomer_UN_PhoneNumber UNIQUE (UN_PhoneNumber),
    CONSTRAINT UnCustomer_UN_CitizenNumber UNIQUE (UN_CitizenNumber),
    CONSTRAINT CkCustomer_UN_PhoneNumber CHECK (LENGTH(UN_PhoneNumber) = 10),
    CONSTRAINT CkCustomer_UN_CitizenNumber CHECK (LENGTH(UN_CitizenNumber) = 12)
);

-- 				Tạo bảng PaymentStatus
CREATE TABLE IF NOT EXISTS PaymentStatus(
	PaymentStatusID INT UNSIGNED AUTO_INCREMENT,
    UN_StatusCode INT NOT NULL,
    StatusName VARCHAR(100) NOT NULL,
    CONSTRAINT PkPaymentStatus_PaymentStatusID PRIMARY KEY (PaymentStatusID),
    CONSTRAINT UnPaymentStatus_UN_StatusCode UNIQUE (UN_StatusCode)
);

-- 				Tạo bảng HappenStatus
CREATE TABLE IF NOT EXISTS HappenStatus(
	HappenStatusID INT UNSIGNED AUTO_INCREMENT,
    UN_StatusCode INT NOT NULL,
    StatusName VARCHAR(100) NOT NULL,
    CONSTRAINT PkHappenStatus_HappenStatusID PRIMARY KEY (HappenStatusID),
    CONSTRAINT UnHappenStatus_UN_StatusCode UNIQUE (UN_StatusCode)
);

--				Tạo bảng `Role`
CREATE TABLE IF NOT EXISTS Role(
	RoleID INT UNSIGNED AUTO_INCREMENT,
    RoleName VARCHAR(255) NOT NULL,
    CONSTRAINT PkRole_RoleID PRIMARY KEY (RoleID)
);

--				Tạo bảng TypeDish
CREATE TABLE IF NOT EXISTS TypeDish(
	TypeDishID INT UNSIGNED AUTO_INCREMENT,
	UN_TypeName VARCHAR(200) NOT NULL,
    CONSTRAINT PkTypeDish_TypeDishID PRIMARY KEY (TypeDishID),
    CONSTRAINT UnTypeDish_UN_TypeName UNIQUE (UN_TypeName)
);

-- 				Tạo bảng Staff
CREATE TABLE IF NOT EXISTS Staff(
	StaffID INT UNSIGNED AUTO_INCREMENT,
    `Name` VARCHAR(255) NOT NULL,
    Sex BIT NOT NULL,
    UN_PhoneNumber VARCHAR(10) NOT NULL,
	UN_CitizenNumber VARCHAR(12) NOT NULL,
    Address VARCHAR(300) NOT NULL,
    RoleID INT UNSIGNED NOT NULL,
    CONSTRAINT PkStaff_StaffID PRIMARY KEY (StaffID),
    CONSTRAINT UnStaff_UN_PhoneNumber UNIQUE (UN_PhoneNumber),
    CONSTRAINT UnStaff_UN_CitizenNumber UNIQUE (UN_CitizenNumber),
	CONSTRAINT CkStaff_UN_PhoneNumber CHECK (LENGTH(UN_PhoneNumber) = 10),
    CONSTRAINT CkStaff_UN_CitizenNumber CHECK (LENGTH(UN_CitizenNumber) = 12),
    CONSTRAINT FkStaff_RoleID FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);

-- 				Tạo bảng Dish
CREATE TABLE IF NOT EXISTS Dish(
	DishID INT UNSIGNED AUTO_INCREMENT,
    DishName VARCHAR(255) NOT NULL,
    CostPrice DOUBLE DEFAULT 0,
    TypeDishID INT UNSIGNED,
    CONSTRAINT PkDish_DishID PRIMARY KEY (DishID),
    CONSTRAINT FkDish_TypeDishID FOREIGN KEY (TypeDishID) REFERENCES TypeDish(TypeDishID)
);

-- 				Tạo bảng TypeParty
CREATE TABLE IF NOT EXISTS TypeParty(
	TypePartyID INT UNSIGNED AUTO_INCREMENT,
    UN_TypeName VARCHAR(100) NOT NULL,
    CONSTRAINT PkTypeParty_TypePartyID PRIMARY KEY (TypePartyID) ,
    CONSTRAINT UnTypeParty_UN_TypeName UNIQUE (UN_TypeName)
);

-- 				Tạo bảng Party
CREATE TABLE IF NOT EXISTS Party(
	PartyID INT UNSIGNED AUTO_INCREMENT,
    PartyName TEXT NOT NULL,
    TableNumber TINYINT UNSIGNED NOT NULL,
    `Date` DATE NOT NULL,
    `Time` TIME NOT NULL,
    Location TEXT NOT NULL,
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
--     CONSTRAINT CkParty_Date CHECK (`Date` > DATE(sysdate())),
-- 	CONSTRAINT CkParty_Time CHECK (`Time` >= TIME(sysdate()) + INTERVAL 6 HOUR),
    CONSTRAINT CkParty_TableNumber CHECK (TableNumber >= 2)
);

-- 				Tạo bảng Invoice
CREATE TABLE Invoice(
	InvoiceID INT UNSIGNED AUTO_INCREMENT,
    `Time` TIMESTAMP NOT NULL,
    Total DOUBLE DEFAULT 0,
    PartyID INT UNSIGNED,
    CONSTRAINT PkInvoice_InvoiceID PRIMARY KEY (InvoiceID),
    CONSTRAINT FkInvoice_PartyID FOREIGN KEY (PartyID) REFERENCES Party(PartyID)
);

-- 				Tạo bảng Order
CREATE TABLE `Order`(
	PartyID INT UNSIGNED,
    DishID INT UNSIGNED,
    Price DOUBLE NOT NULL,
    CONSTRAINT PkOrder_PartyID_DishID PRIMARY KEY (PartyID, DishID),
    CONSTRAINT FkOrder_PartyID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
    CONSTRAINT FkOrder_DishID FOREIGN KEY (DishID) REFERENCES Dish(DishID)
);

-- 				Tạo bảng DetailInvoice
CREATE TABLE DetailInvoice(
	DetailInvoiceID INT UNSIGNED AUTO_INCREMENT,
    DishName VARCHAR(255) NOT NULL,
    Unit_Price DOUBLE NOT NULL,
    `Number` TINYINT UNSIGNED,
    Amount DOUBLE NOT NULL,
    InvoiceID INT UNSIGNED,
    CONSTRAINT PkDetailInvoice_DetailInvoiceID PRIMARY KEY (DetailInvoiceID),
    CONSTRAINT FkDetailInvoice_InvoiceID FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID)
);

-- 				Tạo bảng Work
CREATE TABLE Work(
	PartyID INT UNSIGNED,
    StaffID INT UNSIGNED,
    Salary DOUBLE DEFAULT 0,
    CONSTRAINT PkWork_PartyID_StaffID PRIMARY KEY (PartyID,StaffID),
    CONSTRAINT FkWork_DishID FOREIGN KEY (PartyID) REFERENCES Party(PartyID),
    CONSTRAINT FkWork_InvoiceID FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

-- 				Tạo bảng Account
CREATE TABLE Account(
	AccountID INT UNSIGNED AUTO_INCREMENT,
    UN_Username VARCHAR(255) NOT NULL,
    `Password` TEXT NOT NULL,
	Email VARCHAR(255),
    StaffID INT UNSIGNED,
    CONSTRAINT PkAccount_AccountID PRIMARY KEY (AccountID),
    CONSTRAINT UnAccount_UN_Username UNIQUE (UN_Username),
    CONSTRAINT FkAccount_StaffID FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

-- SELECT o.DishID, d.DishName, o.price FROM `order`o, dish d
-- WHERE d.DishID = o.DishID AND o.partyID = 1;

-- SELECT * FROM `Order` WHERE PartyID = 10;

-- Kiệt
-- SELECT s.staffID, s.Name, s.UN_PhoneNumber, COUNT(w.staffID) as `số tiệc đã làm` 
-- FROM Work w, Staff s
-- WHERE s.staffID = w.staffID
-- GROUP BY w.staffID;

-- Hậu
-- SELECT d.DishID, d.DishName, COUNT(o.DishID) AS `Số lần được đặt`
-- FROM `Order` o
-- JOIN Dish d ON d.DishID = o.DishID
-- GROUP BY o.DishID
-- HAVING COUNT(o.DishID) = (
--     SELECT MAX(`Số lần được đặt`)
--     FROM (
--         SELECT COUNT(DishID) AS `Số lần được đặt`
--         FROM `Order`
--         GROUP BY DishID
--     ) AS Counts
-- );

-- SELECT * FROM `order` o, dish d
-- WHERE d.DishID = o.DishID AND o.partyID = 1;


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

-- SELECT o.DishID, d.DishName, o.price FROM `order`o, dish d
-- WHERE d.DishID = o.DishID AND o.partyID = 1;

-- use lanhuemanagement;
-- SELECT *
-- FROM typeparty;

-- select * from Party where partyid = 1;

-- 								Stored Procedure
delimiter //
CREATE PROCEDURE `SP_Update_HappentStatus_In_Party`()
BEGIN
	UPDATE Party p
	SET p.happenstatusID = 
		(CASE
			WHEN p.`Date` <  DATE(sysdate()) THEN 3 -- Đã xong
			WHEN p.`Date` >  DATE(sysdate()) THEN 1 -- Sắp tới
			ELSE 2 -- Đang tổ chức
		END)
	WHERE p.happenstatusID > 0;
END //
delimiter ;
-- CALL `SP_Update_HappentStatus_In_Party`;delimiter //


delimiter //
CREATE PROCEDURE `SP_Get_Revenue_By_Month_At_Now_Year`()
BEGIN
	SELECT MONTH(`Time`) AS Month, COUNT(DISTINCT PartyID) AS NumberOfParties, SUM(Total) AS Revenue
	FROM Invoice
	WHERE YEAR(`Time`) = YEAR(CURDATE())
	GROUP BY MONTH(`Time`)
	ORDER BY MONTH(`Time`);
END //
delimiter ;
-- CALL `SP_Get_Revenue_By_Month_At_Now_Year`;


delimiter //
CREATE PROCEDURE `SP_Clear_All_Order_By_ID`(IN id INT UNSIGNED)
BEGIN
	DELETE FROM `Order`
	WHERE partyID = id;
END //
delimiter ;
-- CALL `SP_Clear_All_Order_By_ID` ();

DELIMITER //
CREATE TRIGGER trg_UpdatePaymentStatus
AFTER INSERT ON Invoice  
FOR EACH ROW
BEGIN
    -- Cập nhật trạng thái thanh toán của bảng Party
    UPDATE Party
    SET PaymentStatusID = 2 -- Giả sử 2 là mã trạng thái 'Xong'
    WHERE PartyID = NEW.PartyID;
END //
DELIMITER ;