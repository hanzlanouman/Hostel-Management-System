CREATE TABLE Rooms (
  roomNo NUMBER,
  roomType VARCHAR2(255),
  roomCapacity VARCHAR2(255),
  roomFloor VARCHAR2(255),
  roomAvb VARCHAR2(255),
  roomStatus VARCHAR2(255),
  roomFee NUMBER,
  roomAssignedTo VARCHAR2(255),
  roomBuilding VARCHAR2(255)
);

CREATE TABLE Incidents (
    IncidentId NUMBER PRIMARY KEY,
    inc_date DATE,
    Day VARCHAR2(10),
    Location VARCHAR2(255),
    Description VARCHAR2(255),
    incidentTime VARCHAR2(10)
);

CREATE TABLE Menus (
    MenuId NUMBER PRIMARY KEY,
    Day VARCHAR2(10),
    Breakfast VARCHAR2(255),
    Lunch VARCHAR2(255),
    Dinner VARCHAR2(255)
);

CREATE TABLE Wardens (
    WardenId NUMBER PRIMARY KEY,
    WardenName VARCHAR2(255),
    WardenEmail VARCHAR2(255),
    WardenContact VARCHAR2(20),
    Gender VARCHAR2(10),
    Address VARCHAR2(255)
);

CREATE TABLE Student (
    studentUsername VARCHAR2(50),
    studentId NUMBER,
    studentEmail VARCHAR2(100),
    studentContact VARCHAR2(20),
    studentAddress VARCHAR2(200),
    studentPassword VARCHAR2(100),
    studentName VARCHAR2(100),
    rollNo VARCHAR2(20),
    year VARCHAR2(10),
    roomNo VARCHAR2(20),
    roomType VARCHAR2(50),
    roomPrice VARCHAR2(20),
    roomStatus VARCHAR2(20)
);

SELECT * FROM Wardens;
SELECT * FROM Student;
SELECT * FROM Menus;
SELECT * FROM Incidents;
SELECT * FROM Rooms;


