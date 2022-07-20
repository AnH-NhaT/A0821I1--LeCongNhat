

CREATE DATABASE ZTEST2

USE ZTEST2

CREATE TABLE KHACHHANG(
	MaKH nchar(12) PRIMARY KEY,
	TenKH nvarchar(50),
	Email nvarchar(50),
	SoDT nchar(12),
	DiaChi nvarchar(50)
)
CREATE TABLE CHITIETDONHANG(
	MaDH nchar(12) PRIMARY KEY,
	MaSP nchar(12),
	SoLuong int,
	TongTien int
)

CREATE TABLE SANPHAM(
	MaSP nchar(12) PRIMARY KEY,
	MaDM nchar(12),
	TenSP nvarchar(50),
	SoLuong int,
	GiaTien int ,
	XuatXu nvarchar(50)
)

CREATE TABLE DONHANG(
	MaDH nchar(12) PRIMARY KEY,
	MaKH nchar(12),
	MaTT nchar(12),
	NgayDat date
)
CREATE TABLE THANHTOAN(
	MaTT nchar(12) PRIMARY KEY,
	PhuongThucTT nvarchar(50)
)

CREATE TABLE DMSANPHAM(
	MaDM nchar(12) PRIMARY KEY,
	TenDanhMuc nvarchar(50),
	MoTa nvarchar(50)
)

TRUNCATE TABLE KHACHHANG
INSERT INTO KHACHHANG VALUES 
('KH001', 'Tran Van An', 'antv@gmail.com', '0905123564', 'Lang Son'),
('KH002', 'Phan Phuoc', 'phuocp@gmail.com', '0932568984', 'Da Nang'),
('KH003', 'AnhTr', 'anhth@gmail.com', '0901865232', 'Da Nang'),
('KH004', 'Alex', 'alex@gmail.com', '0971865232', 'Da Nang'),
('KH005', 'Trump', 'trump@gmail.com', '0901863232', 'Da Nang'),
('KH006', 'Yet', 'yet@gmail.com', '0901846232', 'Da Nang'),
('KH007', 'Not', 'not@gmail.com', '0901444232', 'Ha Noi'),
('KH008', 'NHAT', 'nhat@gmail.com', '0902244232', 'Da Nang')
SELECT * FROM KHACHHANG


TRUNCATE TABLE DMSANPHAM
INSERT INTO DMSANPHAM VALUES 
('DM01', 'Thoi Trang Nu', 'vay, ao danh cho nu'),
('DM02', 'Thoi Trang Nam', 'quan danh cho nam'),
('DM03', 'Trang suc', 'danh cho nu va nam')
SELECT * FROM DMSANPHAM


TRUNCATE TABLE SANPHAM
INSERT INTO SANPHAM VALUES 
('SP001', 'DM01', 'Dam Maxi', 200, 195000, 'VN'),
('SP002', 'DM01', 'Tui Da My', 50, 3000000, 'HK'),
('SP003', 'DM02', 'Lac tay Uc', 300, 300000, 'HQ')
SELECT * FROM SANPHAM


TRUNCATE TABLE THANHTOAN
INSERT INTO THANHTOAN VALUES
('TT01', 'Visa'),
('TT02', 'Master Card'),
('TT03', 'JCB')
SELECT * FROM THANHTOAN


TRUNCATE TABLE DONHANG
INSERT INTO DONHANG VALUES
('DH001', 'KH001', 'TT01', '2014/10/20'),
('DH002', 'KH002', 'TT02', '2015/5/15'),
('DH003', 'KH002', 'TT02', '2015/5/15'),
('DH004', 'KH002', 'TT01', '2015/5/15'),
('DH005', 'KH002', 'TT03', '2015/5/15'),
('DH006', 'KH002', 'TT03', '2015/5/15'),
('DH007', 'KH003', 'TT01', '2015/4/20'),
('DH008', 'KH004', 'TT01', '2015/4/20'),
('DH009', 'KH005', 'TT01', '2015/4/20'),
('DH010', 'KH004', 'TT03', '2015/4/20'),
('DH011', 'KH001', 'TT02', '2015/4/20'),
('DH012', 'KH008', 'TT03', '2015/4/20')
SELECT * FROM DONHANG


