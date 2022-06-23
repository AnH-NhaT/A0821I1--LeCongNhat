create database quanlydonhang;
use quanlydonhang;
create table PHIEUXUAT(
SoPX int auto_increment primary key,
NgayXuat date
);
create table VATTU(
MaVTU int auto_increment primary key,
TenVTU varchar(20)
);
create table PHIEUNHAP(
SoPN int auto_increment primary key,
NgayNhap date 
);
create table SDT(
ID int auto_increment primary key,
SDT int
);
create table NHACC(
MaNCC int auto_increment primary key,
TenNCC varchar(20),
DiaChi varchar(20),
SDT_ID int,
foreign key (SDT_ID) references SDT(ID)
);
create table DONDH(
SoDH int auto_increment primary key,
NgayDH date,
MaNCC int,
foreign key (MaNCC) references NHACC(MaNCC)
);
create table PHIEUXUAT_VATTU(
SoPX int,
MaVTU int,
DGXuat int,
SLXuat int,
primary key(SoPX,MaVTU),
foreign key(SoPX) references PHIEUXUAT(SoPX),
foreign key(MaVTU) references VATTU(MaVTU)
);
create table VATTU_PHIEUNHAP(
MaVTU int,
SoPN int,
DGNhap int,
SLNhap int,
primary key(MaVTU, SoPN),
foreign key(MaVTU) references VATTU(MaVTU),
foreign key(SoPN) references PHIEUNHAP(SoPN)
);
create table VATTU_DONDH(
MaVTU int,
SoDH int,
primary key(MaVTU, SoDH),
foreign key(MaVTU) references VATTU(MaVTU),
foreign key(SoDH) references DONDH(SoDH)
);
