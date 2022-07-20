
CREATE DATABASE FINAL_EXAM

USE FINAL_EXAM

CREATE TABLE NANNHAN(
MaNanNhan nchar(12) PRIMARY KEY,
TenNanNhan nvarchar(50),
SoCMMD nchar(12),
GioiTinh bit,
NgaySinh date,
DiaChi nvarchar(50),
SoDienThoai nchar(12)
)

CREATE TABLE CONBAO(
MaConBao nchar(12) PRIMARY KEY,
TenConBao nvarchar(50),
NgayDoBo date
)

CREATE TABLE LOAICUUTRO(
MaLoaiCuuTro nchar(12) PRIMARY KEY,
TenLoaiCuuTro nvarchar(50)
)

CREATE TABLE DONVICUUTRO(
MaDonVi nchar(12) PRIMARY KEY,
TenDonVi nvarchar(50),
TenNguoiDaiDien nvarchar(50),
DiaChi nvarchar(50),
SoDienThoai nchar(12)
)

CREATE TABLE THIETHAI(
MaThietHai nchar(12) PRIMARY KEY,
MaNanNhan nchar(12) /*FOREIGN KEY REFERENCES NANNHAN(MaNanNhan)*/,
MaConBao nchar(12) /*FOREIGN KEY REFERENCES CONBAO(MaConBao)*/,
ThongTinThietHai nvarchar(50),
SoTienUocTinh int
)

CREATE TABLE THONGTINCUUTRO(
MaCuuTro nchar(12) PRIMARY KEY,
MaThietHai nchar(12) /*FOREIGN KEY REFERENCES THIETHAI(MaThietHai)*/,
MaDonVi nchar(12) /*FOREIGN KEY REFERENCES DONVICUUTRO(MaDonVi)*/,
MaLoaiCuuTro nchar(12) /*FOREIGN KEY REFERENCES LOAICUUTRO(MaLoaiCuuTro)*/,
ChiTietCuuTro nvarchar(50),
SoTienUocTinh int,
NgayCuuTro date
)


INSERT INTO NANNHAN VALUES
('NN001', 'nguyen van A', '3452355321', 1, '4/6/1988', 'hoa xuan', '0945246234'),
('NN002', 'nguyen van B', '3452455321', 0, '5/6/2000', 'hoa xuan', '0945246235'),
('NN003', 'nguyen van C', '3452555321', 1, '6/6/2000', 'ha noi', '0945246236'),
('NN004', 'nguyen van D', '3452655321', 0, '7/6/2000', 'hai phong', '0945246237'),
('NN005', 'nguyen van E', '3452755321', 1, '8/6/1990', 'hoa xuan', '0945246238'),
('NN006', 'nguyen van F', '3452755321', 1, '8/6/1960', 'hoa xuan', '0945241238')
SELECT * FROM NANNHAN


INSERT INTO CONBAO VALUES
('CB001', 'aaa', '6/6/1998'),
('CB002', 'Xangsane', '7/6/2014'),
('CB003', 'ccc', '8/6/2007'),
('CB004', 'Xangsane', '8/6/2007'),
('CB005', 'Xangsane', '8/6/2007')
SELECT * FROM CONBAO


INSERT INTO LOAICUUTRO VALUES
('LCT001', 'quan ao'),
('LCT002', 'luong thuc'),
('LCT003', 'ung ho tien'),
('LCT004', 'Cuu tro luong thuc')
SELECT * FROM LOAICUUTRO


INSERT INTO DONVICUUTRO VALUES
('DV001', 'aaa', 'nguyen A', 'da nang', '0453456232'),
('DV002', 'bbb', 'nguyen B', 'ha noi', '0453456233'),
('DV003', 'ccc', 'nguyen C', 'da nang', '0453456234')
SELECT * FROM DONVICUUTRO


INSERT INTO THIETHAI VALUES
('TH001', 'NN001', 'CB001', 'toc mai', 6000000),
('TH002', 'NN001', 'CB002', 'nha dot', 5000000),
('TH003', 'NN001', 'CB003', 'toc mai', 4000000),
('TH004', 'NN002', 'CB004', 'sat lo', 7000000),
('TH005', 'NN005', 'CB005', 'toc mai', 8000000)
SELECT * FROM THIETHAI


INSERT INTO THONGTINCUUTRO VALUES
('CT001', 'TH001', 'DV001', 'LCT001', 'quan ao', 200000, '6/6/1994'),
('CT002', 'TH002', 'DV002', 'LCT001', 'mi tom', 300000, '7/26/1994'),
('CT003', 'TH003', 'DV003', 'LCT003', 'do an', 400000, '6/8/1994'),
('CT004', 'TH004', 'DV002', 'LCT002', 'sua bo', 600000, '6/9/1994'),
('CT005', 'TH004', 'DV002', 'LCT004', 'sua bo', 600000, '10/10/2019'),
('CT006', 'TH004', 'DV002', 'LCT004', 'sua bo', 600000, '10/10/2008'),
('CT007', 'TH004', 'DV002', 'LCT004', 'sua bo', 800000, '10/10/2008'),
('CT008', 'TH004', 'DV001', 'LCT004', 'sua bo', 600000, '10/10/2008'),
('CT009', 'TH001', 'DV003', 'LCT004', 'sua bo', 600000, '10/10/2008'),
('CT010', 'TH005', 'DV003', 'LCT004', 'sua bo', 600000, '10/10/2008')
SELECT * FROM THONGTINCUUTRO

