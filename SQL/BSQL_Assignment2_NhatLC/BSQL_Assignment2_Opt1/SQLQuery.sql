CREATE DATABASE Trainee
USE Trainee
CREATE TABLE Trainee(
	TraineeID		int IDENTITY(1, 1) PRIMARY KEY,
	Full_Name		nvarchar(50),
	Birth_Date		date,
	Gender			bit,
	ET_IQ			int,
	ET_Gmath		int,
	ET_English		int,
	Training_Class		char(10),
	Evaluation_Notes	nvarchar(500)
)
GO

ALTER TABLE Trainee
ADD CONSTRAINT Check_ET_IQ CHECK (ET_IQ >= 0 AND ET_IQ <= 20)
GO

ALTER TABLE Trainee
ADD CONSTRAINT Check_ET_Gmath CHECK (ET_Gmath >= 0 AND ET_Gmath <= 20)
GO

ALTER TABLE Trainee
ADD CONSTRAINT Check_ET_English CHECK (ET_English >= 0 AND ET_English <= 50)
GO

ALTER TABLE Trainee
ADD Fsoft_Account char(20) NOT NULL

INSERT INTO Trainee
VALUES ('Nguyen van A', '2/4/2000', 1, 20, 20, 20, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ( 'Nguyen van B', '1/1/2000', 0, 19, 15, 44, 'Fresher-14', 'close', 'Hard-working')
GO

INSERT INTO Trainee
VALUES ('Nguyen van C', '9/4/1990', 1, 5, 10, 21, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van D', '9/11/1983', 0, 10, 10, 20, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van E', '2/25/1999', 0, 12, 14, 40, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van F', '11/22/2000', 1, 2, 10, 20, 'Fresher-14', 'Naughty', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van G', '12/31/2000', 1, 20, 19, 49, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van H', '1/30/2000', 1, 16, 15, 40, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van I', '5/3/2000', 1, 15, 10, 30, 'Fresher-14', 'close', 'excellent')
GO

INSERT INTO Trainee
VALUES ('Nguyen van K', '1/30/2000', 1, 20, 18, 41, 'Fresher-14', 'close', 'excellent')
GO

TRUNCATE TABLE Trainee
go



CREATE VIEW ET_Passed_Trainees1 AS
	SELECT TraineeID, Full_Name, Birth_Date, Gender
	FROM Trainee
	WHERE ET_IQ + ET_Gmath >= 20 AND ET_IQ >= 8 AND ET_Gmath >= 8 AND ET_English >= 18
GO
	
--Query all the trainees who is passed the entry test,
--group them into different birth months.

SELECT	TraineeID,
	Full_Name,
	Birth_Date
FROM	Trainee
WHERE	ET_IQ + ET_Gmath >= 20
	AND ET_IQ >= 8
	AND ET_Gmath >= 8
	AND ET_English >= 18
ORDER BY MONTH(Birth_Date)


--Query the trainee who has the longest name,
--showing his/her age along with his/her basic information

SELECT	TraineeID,
	Full_Name,
	Birth_Date,
	YEAR(GETDATE()) - YEAR(Birth_Date) AS AGE,
	Gender
FROM	Trainee
WHERE	LEN(Full_Name) = (SELECT MAX(LEN(Full_Name)) FROM Trainee)
