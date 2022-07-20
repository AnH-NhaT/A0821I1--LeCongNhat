create database finaltest2;
use finaltest2;

create table PhongBan(
	MaPB varchar(5) primary key not null,
    TenPB varchar(50) not null
);
create table LoaiSuCo(
	MaLSC varchar(5) not null primary key,
    TenLSC varchar(50)
);
create table NhanVien(
	MaNV varchar(5) not null primary key,
    HoTen varchar(50),
    CDCC int(9),
    GioiTinh varchar(4),
    NgaySinh date,
    DiaChi varchar(50),
    SDT varchar(10),
    NgayVaoCongty date
);

create table DuAn(
	MaDA varchar(5) not null primary key,
    TenDA varchar(5) not null,
    NgayBD date,
    NgayKT date,
    SoLuognNV int(5),
    DiaDiem varchar(50),
    MaPB varchar(5),
    foreign key(MaPB) references PhongBan(MaPB)
);
create table SuCo(
	MaSC varchar(5) not null primary key,
    MaLSC varchar(5) not null,
    MaNV varchar(5) not null,
    MaDA varchar(5) not null,
    NgaySC date,
    ThietHai int(20),
    TrangThai varchar(30),
    foreign key (MaLSC) references LoaiSuCo(MaLSC) on update cascade,
    foreign key(MaNV) references NhanVien(MaNV),
    foreign key(MaDA) references DuAn(MaDA)
);

insert into LoaiSuCo(MaLSC,TenLSC) values('LSC01','Mat Tai San'),
('LSC02','Chia Se Thong tin'),
('LSC03','Truy cap trai phep');

insert into PhongBan(MaPB,TenPB) values('PB001','R&D'),
('PB002','Phat Trien'),
('PB003','Thuong Mai Dien Tu');

insert into NhanVien(MaNV,Hoten,CDCC,GioiTinh,NgaySinh,DiaChi,SDT,NgayVaoCongTy) values
('NV001','Nguyen Van A',123456789,'Nam','1997-12-1','Khu A','0123456789','2018-02-02'),
('NV002','Nguyen Van C',123456789,'Nam','1997-12-1','Khu A','0123456788','2019-02-02'),
('NV003','Nguyen Van D',123456789,'Nam','1997-12-1','Khu A','0123456787','2017-02-02'),
('NV004','Nguyen Van E',123456789,'Nu','1997-12-1','Khu A','0123456786','2018-02-02'),
('NV005','Nguyen Van F',123456789,'Nam','1997-12-1','Khu A','0123456785','2019-02-02');

insert into DuAn(MaDA,TenDA,NgayBD,NgayKT,SoLuognNV,DiaDiem,MaPB) values
('DA001','NIC','2021-11-11','2022-03-03',30,'Phong A','PB001'),
('DA002','WAS','2021-11-11','2022-03-03',30,'Phong B','PB002'),
('DA003','SAWA','2021-11-11','2022-03-03',30,'Phong C','PB003'),
('DA004','YKC','2021-11-11','2022-03-03',30,'Phong D','PB001'),
('DA005','INTRA','2021-11-11','2022-03-03',30,'Phong E','PB002'),
('DA006','SEIKI','2021-11-11','2022-03-03',30,'Phong F','PB003');

insert into SuCo(MaSC,MaDA,MaNV,MaLSC,NgaySC,ThietHai,TrangThai) values
('SC005','DA001','NV001','LSC03','2021-05-05',500000,'Dang Su Ly'),
('SC001','DA001','NV001','LSC01','2021-05-05',5000000,'Dang Su Ly'),
('SC002','DA002','NV002','LSC02','2022-05-05',5000000,'Hoan tat'),
('SC003','DA003','NV003','LSC03','2021-05-05',1000000,'Cho Su Ly'),
('SC004','DA004','NV004','LSC01','2022-05-05',3000000,'Dang Su Ly');

-- 3
select * from DuAn
order by NgayBD ASC, NgayKT DESC;

/* Câu 4: Liệt kê thông tin những dự án (MaDA, TenDA, NgayBD, NgayKT) đã từng gây ra các sự
cố bảo mật thông tin. Học viên thực hiện yêu cầu này theo hai cách khác nhau. (1 điểm) */
select sc.MaDA,TenDA,NgayBD,NgayKT from DuAn as da 
INNER JOIN SuCo as sc on da.MaDA = sc.MaDA;