TRUNCATE TABLE THONGTINCUUTRO
TRUNCATE TABLE THIETHAI
TRUNCATE TABLE DONVICUUTRO
TRUNCATE TABLE LOAICUUTRO
TRUNCATE TABLE CONBAO
TRUNCATE TABLE NANNHAN


-- Câu 3: Liệt kê các nạn nhân là nam có địa chỉ ở phường Hòa Xuân và lớn hơn 50 tuổi.
SELECT * FROM NANNHAN WHERE GioiTinh = 1 AND DiaChi = 'hoa xuan' AND  YEAR(GETDATE()) - YEAR(NgaySinh) > 50

-- Câu 4: Liệt kê các cơn bão đã từng đổ bộ từ năm 2006 đến năm 2015.
SELECT * FROM CONBAO WHERE NgayDoBo BETWEEN '2006-01-01' AND '2015-01-01'

-- Câu 5: Liệt kê thông tin các nạn nhân đã từng bị thiết hại do cơn bão Xangsane đổ bộ. 
-- Kết quả sắp xếp tăng dần theo số CMND.
SELECT NN.*, CB.TenConBao FROM NANNHAN AS NN
INNER JOIN THIETHAI AS TH ON NN.MaNanNhan = TH.MaNanNhan
INNER JOIN CONBAO AS CB ON TH.MaConBao = CB.MaConBao
WHERE CB.TenConBao = 'Xangsane'
ORDER BY NN.SoCMMD ASC

-- Câu 6: Liệt kê thông tin các nạn nhân ở độ tuổi trung niên (30 tuổi - 50 tuổi), đã từng bị 2 lần 
-- thiệt hại do bão, sắp xếp giảm dần theo ngày sinh. Những tên nạn nhân nào giống nhau chỉ liệt kê 1 lần.
SELECT NN.MaNanNhan, NN.TenNanNhan, NN.SoCMMD
FROM NANNHAN AS NN
INNER JOIN THIETHAI AS TH 
ON NN.MaNanNhan = TH.MaNanNhan
WHERE DATEDIFF(YEAR, NN.NgaySinh, GETDATE()) BETWEEN 30 AND 50
GROUP BY NN.MaNanNhan, NN.TenNanNhan, NN.SoCMMD
HAVING COUNT(TH.MaNanNhan) >= 2

-- Câu 7: Liệt kê loại cứu trợ đang được các đơn vị cứu trợ sử dụng nhiều nhất. 
SELECT LCT.MaLoaiCuuTro, LCT.TenLoaiCuuTro, COUNT(LCT.MaLoaiCuuTro) AS Quantity 
FROM LOAICUUTRO AS LCT
INNER JOIN THONGTINCUUTRO AS TTCT 
ON TTCT.MaLoaiCuuTro = LCT.MaLoaiCuuTro
GROUP BY LCT.MaLoaiCuuTro, LCT.TenLoaiCuuTro
HAVING COUNT(LCT.MaLoaiCuuTro) = (

SELECT TOP 1 COUNT(LCT.MaLoaiCuuTro)
FROM LOAICUUTRO AS LCT
INNER JOIN THONGTINCUUTRO AS TTCT 
ON TTCT.MaLoaiCuuTro = LCT.MaLoaiCuuTro
GROUP BY LCT.MaLoaiCuuTro
ORDER BY COUNT(LCT.MaLoaiCuuTro) DESC
)

-- Câu 8: Liệt kê MaNanNhan, TenNanNhan, SoTienUocTinh của các nạn nhân đã từng bị thiệt hại 
-- trong cơn bão với số tiền ước tính từ 5 triệu đồng trở lên.
SELECT NN.MaNanNhan, NN.TenNanNhan, SUM(TTCT.SoTienUocTinh) AS Total
FROM NANNHAN AS NN
INNER JOIN THIETHAI AS TH
ON TH.MaNanNhan = NN.MaNanNhan
INNER JOIN THONGTINCUUTRO AS TTCT
ON TTCT.MaThietHai = TH.MaThietHai
GROUP BY NN.MaNanNhan, NN.TenNanNhan
HAVING SUM(TTCT.SoTienUocTinh) > 700000

