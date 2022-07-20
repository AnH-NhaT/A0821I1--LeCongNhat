--Q1--
--Create EMPLOYEE table with the most appropriate/economic field/column constraints & types. All fields are mandatory except Note field. 
--Create SKILL table with the most appropriate/economic field/column constraints & types, all fields are mandatory except Note field.
--Create DEPARTMENT table with the most appropriate/economic field/column constraints & types, all fields are mandatory except Note field.
--Create EMP_SKILL table with the most appropriate/economic field/column constraints & types, all fields are mandatory except Description field.

CREATE TABLE EMPLOYEE(
	EmpNo int not null PRIMARY KEY,
	EmpName nvarchar(50),
	BirthDay DATE,
	DeptNo varchar(50),
	MgrNo varchar(50) not null,
	StartDate Date,
	Salary money,
	Levell tinyint,
	Statuss tinyint,
	Note nvarchar(255)
)
ALTER TABLE EMPLOYEE
ALTER COLUMN DeptNo int

CREATE TABLE EMP_SKILL(
	SkillNo int not null  FOREIGN KEY REFERENCES SKILL(SkillNo),
	EmpNo int not null FOREIGN KEY REFERENCES EMPLOYEE(EmpNo),
	SkillName nvarchar(50),
	SkillLevel tinyint,
	RegDate Date,
	Descriptions  nvarchar(255)
)
GO

ALTER TABLE EMP_SKILL
ADD CONSTRAINT [PK_EMP_SKILL] PRIMARY KEY CLUSTERED (SkillNo, EmpNo)

CREATE TABLE SKILL(
	SkillNo int not null PRIMARY KEY,
	SkillName nvarchar(50),
	Note nvarchar(255)
)
--IDENTITY(1,1) thay cho AUTO_INCREMENT trong sql -> Tự động tăng--
CREATE TABLE DEPARTMENT(
	DeptNo int not null  IDENTITY(1,1) PRIMARY KEY,
	DeptName nvarchar(50),
	Note nvarchar(255)
)
--Q2--
--Add an Email field to EMPLOYEE table and make sure that the database will not allow the value for Email to be inserted into a new row if that value has already been used in another row.
--Modify EMPLOYEE table to set default values to 0 of MgrNo and Status fields.

ALTER TABLE EMPLOYEE 
ADD  Email varchar(50)

ALTER TABLE EMPLOYEE
ADD CONSTRAINT df_MgrNo
DEFAULT 0 FOR MgrNo;

ALTER TABLE EMPLOYEE
ADD CONSTRAINT df_Statuss
DEFAULT 0 FOR Statuss;

--Q3--
--Add the FOREIGN KEY constrain of DeptNo field to the EMPLOYEE table that will relate the DEPARTMENT table.
--Remove the Description field from the EMP_SKILL table.

ALTER TABLE EMPLOYEE 
ADD FOREIGN KEY (DeptNo) REFERENCES DEPARTMENT(DeptNo)

ALTER TABLE EMP_SKILL
DROP COLUMN Descriptions;

--Q4--
--Add at least 5 records into each the created tables.
--Create a VIEW called EMPLOYEE_TRACKING that will appear to the user as EmpNo, Emp_Name and Level. It has Level satisfied the criteria: Level >=3 and Level <= 5.

INSERT INTO EMPLOYEE(EmpNo,EmpName,BirthDay,DeptNo,MgrNo,StartDate,Salary,Levell,Statuss,Note)
VALUES (1,'Nguyen Van A','2000-05-7',1,1,'2022-07-13',20000000,1,0,'Khong'),
		(2,'Nguyen Van B','2000-05-8',2,2,'2022-07-13',21000000,2,0,'Khong'),
		(3,'Nguyen Van C','2000-05-9',3,3,'2022-07-13',22000000,3,0,'Khong'),
		(4,'Nguyen Van D','2000-05-3',4,4,'2022-07-13',23000000,4,0,'Khong'),
		(5,'Nguyen Van E','2000-05-18',5,5,'2022-07-13',24000000,5,0,'Khong')


CREATE VIEW EMPLOYEE_TRACKING AS
SELECT EmpNo,EmpName,Levell FROM EMPLOYEE 
WHERE Levell>=3 AND Levell<=5