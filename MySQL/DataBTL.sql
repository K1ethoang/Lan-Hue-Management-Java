INSERT INTO Customer (Name, UN_PhoneNumber, Sex, UN_CitizenNumber, Address) 
VALUES
	('Nguyễn Văn Vũ', '0123456789', 1, '123456789012', '78 đường 17, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai'),
	('Nguyễn Ninh Ninh', '0234567890', 0, '234567890123', '76/2 đường Phạm Văn Đồng, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai'),
	('Lý Tiểu Long', '0345678901', 1, '345678901234', '26 đường 16, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai'),
	('Đoàn Thị Minh Nguyệt', '0456789012', 0, '456789012345', '34/2A, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai'),
	('Chu Văn Chương', '0567890123', 1, '567890123456', '24 đường Lê Văn Chí, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai');
    
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
	('Tráng miệng'),
    ('Món súp'),
	('Khai vị'), 
    ('Gỏi'),
    ('Mực'),
    ('Gà'),
    ('Vịt'),
    ('Bò'),
    ('Cá'),
    ('Tôm'),
	('Lẩu');

INSERT INTO Staff(Name, Sex, UN_PhoneNumber, UN_CitizenNumber, Address, RoleID)
VALUES
	('Nguyễn Văn Trí', 1, '0123456789', '012345678901', '78 đường 17, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 1),
	('Phạm Thị Trang', 0, '0234567890', '123456789012', '66/2 đường 18, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 2),
	('Trần Văn Nguyễn Ánh', 0, '0345678901', '234567890123', '64/2 đường 18, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 3),
	('Lê Quốc Công Thần', 1, '0456789012', '345678901234', '25 Phạm Văn Đồng, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 2),
	('Vũ Văn Phong', 1, '0567890123', '456789012345', '66 Trần Quang Diệu, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 4);

INSERT INTO Dish(DishName, CostPrice, TypeDishID)
VALUES 
	('Rau câu', 20000, 1),
    ('Trái cây', 30000, 1),
    ('Sữa chua', 80000, 1),
    ('Súp cua gà', 200000, 2),
    ('Súp hải sản', 200000, 2),
    ('Súp thập cẩm', 180000, 2),
    ('Súp tóc tiên', 180000, 2),
    ('Chả đùm - Bánh đa', 100000, 3),
    ('Khai vị - Kim chi', 90000, 3),
    ('Khai vị gỏi - Phồng tôm', 100000, 3),
	('Gỏi dồi trường - phồng tôm', 100000, 4),
    ('Gỏi bò Hồng Kông - phồng tôm', 90000, 4),
    ('Gỏi trộn cải mầm - phồng tôm', 80000, 4),
    ('Bò trộn ngũ sắc - phồng tôm', 110000, 4),
    ('Bò tái thấu - phồng tôm', 100000, 4),
    ('Mực hấp gừng', 150000, 5),
    ('Mực xào sa tế', 140000, 5),
    ('Mực chiên giòn', 160000, 5),
    ('Mực chiên xù', 150000, 5),
    ('Gà chiên giòn', 300000, 6),
    ('Cánh gà quay', 200000, 6),
    ('Gà hấp nấm - Xôi', 280000, 6),
    ('Gà sốt Pa tê - Bánh mì', 300000, 6),
    ('Gà nướng xí muội', 280000, 6),
    ('Gà tiềm thuốc bắc - Xà lách Xoong', 320000, 6),
    ('Vịt quay', 250000, 7), 
    ('Vịt tiềm - Mì', 270000, 7),
    ('Vịt nướng xí muội', 270000, 7),
    ('Bò hầm tiêu xanh - Bánh mì', 280000, 8),
    ('Bò nhúng dấm', 250000, 8),
    ('Bò lúc lắc - Khoai tây chiên', 280000, 8),
    ('Bò sốt rượu vang - Bánh mì', 300000, 8),
    ('Bê né - Bông thiên lý', 260000, 8),
    ('Cá lóc hấp bánh tráng', 200000, 9),
    ('Cá tai tượng chiên xù', 210000, 9),
    ('Cá chẻm phi lê chiên giòn', 190000, 9),
    ('Tôm hấp bia', 200000, 10),
    ('Tôm sốt me', 220000, 10),
    ('Tôm chiên xù', 210000, 10),
    ('Tôm sốt chanh dây', 220000, 10),
    ('Tôm cháy tổi', 200000, 10),
    ('Tôm nướng giấy bạc', 210000, 10),
    ('Lẩu Thái bún', 200000, 11),
    ('Lẩu gà lá giang', 200000, 11),
    ('Lẩu hải sản nấm - bún', 220000, 11),
    ('Lẩu thập cẩm - Mì vàng', 220000, 11),
    ('Lẩu cua đồng - mồng tơi - bún', 200000, 11),
	('Lẩu cá lăng - Bún', 300000, 11);

INSERT INTO TypeParty (UN_TypeName) 
VALUES
	('Sinh nhật'),
	('Đám cưới'),
	('Đám tang'),
	('Đám giỗ'),
	('Lễ khai trương');
    
INSERT INTO Party(PartyName, TableNumber, Date, Time, Location, Note, CustomerID, HappenStatusID, PaymentStatusID, TypePartyID)
VALUES 
	('Đám cưới Ngọc và Huy', 100, '2023-05-16', ' 15:00:00', '78 đường 17, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 'Note for Party A', 1, 1, 1, 1),
	('Khai trương Phát Đạt', 8, '2023-06-20','18:30:00', '64/2 đường 18, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 'Note for Party B', 2, 2, 2, 2),
	('Sinh nhật Gia Bảo', 10, '2023-07-10','12:00:00', '66/2 đường 18, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 'Note for Party C', 3, 3, 2, 1),
	('Khai trương Thuận Phát', 6, '2023-08-05', '19:00:00', '66 Trần Quang Diệu, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai'	, 'Note for Party D', 4, 2, 1, 3),
	('Đám cưới Tần và Thủy', 120, '2023-09-02', '16:00:00', '25 Phạm Văn Đồng, Phường Trảng Dài, Thành phố Biên Hòa, Tỉnh Đồng Nai', 'Note for Party E', 5, 1, 2, 4);
    
INSERT INTO Invoice(`Time`, Total, StaffID, PartyID, CustomerID)
VALUES 
	('2023-04-21 10:00:00', 12000.00, 1, 1, 1),
	('2023-04-20 18:30:00', 500, 2, 3, 2),
	('2023-04-19 21:15:00', 100.00, 3, 2, 3),
	('2023-04-18 12:45:00', 550.00, 4, 4, 4),
	('2023-04-17 20:00:00', 15000.00, 5, 5, 5);

INSERT INTO `Order`(PartyID, DishID, Price) 
VALUES
    (1, 1, 100000),
	(1, 2, 100000),
	(2, 3, 50000),
	(2, 4, 50000),
	(3, 5, 50000),
	(4, 1, 50000),
	(4, 3, 50000),
	(5, 2, 50000),
	(5, 5, 50000);
	
    
INSERT INTO work(PartyID, StaffID, Salary)
VALUES
	(1, 1, 400000),
    (1, 2, 600000),
    (1, 3, 400000),
    (1, 4, 600000),
    (1, 5, 400000),
    
    (2, 1, 400000),
    (2, 2, 600000),
    (2, 3, 400000),
    (2, 4, 600000),
    (2, 5, 400000),
    
    (3, 1, 400000),
    (3, 2, 600000),
    (3, 3, 400000),
    (3, 4, 600000),
    (3, 5, 400000),
    
    (4, 1, 400000),
    (4, 2, 600000),
    (4, 3, 400000),
    (4, 4, 600000),
    (4, 5, 400000),
    
    (5, 1, 400000),
    (5, 2, 600000),
    (5, 3, 400000),
    (5, 4, 600000),
    (5, 5, 400000);
    
    




