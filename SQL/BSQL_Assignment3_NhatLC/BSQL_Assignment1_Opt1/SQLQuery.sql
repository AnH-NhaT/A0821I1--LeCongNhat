-- Create table Employee, Status = 1: are working

USE [Employee Management System]
CREATE TABLE [dbo].[Employee](
	[EmpNo] [int] NOT NULL
,	[EmpName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[BirthDay] [datetime] NOT NULL
,	[DeptNo] [int] NOT NULL
, 	[MgrNo] [nchar](10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[StartDate] [datetime] NOT NULL
,	[Salary] [money] NOT NULL
,	[Status] [int] NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
,	[Level] [int] NOT NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[Emp_Skill](
	[SkillNo] [int] NOT NULL
,	[EmpNo] [int] NOT NULL
,	[SkillLevel] [int] NOT NULL
,	[RegDate] [datetime] NOT NULL
,	[Description] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO

GO

CREATE TABLE [dbo].[Skill](
	[SkillNo] [int] IDENTITY(1,1) NOT NULL
,	[SkillName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Department](
	[DeptNo] [int] IDENTITY(1,1) NOT NULL
,	[DeptName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO

ALTER TABLE Employee 
ADD CONSTRAINT PK_Emp PRIMARY KEY (EmpNo)
GO

ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Level] 
	CHECK  (([Level]=(7) OR [Level]=(6) OR [Level]=(5) OR [Level]=(4) OR [Level]=(3) OR [Level]=(2) OR [Level]=(1)))
GO
ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Status] 
	CHECK  (([Status]=(2) OR [Status]=(1) OR [Status]=(0)))

GO
ALTER TABLE [dbo].[Employee]
ADD Email NCHAR(30) 
GO

ALTER TABLE [dbo].[Employee]
ADD CONSTRAINT chk_Email CHECK (Email IS NOT NULL)
GO

ALTER TABLE [dbo].[Employee] 
ADD CONSTRAINT chk_Email1 UNIQUE(Email)

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_EmpNo DEFAULT 0 FOR EmpNo

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_Status DEFAULT 0 FOR Status

GO

ALTER TABLE Skill
ADD CONSTRAINT PK_Skill PRIMARY KEY (SkillNo)

GO

ALTER TABLE Department
ADD CONSTRAINT PK_Dept PRIMARY KEY (DeptNo)

GO

ALTER TABLE Emp_Skill
ADD CONSTRAINT PK_Emp_Skill PRIMARY KEY (SkillNo, EmpNo)
GO

ALTER TABLE Employee  
ADD  CONSTRAINT [FK_1] FOREIGN KEY([DeptNo])
REFERENCES Department (DeptNo)

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_2] FOREIGN KEY ([EmpNo])
REFERENCES Employee([EmpNo])

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_3] FOREIGN KEY ([SkillNo])
REFERENCES Skill([SkillNo])

GO
--a
INSERT INTO Skill(SkillName)
VALUES ('JAVA')
		,('.NET')
		,('PHP')
		,('C++')
		,('PYTHON')
		,('NODEJS')
		,('SQL_SERVER')
		,('MY_SQL')
GO 

INSERT INTO Department(DeptName,Note)
VALUES ('Phong Ky Su','khong')
		,('Phong Hanh Chinh','Khong')
		,('Phong Ke Toan','Khong')
		,('Phong IT','Khong')
		,('Phong Makerting','Khong')
		,('Phong Bao Ve','Khong')
		,('Phong Truyen Thong','Khong')
		,('Phong Quan Li','Khong')
GO

INSERT INTO Employee(EmpNo,EmpName,BirthDay,DeptNo,MgrNo,StartDate,Salary,Status,Note,Level,Email )
VALUES  (1,'Nguyen Văn A','2000-07-13 19:35:45',1,0,'2022-01-08 08:05:30',1000,1,'Khong',5,'ANV9@gmail.com')
		,(2,'Nguyen Văn B','2000-07-13 18:35:50',6,1,'2022-02-07 09:15:20',1500,1,'Khong',6,'BNV3@gmail.com')
		,(3,'Nguyen Văn C','2000-07-13 11:00:35',7,1,'2022-03-06 07:00:30',2500,1,'Khong',7,'CNV4@gmail.com')
		,(4,'Nguyen Văn D','2000-07-13 14:30:25',8,1,'2022-04-05 06:01:50',1500,0,'Khong',5,'DNV5@gmail.com')
		,(5,'Nguyen Văn E','2000-07-13 21:45:15',5,2,'2022-05-04 05:02:40',2500,1,'Khong',6,'ENV6@gmail.com')
		,(6,'Nguyen Văn F','2000-07-13 15:39:25',4,2,'2022-06-03 06:03:10',3000,0,'Khong',7,'FNV7@gmail.com')
		,(7,'Nguyen Văn G','2000-07-13 13:36:55',3,3,'2022-07-02 07:04:50',1500,0,'Khong',6,'GNV8@gmail.com')
		,(8,'Doan Ngoc Tan','2000-08-13 12:15:45',4,1,'2022-08-01 08:05:30',2500,1,'Khong',7,'TanDn9@gmail.com')
GO

INSERT INTO Emp_Skill(SkillNo,EmpNo,SkillLevel,RegDate,Description)
VALUES   (1,6,5,'2022-08-01 08:03:30','ok')
		,(2,5,5,'2022-07-01 08:04:30','ok')
		,(3,7,5,'2022-06-01 08:05:30','ok yes')
		,(4,3,5,'2022-05-01 08:01:30','ok')
		,(5,2,5,'2022-04-01 08:09:30','ok')
		,(6,8,5,'2022-03-01 08:07:30','ok')
		,(7,1,5,'2022-02-01 08:05:30','ok')
		,(8,4,5,'2022-01-01 08:02:30','ok')
GO

--b
--Ghi rõ tên, email và tên bộ phận của những nhân viên đã làm việc ít nhất sáu tháng.
SELECT  a.EmpName,a.Email,b.DeptName FROM Employee a
INNER JOIN Department b ON a.DeptNo=b.DeptNo
GROUP BY DATEDIFF(MONTH,a.StartDate, GETDATE()), a.EmpName,a.Email,b.DeptName
HAVING  DATEDIFF(MONTH,a.StartDate, GETDATE())>=6


--c Chỉ định tên của những nhân viên điếm có kỹ năng ‘C ++’ hoặc ‘.NET’.
SELECT DISTINCT a.EmpName FROM Employee a
INNER JOIN Emp_Skill b ON a.EmpNo=b.EmpNo
INNER JOIN Skill c ON b.SkillNo=c.SkillNo
WHERE c.SkillName='C++' OR c.SkillName='.NET'


--d Liệt kê tất cả tên nhân viên, tên người quản lý, email người quản lý của những nhân viên đó.
SELECT e1.EmpName as employee_names ,e2.EmpName as manager_names,e2.Email as manager_emails  FROM Employee e1
lEFT JOIN Employee e2 ON e1.MgrNo=e2.EmpNo

--e Chỉ định các phòng ban có> = 2 nhân viên, in ra danh sách nhân viên của các phòng ban ngay sau mỗi phòng ban.
SELECT  b.DeptName ,a.EmpName  FROM  Employee a
INNER JOIN Department b ON a.DeptNo=b.DeptNo 
WHERE a.DeptNo IN(SELECT DeptNo FROM Employee GROUP BY DeptNo HAVING COUNT(1)>1)

 --f Liệt kê tất cả tên, email và số kỹ năng của nhân viên và sắp xếp thứ tự tăng dần theo tên của nhân viên.
SELECT a.EmpName, a.Email, COUNT(b.SkillLevel) AS 'Skill Number'
FROM Employee a INNER JOIN Emp_Skill b ON a.EmpNo = b.EmpNo
GROUP BY a.Email, a.EmpName
ORDER BY a.EmpName

--g Tạo khung nhìn để liệt kê tất cả nhân viên đang làm việc (bao gồm: tên nhân viên và tên kỹ năng, tên bộ phận).
CREATE VIEW EMP_WORKING AS
SELECT a.EmpName,c.SkillName,d.DeptName FROM Employee a
INNER JOIN Emp_Skill b ON a.EmpNo=b.EmpNo
INNER JOIN Skill c ON b.SkillNo=c.SkillNo
INNER JOIN Department d ON a.DeptNo =d.DeptNo