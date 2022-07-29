USE CUSTOMER

DROP TABLE CUSTOMER
CREATE TABLE CUSTOMER(
	[Type] int ,
	CusID varchar(50),
	[Name] varchar(50),
	BirthDate date,
	Sex bit,
	IdentifyID varchar(50),
	VaccineTimes int,
	TravelDate date,
	TicketPrice int,
	Passport varchar(50),
	TravelTimes int,
	[Address] varchar(50),
	Province varchar(50)
	)

TRUNCATE TABLE CUSTOMER
SELECT * FROM CUSTOMER