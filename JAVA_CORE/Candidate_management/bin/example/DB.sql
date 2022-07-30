CREATE DATABASE CANDIDATE

USE CANDIDATE

CREATE TABLE CANDIDATE(
CandidateID varchar(50),
FullName varchar(50),
BirthDay varchar(50),
Phone varchar(50),
Email varchar(50),
Candidate_type int,

ExpInYear int,
ProSkill varchar(50),

Graduation_date varchar(50),
Graduation_rank varchar(50),
Education varchar(50),

Majors varchar(50),
Semester char(1),
University_name varchar(50)
)

TRUNCATE TABLE CANDIDATE
SELECT * FROM CANDIDATE
