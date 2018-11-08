-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 08, 2018 at 10:02 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bcstationery`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Suburb` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `Port` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`AddressID`, `City`, `Suburb`, `Street`, `Port`) VALUES
(1, 'Durban', 'Rossburgh', '211 South Coast', '2056'),
(2, 'Durban', 'Nandi', '31 Imvubu Park', '1560'),
(3, 'Johannesburg', 'Sandton', '30 Drie\'s Niemand', '1982'),
(4, 'Pretoria', 'Ninapark', 'Sunbird', '0156'),
(5, 'Pretoria', 'Montana', 'Haveman', '1926'),
(6, 'Johannesburg', 'Fourways', 'Macbeth', '1867'),
(7, 'Pretoria', 'Theresapark', 'Oxroad', '0157'),
(8, 'Pretoria', 'Ninapark', 'Strandlopertjie', '0156'),
(9, 'Benoni', 'Alliance', 'Crystal Road', '2896'),
(10, 'Benoni', 'Cloverdene', 'Farrarmere', '2675');

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `AdministratorID` varchar(13) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`AdministratorID`, `Name`, `Surname`, `CellNo`, `Email`, `AddressID`, `LoginID`) VALUES
('9610285023088', 'Hendriko', 'du Toit', '0722006736', 'hendrikodutoit@gmail.com', 7, 1),
('9705025023088', 'Nicky', 'Muller', '0822239591', 'mullernicky12@gmail.com', 8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `campus`
--

CREATE TABLE `campus` (
  `ID` int(11) NOT NULL,
  `Location` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `campus`
--

INSERT INTO `campus` (`ID`, `Location`) VALUES
(1, 'Pretoria'),
(2, 'Kempton');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryID`, `Description`) VALUES
(1, 'Pens'),
(2, 'Pencils'),
(3, 'Erasers'),
(4, 'Highlighters'),
(5, 'Files'),
(6, 'Printing Paper');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DepartmentID`, `Description`) VALUES
(1, 'Business Management'),
(2, 'Finance'),
(3, 'Marketing Management'),
(4, 'Architecture');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `LoginID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`LoginID`, `Username`, `Password`) VALUES
(1, 'HendrikoA', '123'),
(2, 'NickyA', '123'),
(3, 'JozehanS', '123'),
(4, 'TyroneS', '123');

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

CREATE TABLE `manufacturer` (
  `ManufacturerID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`ManufacturerID`, `Name`, `CellNo`, `Email`, `AddressID`) VALUES
(1, 'Pens4U', '0125421376', 'pens4u@gmail.com', 1),
(2, 'Pencils Unite', '0125678291', 'pencils.unite@gmail.com', 2),
(3, 'Problem Erasers', '0125267891', 'erasingproblems@gmail.com', 3),
(4, 'Highlighting Life', '0125231235', 'highlightinglife@gmail.com', 4),
(5, 'File Specialists', '0127631236', 'fs@gmail.com', 5),
(6, 'PrintAway', '0127652345', 'printaway@gmail.com', 6);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrderID` int(11) NOT NULL,
  `StationeryCode` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`OrderID`, `StationeryCode`, `Quantity`) VALUES
(1, 1, 5),
(1, 2, 2),
(1, 7, 5),
(1, 11, 20),
(2, 4, 2),
(2, 5, 5),
(2, 7, 1),
(2, 8, 6),
(3, 1, 2),
(4, 1, 2),
(4, 5, 2),
(4, 8, 2),
(4, 12, 2),
(5, 1, 2),
(6, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `RequestID` int(11) NOT NULL,
  `StaffID` varchar(13) NOT NULL,
  `AdministratorID` varchar(13) DEFAULT NULL,
  `RequestDate` date NOT NULL,
  `ReceiveDate` date DEFAULT NULL,
  `accepted` bit(1) DEFAULT NULL,
  `AdminResponse` varchar(50) NOT NULL,
  `AdminResponseReceived` bit(1) NOT NULL,
  PRIMARY KEY (`RequestID`),
  KEY `AdministratorID` (`AdministratorID`),
  KEY `StaffID` (`StaffID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`RequestID`, `StaffID`, `AdministratorID`, `RequestDate`, `ReceiveDate`, `accepted`, `AdminResponse`, `AdminResponseReceived`) VALUES
