INSERT INTO Customer (Name, PhoneNumber, Sex, UN_CitizenNumber, Address) 
VALUES
	('John Doe', '0123456789', 1, '123456789012', '123 Main St, Anytown, USA'),
	('Jane Smith', '0234567890', 0, '234567890123', '456 Elm St, Anytown, USA'),
	('Bob Johnson', '0345678901', 1, '345678901234', '789 Oak St, Anytown, USA'),
	('Alice Williams', '0456789012', 0, '456789012345', '321 Pine St, Anytown, USA'),
	('David Lee', '0567890123', 1, '567890123456', '654 Maple St, Anytown, USA');
    
INSERT INTO PaymentStatus (UN_StatusCode, StatusName)
VALUES 
	(0, 'Chưa'), 
	(1, 'Xong');
    
INSERT INTO HappenStatus (UN_StatusCode, StatusName)
VALUES 
	(0, 'Sắp tới'), 
	(1, 'Đang tổ chức'), 
	(2, 'Đã xong');

INSERT INTO Role (RoleName) VALUES
    ('Chạy bàn'),
    ('Nhà bếp'),
    ('Tài xế'),
    ('Quản trị viên');
    
	
 INSERT INTO TypeDish (UN_TypeName) 
 VALUES 
	('Khai vị'), 
	('Tráng miệng'), 
	('Lẩu');

INSERT INTO Staff(Name, Sex, PhoneNumber, UN_CitizenNumber, Address, RoleID)
VALUES
	('Nguyễn Văn A', 0, '0123456789', '012345678901', 'Hà Nội', 1),
	('Phạm Thị B', 1, '0234567890', '123456789012', 'TP.HCM', 2),
	('Trần Văn C', 0, '0345678901', '234567890123', 'Đà Nẵng', 3),
	('Lê Thị D', 1, '0456789012', '345678901234', 'Nha Trang', 2),
	('Vũ Văn E', 0, '0567890123', '456789012345', 'Hải Phòng', 4);

INSERT INTO Dish(DishName, CostPrice, TypeDishID)
VALUES 
	('Phở bò', 50000, 1),
	('Bún chả giò', 60000, 1),
	('Bánh xèo', 45000, 1),
	('Bánh mì thịt', 25000, 1),
	('Gà chiên nước mắm', 80000, 2),
	('Bò tái chanh', 120000, 2),
	('Sườn non chiên giòn', 90000, 2),
	('Cá lóc kho tộ', 150000, 2),
	('Trái cây tươi', 40000, 3),
	('Bánh flan', 45000, 3),
	('Chè trôi nước', 35000, 3),
	('Kem dâu', 50000, 3),
	('Lẩu thái', 250000, 1),
	('Lẩu gà', 200000, 2),
	('Lẩu cá', 300000, 3);

INSERT INTO TypeParty (UN_TypeName) 
VALUES
	('Sinh nhật'),
	('Đám cưới'),
	('Đám tang'),
	('Đám giỗ'),
	('Lễ khai trương');
    
INSERT INTO Party(PartyName, TableNumber, Date, Time, Location, Note, CustomerID, HappenStatusID, PaymentStatusID, TypePartyID)
VALUES 
	('Đám cưới Ngọc và Huy', 100, '2023-05-15', ' 15:00:00', 'Hanoi', 'Note for Party A', 1, 1, 1, 1),
	('Khai trương Phát Đạt', 8, '2023-06-20','18:30:00', 'Ho Chi Minh City', 'Note for Party B', 2, 2, 2, 2),
	('Sinh nhật Gia Bảo', 10, '2023-07-10','12:00:00', 'Da Nang', 'Note for Party C', 3, 3, 2, 1),
	('Khai trương Thuận Phát', 6, '2023-08-05', '19:00:00', 'Nha Trang', 'Note for Party D', 4, 2, 1, 3),
	('Đám cưới Tần và Thủy', 120, '2023-09-02', '16:00:00', 'Ha Long', 'Note for Party E', 5, 1, 2, 4);
    
INSERT INTO Invoice(`Time`, Total, StaffID, PartyID, CustomerID)
VALUES 
	('2023-04-21 10:00:00', 12000.00, 1, 1, 1),
	('2023-04-20 18:30:00', 500, 2, 3, 2),
	('2023-04-19 21:15:00', 100.00, 3, 2, 3),
	('2023-04-18 12:45:00', 550.00, 4, 4, 4),
	('2023-04-17 20:00:00', 15000.00, 5, 5, 5);

INSERT INTO `Order`(PartyID, DishID) 
VALUES
	(1, 1),
	(1, 2),
	(2, 3),
	(2, 4),
	(3, 5),
	(4, 1),
	(4, 3),
	(5, 2),
	(5, 5);