SELECT d.MaDA, d.TenDA, d.NgayBD, d.NgayKT 
FROM DUAN AS d 
WHERE d.MaDA IN (SELECT SUCO.MaDA FROM SUCO);

/* Câu 5: Liệt kê thông tin MaNV, HoTen, DiaChi, SoDienThoai, NgayVaoCongTy của những nhân 
viên gây ra nhiều sự cố bảo mật thông tin nhất trong năm 2021. (0.5 điểm) */
select sc.MaNV, Hoten, DiaChi,SDT, NgayVaoCongTy, Count(distinct sc.MaSC) as solansuco from nhanvien as nv
inner join SuCo as sc on nv.MaNV = sc.MaNV
where sc.NgaySC >= '2021-01-01' AND sc.NgaySC <= '2022-12-31' 
group by sc.MaNV
order by solansuco DESC limit 1;

/* Câu 6: Liệt kê MaDA, TenDA, SoLuongNV, TenPB, Số lần xảy ra các sự cố trong quý 1 (tháng 
1,2,3 năm 2022). (0.5 điểm)
*/
select da.MaDA, TenDA, SoLuognNV, TenPB, Count(sc.MaSC) as SoLanSuCo from SuCo as sc
inner join DuAN as da on sc.MaDA = da.MaDA
inner join PhongBan as pb on da.MaPB = pb.MaPB
where NgaySC <= '2022-03-31' and NgaySC >= '2022-01-01'
group by da.MaDA;

/* Câu 7: Liệt kê MaPB, TenPB, Tổng thiệt hại đã gây ra cho công ty do việc phát sinh các sự cố
bảo mật thông tin đến thời điểm hiện tại. (0.5 điểm) */
select pb.MaPB, TenPB, sum(sc.ThietHai) as tongthiethai from PhongBan as pb
inner join DuAn as da on pb.MaPB =da.MaPB
inner join SuCo as sc on sc.MaDA = da.MaDA
group by pb.MaPB;

/* Câu 8: Liệt kê những nhân viên (MaNV, HoTen) tuy đã từng gây ra ít nhất 2 sự cố bảo mật thông 
tin nhưng tổng thiệt hại nhỏ hơn 5.000.000 VNĐ. (1 điểm) */
select sc.MaNV, Hoten, Count(sc.MaSC) as solansuco , Sum(distinct ThietHai) as tongthiethai from SuCo as sc
inner join NhanVien as nv on sc.MaNV = nv.MaNV
group by sc.MaNV
having solansuco >= 2 and tongthiethai >1000000;

/* Câu 9: Liệt kê MaDA, TenDA, TenPB của những dự án có số lượng nhân viên nhỏ hơn 10 người,
đã từng gây ra sự cố bảo mật thông tin thuộc loại “Mat tai san” nhưng từ 1/2022 đến nay chưa 
để phát sinh sự cố bảo mật thông tin nào. (1 điểm)
*/ 
select sc.MaDA, TenDA, TenPB from DuAn as da 
inner join phongban as pb on da.MaPB = pb.MaPB
inner join SuCo as sc on da.MaDA = sc.MaDA
inner join LoaiSuCo as lsc on lsc.MaLSC = sc.MaLSC
where SoLuognNV < 10 and TenLSC = 'Chia Se Thong Tin' and NgaySC <= '2022-01-01';

/* Câu 10: Cập nhật Trạng thái thành “Hoan tat” cho những sự cố thuộc loại “Chia se thong tin”
phát sinh trong 6 tháng cuối năm 2021. (0.5 điểm) */
UPDATE SuCo as sc 
 inner join LoaiSuCo as lsc on sc.MaLSC = lsc.MaLSC
Set TrangThai = 'Hoan Thanh' where  TenLSC = 'Chia se thong tin' 
-- MaLSC = 'LSC02'
and NgaySC between '2019-01-01' and '2019-01-31';

/* 11 : Liệt kê thông tin các loại sự cố (MaLoaiSC, TenLoaiSC, Thiệt hại trung bình) có số lần 
xảy ra nhiều nhất đến thời điểm hiện tại nhưng tổng thiệt hại gây ra ở tất cả các lần xảy ra sự cố
là ít nhất. (1 điểm)  */

select sc.MaLSC, TenLSC, avg(ThietHai) as THTB, count(maSC) as solan , SUM(sc.ThietHai) as tongth from SuCo as sc 
inner join LoaiSuCo as lsc on sc.MaLSC = lsc.MaLSC
group by sc.maLSC, TenLSC
order by count(maSC) DESC, SUM(sc.ThietHai) ASC limit 1;