(1, '9601015023088', '9610285023088', '2018-10-03', '2018-10-05', b'1', '', b'0'),
(2, '9702055023088', '9705025023088', '2018-10-04', '2018-10-05', b'1', '', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `requestdetails`
--

CREATE TABLE `requestdetails` (
  `RequestID` int(11) NOT NULL,
  `StationeryCode` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requestdetails`
--

INSERT INTO `requestdetails` (`RequestID`, `StationeryCode`, `Quantity`) VALUES
(1, 1, 2),
(1, 2, 2),
(1, 6, 1),
(1, 10, 2),
(2, 1, 2),
(2, 6, 7),
(2, 7, 2),
(2, 11, 5);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `StaffID` varchar(13) NOT NULL,
  `DepartmentID` int(11) NOT NULL,
  `CampusID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL,
  `Registered` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `DepartmentID`, `Name`, `Surname`, `CellNo`, `Email`, `AddressID`, `LoginID`, `Registered`) VALUES
('9601015023088', 1, 'Jozehan', 'Grobler', '0721894567', 'grobies@gmail.com', 9, 3, b'1'),
('9702055023088', 2, 'Tyrone', 'du Plessis', '0834567890', 'tdp@gmail.com', 10, 4, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `stationery`
--

CREATE TABLE `stationery` (
  `StationeryCode` int(11) NOT NULL,
  `CategoryID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Stock` int(11) NOT NULL,
  `Price` double NOT NULL,
  `ManufacturerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stationery`
--

INSERT INTO `stationery` (`StationeryCode`, `CategoryID`, `Description`, `Stock`, `Price`, `ManufacturerID`) VALUES
(1, 1, 'Bic Blue 4 pack', 18, 5, 1),
(2, 1, 'Bic Black 4 pack', 15, 7, 1),
(3, 2, 'HB 2B X 2', 10, 3, 2),
(4, 2, 'Staedtler HB X 4', 2, 10, 2),
(5, 3, 'Mon Ami', 26, 3, 3),
(6, 3, 'Staedtler 7 piece ', 5, 15, 3),
(7, 4, 'Centropen 4 piece', 3, 20, 4),
(8, 4, 'Stabilo 4 piece', 1, 30, 4),
(9, 5, 'Croxley mottled board', 40, 32, 5),
(10, 5, 'Waltons file storage box', 5, 39, 5),
(11, 6, 'Mondi A4 X 500', 5, 150, 6),
(12, 6, 'Typek A4 X 200', 10, 200, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tblorder`
--

CREATE TABLE `tblorder` (
  `OrderID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `AdministratorID` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblorder`
--

INSERT INTO `tblorder` (`OrderID`, `Date`, `AdministratorID`) VALUES
(1, '2018-10-01', '9610285023088'),
(2, '2018-10-02', '9705025023088'),
(3, '2018-10-31', '9610285023088'),
(4, '2018-10-31', '9610285023088'),
(5, '2018-10-01', '9610285023088'),
(6, '2018-09-03', '9610285023088');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`AddressID`);

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`AdministratorID`),
  ADD KEY `AddressID` (`AddressID`),
  ADD KEY `LoginID` (`LoginID`);

--
-- Indexes for table `campus`
--
ALTER TABLE `campus`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID` (`ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LoginID`);

--
-- Indexes for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD PRIMARY KEY (`ManufacturerID`),
  ADD KEY `AddressID` (`AddressID`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrderID`,`StationeryCode`),
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `StationeryCode` (`StationeryCode`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`RequestID`),
  ADD KEY `AdministratorID` (`AdministratorID`),
  ADD KEY `StaffID` (`StaffID`);

--
-- Indexes for table `requestdetails`
--
ALTER TABLE `requestdetails`
  ADD PRIMARY KEY (`RequestID`,`StationeryCode`),
  ADD KEY `RequestID` (`RequestID`),
  ADD KEY `StationeryCode` (`StationeryCode`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`StaffID`),
  ADD KEY `DepartmentID` (`DepartmentID`),
  ADD KEY `AddressID` (`AddressID`),
  ADD KEY `LoginID` (`LoginID`),
  ADD KEY `CampusID` (`CampusID`);

--
-- Indexes for table `stationery`
--
ALTER TABLE `stationery`
  ADD PRIMARY KEY (`StationeryCode`),
  ADD KEY `CategoryID` (`CategoryID`),
  ADD KEY `ManufacturerID` (`ManufacturerID`);

--
-- Indexes for table `tblorder`
--
ALTER TABLE `tblorder`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `AdministratorID` (`AdministratorID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `AddressID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `campus`
--
ALTER TABLE `campus`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `LoginID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `manufacturer`
--
ALTER TABLE `manufacturer`
  MODIFY `ManufacturerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `request`
--
ALTER TABLE `request`
  MODIFY `RequestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `stationery`
--
ALTER TABLE `stationery`
  MODIFY `StationeryCode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tblorder`
--
ALTER TABLE `tblorder`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `admin_address_fk` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `admin_login_fk` FOREIGN KEY (`LoginID`) REFERENCES `login` (`LoginID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `campus`
--
ALTER TABLE `campus`
  ADD CONSTRAINT `FK_Campus_ID` FOREIGN KEY (`ID`) REFERENCES `staff` (`CampusID`);

--
-- Constraints for table `manufacturer`
--
ALTER TABLE `manufacturer`
  ADD CONSTRAINT `manufacturer_address_fk` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_order_fk` FOREIGN KEY (`OrderID`) REFERENCES `tblorder` (`OrderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetails_stationery_fk` FOREIGN KEY (`StationeryCode`) REFERENCES `stationery` (`StationeryCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_staff_fk` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `reuqest_admin_fk` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `requestdetails`
--
ALTER TABLE `requestdetails`
  ADD CONSTRAINT `requestdetails_request_fk` FOREIGN KEY (`RequestID`) REFERENCES `request` (`RequestID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `requestdetails_stationery_fk` FOREIGN KEY (`StationeryCode`) REFERENCES `stationery` (`StationeryCode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_address_fk` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `staff_department_fk` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `staff_login_fk` FOREIGN KEY (`LoginID`) REFERENCES `login` (`LoginID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stationery`
--
ALTER TABLE `stationery`
  ADD CONSTRAINT `stationery_category_fk` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stationery_manufacturer_fk` FOREIGN KEY (`ManufacturerID`) REFERENCES `manufacturer` (`ManufacturerID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tblorder`
--
ALTER TABLE `tblorder`
  ADD CONSTRAINT `order_administrator_fk` FOREIGN KEY (`AdministratorID`) REFERENCES `administrator` (`AdministratorID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
