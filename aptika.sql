-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2021 at 01:31 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aptika`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftarobat`
--

CREATE TABLE `daftarobat` (
  `kode` varchar(11) NOT NULL,
  `namaobat` varchar(50) NOT NULL,
  `jenisobat` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `satuan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftarobat`
--

INSERT INTO `daftarobat` (`kode`, `namaobat`, `jenisobat`, `jumlah`, `satuan`) VALUES
('abcdefgh', ' Amoxicillin', ' Paten', 10, 'Papan');

-- --------------------------------------------------------

--
-- Table structure for table `jenisobat`
--

CREATE TABLE `jenisobat` (
  `kodejenis` varchar(11) NOT NULL,
  `jenisobat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jenisobat`
--

INSERT INTO `jenisobat` (`kodejenis`, `jenisobat`) VALUES
(' P01', ' Paten');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `daftarobat`
--
ALTER TABLE `daftarobat`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `jenisobat`
--
ALTER TABLE `jenisobat`
  ADD PRIMARY KEY (`kodejenis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