TRUNCATE TABLE CHITIETDONHANG
INSERT INTO CHITIETDONHANG VALUES
('DH001', 'SP002', 3, 56000),
('DH002', 'SP001', 10, 27444),
('DH003', 'SP001', 12, 68144),
('DH004', 'SP003', 14, 69144),
('DH005', 'SP002', 16, 62144),
('DH006', 'SP002', 18, 65144),
('DH007', 'SP002', 18, 65144),
('DH012', 'SP003', 23, 500000)
SELECT * FROM CHITIETDONHANG


-- Câu 1: Liệt kê thông tin toàn bộ Sản phẩm.
SELECT * FROM SANPHAM

-- Câu 2: Xóa toàn bộ khách hàng có DiaChi là 'Lang Son'.
SELECT * FROM KHACHHANG
DELETE FROM KHACHHANG WHERE DiaChi = 'Lang Son'
SELECT * FROM KHACHHANG

-- Câu 3: Cập nhật giá trị của trường XuatXu trong bảng SanPham thành 'Viet Nam' đối với trường XuatXu có giá trị là 'VN'.
SELECT * FROM SANPHAM
UPDATE SANPHAM
SET XuatXu = 'Viet Nam'
WHERE MaSP = 'SP001'
SELECT * FROM SANPHAM

-- Câu 4: Liệt kê thông tin những sản phẩm có SoLuong lớn hơn 50 thuộc danh mục là 'Thoi trang nu' 
-- và những Sản phẩm có SoLuong lớn hơn 100 thuộc danh mục là 'Thoi trang nam'.

SELECT S.MaSP, S.MaDM, S.TenSP, S.SoLuong, S.GiaTien, S.XuatXu, DM.TenDanhMuc FROM SANPHAM AS S 
INNER JOIN DMSANPHAM AS DM
ON S.MaDM = DM.MaDM
WHERE S.SoLuong > 50 AND DM.TenDanhMuc = 'Thoi trang nu'
OR
S.SoLuong > 100 AND DM.TenDanhMuc = 'Thoi trang nam'

-- Câu 5: Liệt kê những khách hàng có tên bắt đầu là ký tự 'A' và có độ dài là 5 ký tự.
SELECT * FROM KHACHHANG WHERE TenKH LIKE '% A%' AND LEN(TenKH) = 5

-- Câu 6: Liệt kê toàn bộ Sản phẩm, sắp xếp giảm dần theo TenSP và tăng dần theo SoLuong.
SELECT * FROM SANPHAM ORDER BY TenSP DESC, SoLuong ASC

-- Người mua nhiều đơn hang nhất
SELECT TOP 1 KH.MaKH, COUNT(DH.MaDH) AS Total
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON KH.MaKH = DH.MaKH
GROUP BY KH.MaKH
ORDER BY COUNT(DH.MaDH) DESC

-- Người mua nhiều tiền nhất trong tháng 10/2022
SELECT TOP 1 KH.MaKH, SUM(CTDH.TongTien)
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
JOIN CHITIETDONHANG AS CTDH
ON CTDH.MaDH = DH.MaDH
GROUP BY KH.MaKH
ORDER BY SUM(CTDH.TongTien) DESC


-- Câu 7: Đếm các sản phẩm tương ứng theo từng khách hàng đã đặt hàng,
-- chỉ đếm những Sản phẩm được khách hang đặt hàng trên 4 sản phẩm.
SELECT KH.MaKH, COUNT(CTDH.MaSP) AS Quantity
FROM KHACHHANG AS KH
LEFT JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
LEFT JOIN CHITIETDONHANG AS CTDH
ON CTDH.MaDH = DH.MaDH
GROUP BY KH.MaKH
HAVING COUNT(CTDH.MaSP) > 4

-- Câu 8: Liệt kê tên của toàn bộ khách hàng (tên nào giống nhau thì chỉ liệt kê một lần).
SELECT DISTINCT KH.TenKH
FROM KHACHHANG AS KH

