-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2020 at 06:06 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `showroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `hitung`
--

CREATE TABLE `hitung` (
  `id` int(10) NOT NULL,
  `kategori` varchar(49) NOT NULL,
  `jumlah` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hitung`
--

INSERT INTO `hitung` (`id`, `kategori`, `jumlah`) VALUES
(1, 'Mobil Kecil', 6),
(2, 'Mobil Sedang', 4);

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id` int(10) NOT NULL,
  `kategori` varchar(40) NOT NULL,
  `major` int(10) NOT NULL,
  `minor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id`, `kategori`, `major`, `minor`) VALUES
(1, 'Mobil Kecil', 111, 148),
(2, 'Mobil Kecil', 111, 149),
(3, 'Mobil Sedang', 111, 150),
(4, 'Mobil Kecil', 111, 151),
(5, 'Mobil Sedang', 111, 152),
(6, 'Mobil Kecil', 111, 1333),
(7, 'Mobil Kecil', 111, 153),
(8, 'Mobil Kecil', 111, 154),
(9, 'Mobil Sedang', 111, 155),
(10, 'Mobil Sedang', 111, 156),
(11, 'Mobil Kecil', 111, 157),
(12, 'Mobil Sedang', 111, 158),
(13, 'Mobil Sedang', 111, 159),
(14, 'Mobil Kecil', 111, 160),
(15, 'Mobil Kecil', 111, 161),
(16, 'Mobil Kecil', 111, 162),
(17, 'Mobil Sedang', 111, 163),
(18, 'Mobil Sedang', 111, 164),
(19, 'Mobil Kecil', 111, 165),
(20, 'Mobil Sedang', 111, 166),
(21, 'Mobil Kecil', 111, 167),
(22, 'Mobil Kecil', 111, 168),
(23, 'Mobil Kecil', 111, 169),
(24, 'Mobil Sedang', 111, 170),
(25, 'Mobil Sedang', 111, 171),
(26, 'Honda Civic', 111, 172),
(27, 'Honda Mobilio', 111, 173),
(28, 'Honda Mobilio', 111, 174),
(29, 'Honda Mobilio', 111, 175),
(30, 'Honda Mobilio', 111, 176);

-- --------------------------------------------------------

--
-- Table structure for table `pembacaan`
--

CREATE TABLE `pembacaan` (
  `id` int(10) NOT NULL,
  `major` int(10) NOT NULL,
  `minor` int(10) NOT NULL,
  `rssi` int(10) NOT NULL,
  `kategori` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembacaan`
--

INSERT INTO `pembacaan` (`id`, `major`, `minor`, `rssi`, `kategori`, `date`, `time`) VALUES
(178, 111, 151, -71, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03'),
(179, 111, 150, -72, 'Mobil Sedang', '2020-01-22', '2020-03-08 22:11:12'),
(180, 111, 1333, -59, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03'),
(181, 111, 154, -67, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03'),
(182, 111, 158, -67, 'Mobil Sedang', '2020-01-22', '2020-03-08 22:11:12'),
(183, 111, 166, -71, 'Mobil Sedang', '2020-01-22', '2020-03-08 22:11:12'),
(184, 111, 170, -64, 'Mobil Sedang', '2020-01-22', '2020-03-08 22:11:12'),
(185, 111, 167, -51, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03'),
(186, 111, 162, -53, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03'),
(187, 111, 161, -66, 'Mobil Kecil', '2020-01-22', '2020-03-08 16:56:03');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, 'divairmaa', 'divairmaa@yahoo.com', '$2y$10$D6AXHRu4yNtN29x.BFUhvO9wa5rA3HQm2g8HC0N9En9O3rQjvmuyO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hitung`
--
ALTER TABLE `hitung`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembacaan`
--
ALTER TABLE `pembacaan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hitung`
--
ALTER TABLE `hitung`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `pembacaan`
--
ALTER TABLE `pembacaan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=188;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