-- Câu 9: Liệt kê MaDonVi, TenDonVi, TenNguoiDaiDien, DiaChi, SoDienThoai những đơn vị cứu 
-- trợ đã từng cứu trợ lương thực với số tiền ước tính 5 triệu đồng trở lên nhưng chưa từng cứu trợ
-- bằng hình thức ủng hộ tiền.
SELECT DVCT.*, LCT.TenLoaiCuuTro, TTCT.SoTienUocTinh
FROM DONVICUUTRO AS DVCT
FULL JOIN THONGTINCUUTRO AS TTCT
ON TTCT.MaDonVi = DVCT.MaDonVi
FULL JOIN LOAICUUTRO AS LCT
ON LCT.MaLoaiCuuTro = TTCT.MaLoaiCuuTro
WHERE LCT.TenLoaiCuuTro = 'luong thuc' AND LCT.TenLoaiCuuTro <> 'ung ho tien'
AND TTCT.SoTienUocTinh > 350000

-- Câu 10: Cập nhật MaLoaiCuuTro từ “Cuu tro luong thuc” sang “Ung ho tien” đối với các Thông 
-- tin cứu trợ (THONGTINCUUTRO) diễn ra trong tháng 10/2019 và số tiền ước tính nhỏ hơn 1 triệu đồng.
UPDATE LCT
SET TenLoaiCuuTro = 'Ung ho tien nhe'
FROM LOAICUUTRO AS LCT
INNER JOIN THONGTINCUUTRO AS TTCT
ON TTCT.MaLoaiCuuTro = LCT.MaLoaiCuuTro
WHERE TTCT.NgayCuuTro BETWEEN '2019-10-1' AND '2019-10-31'
AND TTCT.SoTienUocTinh < 700000
SELECT * FROM LOAICUUTRO

-- Câu 11: Liệt kê 3 đơn vị cứu trợ có số tiền ước tính cứu trợ nhiều nhất trong năm 2008.
SELECT TOP 3 DVCT.MaDonVi, SUM(TTCT.SoTienUocTinh) AS Amount
FROM DONVICUUTRO AS DVCT
JOIN THONGTINCUUTRO AS TTCT
ON TTCT.MaDonVi = DVCT.MaDonVi
WHERE TTCT.NgayCuuTro BETWEEN '2008-01-01' AND '2008-12-31'
GROUP BY DVCT.MaDonVi
ORDER BY SUM(TTCT.SoTienUocTinh) DESC

-- Câu 12: Liệt kê MaNanNhan, TenNhanNhan, SoCMND, SoLanThietHai, SoDonViCuuTro của 
-- các nạn nhân đã từng thiệt hại ít nhất 2 lần do bão đổ bộ và có nhiều hơn 2 đơn vị khác nhau cứu trợ.
SELECT 
NN.MaNanNhan, NN.TenNanNhan, NN.SoCMMD, COUNT(TH.MaNanNhan) AS SoLanThietHai, COUNT(TTCT.MaDonVi) AS SoDonViCuuTro
FROM NANNHAN AS NN
JOIN THIETHAI AS TH
ON TH.MaNanNhan = NN.MaNanNhan
JOIN THONGTINCUUTRO AS TTCT
ON TTCT.MaThietHai = TH.MaThietHai
GROUP BY NN.MaNanNhan, NN.TenNanNhan, NN.SoCMMD
HAVING COUNT(TH.MaNanNhan) >= 2 AND COUNT(DISTINCT TTCT.MaDonVi) > 2

-- Format date
SELECT FORMAT (getdate(), 'yyyy-dd-MM') as date
SELECT FORMAT (NANNHAN.NgaySinh, 'yyyy-dd-MM') as date FROM NANNHAN

-- Convert gender(bit)
SELECT NANNHAN.TenNanNhan + ' VNĐ',
CASE WHEN NANNHAN.GioiTinh = 1 THEN 'Male'
WHEN NANNHAN.GioiTinh = 0 THEN 'Female'
ELSE 'Else'
END AS Gender
FROM NANNHAN

-- ANY
--SELECT column_name(s)
--FROM table_name
--WHERE column_name operator ANY
--  (SELECT column_name
--  FROM table_name
--  WHERE condition)

--ALL
--SELECT column_name(s)
--FROM table_name
--WHERE column_name operator ALL
--  (SELECT column_name
--  FROM table_name
--  WHERE condition)

SELECT NN.MaNanNhan, NN.TenNanNhan,NN.SoCMMD,
'GioiTinh' = CASE
WHEN NN.GioiTinh = 1 THEN 'Male'
ELSE 'Female' END, NN.NgaySinh
FROM NANNHAN AS NN

-- UPDATE USING CASE WHEN
UPDATE NANNHAN  
SET DiaChi =   
( 
CASE  
	WHEN (DiaChi = '') THEN 'some'
	WHEN (DiaChi = 'some') THEN DiaChi + 'DiaChi'
	ELSE '' 
END  
)

--SELECT City, Country FROM Customers
--WHERE Country='Germany'
--UNION ALL
--SELECT City, Country FROM Suppliers
--WHERE Country='Germany'
--ORDER BY City

--City	       Country

--Aachen	   Germany
--Berlin	   Germany
--Berlin	   Germany
--Brandenburg  Germany