--Câu 9: Liệt kê MaKH, TenKH, TenSP, SoLuong, NgayDat, GiaTien,TongTien (của tất cả các lần đặt hàng của khách hàng).
SELECT KH.MaKH, KH.TenKH, SP.TenSP, CTDH.SoLuong, DH.NgayDat, SP.GiaTien, (CTDH.SoLuong * SP.GiaTien) AS TongTien
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
JOIN CHITIETDONHANG AS CTDH
ON CTDH.MaDH = DH.MaDH
JOIN SANPHAM AS SP
ON SP.MaSP = CTDH.MaSP

-- Câu 10: Liệt kê MaKH, TenKH, MaDH, TenSP, SoLuong, TongTien của tất cả các lần đặt hàng của khách hàng.
-- (những khách hàng chưa đặt hàng lần nào thì vẫn phải liệt kê khách hàng đó ra).
SELECT KH.MaKH, KH.TenKH, DH.MaDH, SP.TenSP, CTDH.SoLuong, (CTDH.SoLuong * SP.GiaTien) AS TongTien
FROM KHACHHANG AS KH
FULL JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
FULL JOIN CHITIETDONHANG AS CTDH
ON CTDH.MaDH = DH.MaDH
FULL JOIN SANPHAM AS SP
ON SP.MaSP = CTDH.MaSP

-- Câu 11: Liệt kê MaKH, TenKH của những khách hàng đã từng đặt hàng với thực hiện thanh toán qua 'Visa'
-- hoặc đã thực hiện thanh toán qua 'JCB'.
SELECT KH.MaKH, KH.TenKH
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
JOIN THANHTOAN AS TT
ON TT.MaTT = DH.MaTT
WHERE TT.PhuongThucTT IN ('Visa','JCB')

-- Câu 12: Liệt kê MaKH, TenKH của những khách hàng chưa từng mua bất kỳ sản phẩm nào.
SELECT KH.MaKH, KH.TenKH, DH.MaDH
FROM KHACHHANG AS KH
FULL JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
WHERE DH.MaKH IS NULL

-- Câu 13: Liệt kê MaKH, TenKH, TenSP, SoLuong, GiaTien, PhuongThuc TT, NgayDat, Tong Tien của những Khách hàng có địa chỉ 
-- là 'Da Nang' và mới thực hiện đặt hàng một lần duy nhất. Kết quả liệt kê được sắp xếp tăng dần của trường TenKH.
SELECT KH.MaKH, KH.TenKH, SP.TenSP, CTDH.SoLuong, SP.GiaTien, TT.PhuongThucTT, DH.NgayDat, CTDH.TongTien
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
JOIN CHITIETDONHANG AS CTDH
ON CTDH.MaDH = DH.MaDH
JOIN THANHTOAN AS TT
ON TT.MaTT = DH.MaTT
JOIN SANPHAM AS SP
ON SP.MaSP = CTDH.MaSP
WHERE KH.DiaChi = 'Da Nang'
AND KH.MaKH IN
(
SELECT KH.MaKH
FROM KHACHHANG AS KH
JOIN DONHANG AS DH
ON DH.MaKH = KH.MaKH
GROUP BY KH.MaKH
HAVING COUNT(KH.MaKH) = 1
)
ORDER BY KH.TenKH


-- WHERE CustomerName LIKE 'a_%'	Finds any values that start with "a" and are at least 2 characters in length

UPDATE CHITIETDONHANG
SET TongTien = TongTien * 10

CREATE TABLE Persons (
    ID int NOT NULL IDENTITY(1,1),
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) DEFAULT 'Sandnes',
    Age int UNIQUE,
    CHECK (Age>=18)
)


-- VIEW

--CREATE VIEW view_name AS
--SELECT column1, column2, ...
--FROM table_name
--WHERE condition

-- EXISTS

--SELECT column_name(s)
--FROM table_name
--WHERE EXISTS
--(SELECT column_name FROM table_name WHERE condition);

