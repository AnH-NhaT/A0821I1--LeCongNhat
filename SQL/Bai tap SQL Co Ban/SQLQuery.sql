CREATE DATABASE QUANLYSANPHAM
USE QUANLYSANPHAM

CREATE TABLE SANPHAM(
MaSP CHAR(7) NOT NULL PRIMARY KEY,
TenSP VARCHAR(255) NOT NULL,
MaLoaiSP CHAR(7) NOT NULL,
GiaBan MONEY
)


CREATE TABLE LOAISP(
MaLoaiSP CHAR(7) NOT NULL PRIMARY KEY,
TenLoaiSP VARCHAR(255) NOT NULL
)

CREATE TABLE NHANVIEN(
MaNV CHAR(4) NOT NULL PRIMARY KEY,
HoTenNV VARCHAR(255) NOT NULL,
GioiTinh TINYINT NOT NULL,
QueQuan VARCHAR(255) NOT NULL,
Tuoi TINYINT NOT NULL
)

CREATE TABLE BANHANG(
MaNV CHAR(4) NOT NULL,
MASP CHAR(7) NOT NULL,
SoLuongDaBan INT
)

INSERT INTO SANPHAM(MaSP,TenSP,MaLoaiSP,GiaBan) VALUES 
('SP01','Iphone','TYPE001',799),
('SP02','Moto','TYPE002',599),
('SP03','Iphone 11','TYPE001',299),
('SP04','Linh Kien','TYPE003',799)

INSERT INTO NHANVIEN(MaNV,HoTenNV,GioiTinh,QueQuan,Tuoi) VALUES 
('NV01','HUY',0,'NA',23),
('NV02','HOANG',0,'KonTum',33),
('NV03','QUY',0,'Da Nang',13),
('NV04','DAI',0,'HN',54)
SELECT * FROM NHANVIEN

INSERT INTO LOAISP(MaLoaiSP,TenLoaiSP) VALUES ('TYPE001','PHONE'),('TYPE002','MOTO'),('TYPE003','LINH KIEN')
INSERT INTO BANHANG(MaNV,MASP,SoLuongDaBan) VALUES ('NV01','SP01',2),('NV02','SP02',1),('NV01','SP03',3)

ALTER TABLE SANPHAM ADD FOREIGN KEY(MaLoaiSP) REFERENCES LOAISP(MaLoaiSP);
ALTER TABLE BANHANG ADD FOREIGN KEY(MaNV) REFERENCES NHANVIEN(MaNV);
ALTER TABLE BANHANG ADD FOREIGN KEY(MASP) REFERENCES SANPHAM(MaSP);


-- 1
INSERT INTO NHANVIEN(MaNV, HoTenNV, GioiTinH, QueQuan, Tuoi) VALUES ('NV05', 'Nguyen chi pheo',0, 'Quang nam', 18)

-- 2
DELETE FROM NHANVIEN WHERE GioiTinh = 0 AND QueQuan = 'Quang nam'

-- 3
UPDATE SANPHAM 
SET GiaBan = GiaBan * 2
WHERE MaLoaiSP = 'TYPE001';

-- 4
SELECT * FROM NHANVIEN;

-- 5
SELECT * FROM NHANVIEN WHERE Tuoi >= 23 AND QueQuan = 'Binh Dinh'

--6
SELECT h.MASP FROM BANHANG h join NHANVIEN n on h.MaNV = n.MaNV join SANPHAM s on s.MaSP = h.MASP

--7
SELECT * FROM NHANVIEN WHERE HoTenNV LIKE 'NGUYEN%'

--8
SELECT * FROM NHANVIEN WHERE HoTenNV LIKE 'HOA%'

--9
SELECT * FROM SANPHAM WHERE LEN(TenSP) = 12

--10
SELECT * FROM SANPHAM s join LOAISP l on l.MaLoaiSP = s.MaLoaiSP WHERE TenLoaiSP = 'MY PHAM'

-- 11
SELECT * FROM SANPHAM
WHERE GiaBan < 200 OR (MaSP NOT IN (SELECT MASP FROM BANHANG))

-- 12 Hãy liệt kê những nhưng viên chưa từng bán được sản phẩm nào và những nhân viên chỉ mới bán được sản phẩm Bột giặt OMO
SELECT NV.MaNV
FROM NHANVIEN AS NV
JOIN BANHANG AS BH
ON BH.MaNV = NV.MaNV
JOIN SANPHAM AS SP
ON SP.MaSP = BH.MASP
JOIN LOAISP AS LSP
ON LSP.MaLoaiSP = SP.MaLoaiSP
GROUP BY NV.MaNV
HAVING COUNT(BH.MaNV) = 0