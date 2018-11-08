-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 08, 2018 at 10:02 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `City` varchar(50) NOT NULL,
  `Suburb` varchar(50) NOT NULL,
  `Street` varchar(50) NOT NULL,
  `Port` varchar(4) NOT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `AdministratorID` varchar(13) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL,
  PRIMARY KEY (`AdministratorID`),
  KEY `AddressID` (`AddressID`),
  KEY `LoginID` (`LoginID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`AdministratorID`, `Name`, `Surname`, `CellNo`, `Email`, `AddressID`, `LoginID`) VALUES
('9610285023088', 'Hendriko', 'du Toit', '0722006736', 'hendrikodutoit@gmail.com', 7, 1),
('9705025023088', 'Nicky', 'Muller', '0822239591', 'mullernicky12@gmail.com', 8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `CategoryID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  PRIMARY KEY (`CategoryID`)
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

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `DepartmentID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
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

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `LoginID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`LoginID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `ManufacturerID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL,
  PRIMARY KEY (`ManufacturerID`),
  KEY `AddressID` (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE IF NOT EXISTS `orderdetails` (
  `OrderID` int(11) NOT NULL,
  `StationeryCode` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`OrderID`,`StationeryCode`),
  KEY `OrderID` (`OrderID`),
  KEY `StationeryCode` (`StationeryCode`)
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

DROP TABLE IF EXISTS `request`;
CREATE TABLE IF NOT EXISTS `request` (
  `RequestID` int(11) NOT NULL AUTO_INCREMENT,
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

DROP TABLE IF EXISTS `requestdetails`;
CREATE TABLE IF NOT EXISTS `requestdetails` (
  `RequestID` int(11) NOT NULL,
  `StationeryCode` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`RequestID`,`StationeryCode`),
  KEY `RequestID` (`RequestID`),
  KEY `StationeryCode` (`StationeryCode`)
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

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `StaffID` varchar(13) NOT NULL,
  `DepartmentID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `CellNo` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `AddressID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL,
  `Registered` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`StaffID`),
  KEY `DepartmentID` (`DepartmentID`),
  KEY `AddressID` (`AddressID`),
  KEY `LoginID` (`LoginID`)
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

DROP TABLE IF EXISTS `stationery`;
CREATE TABLE IF NOT EXISTS `stationery` (
  `StationeryCode` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryID` int(11) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `Stock` int(11) NOT NULL,
  `Price` double NOT NULL,
  `ManufacturerID` int(11) NOT NULL,
  PRIMARY KEY (`StationeryCode`),
  KEY `CategoryID` (`CategoryID`),
  KEY `ManufacturerID` (`ManufacturerID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

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

DROP TABLE IF EXISTS `tblorder`;
CREATE TABLE IF NOT EXISTS `tblorder` (
  `OrderID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `AdministratorID` varchar(13) NOT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `AdministratorID` (`AdministratorID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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
-- Constraints for dumped tables
--

--
-- Constraints for table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `admin_address_fk` FOREIGN KEY (`AddressID`) REFERENCES `address` (`AddressID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `admin_login_fk` FOREIGN KEY (`LoginID`) REFERENCES `login` (`LoginID`) ON DELETE CASCADE ON UPDATE CASCADE;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
