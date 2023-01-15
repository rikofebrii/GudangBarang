-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2022 at 11:03 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gudang_barang`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(6) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `stok` int(11) NOT NULL,
  `tgl_exp` date NOT NULL,
  `barang_masuk` date DEFAULT NULL,
  `keterangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_barang`, `nama_barang`, `stok`, `tgl_exp`, `barang_masuk`, `keterangan`) VALUES
('KB0001', 'Aqua', 50, '2050-10-15', '2021-12-28', 'Botol 600ML'),
('KB0002', 'Aqua', 250, '2033-12-31', '2021-12-29', 'Botol 600ML'),
('KB0003', 'Vit', 70, '2050-12-31', '2021-12-29', 'Botol 330ML'),
('KB0004', 'Le Minerale', 350, '2041-01-30', '2021-12-31', 'Botol 330ML'),
('KB0005', 'Teh Botol', 0, '2022-01-12', '2022-01-01', 'Botol 350ML'),
('KB0006', 'Good Day', 235, '2028-01-07', '2022-01-02', 'Botol 250ML'),
('KB0007', 'Pocari Sweat', 114, '2030-10-12', '2022-01-02', 'Botol 500ML'),
('KB0008', 'Hydro Coco', 192, '2030-06-30', '2022-01-02', 'Kemasan 250ML'),
('KB0009', 'Ultramilk', 50, '2044-12-31', '2022-01-03', 'Coklat 250ML'),
('KB0010', 'Ultramilk', 63, '2044-12-31', '2022-01-03', 'Stroberi 250ML'),
('KB0011', 'Ultramilk', 85, '2044-12-31', '2022-01-03', 'Fullcream 250ML'),
('KB0012', 'Floridina', 8, '2030-05-30', '2022-01-05', 'Botol 350ML'),
('KB0013', 'Minute Maid Pulpy', 65, '2047-11-30', '2022-01-10', 'Botol 300ML');

-- --------------------------------------------------------

--
-- Table structure for table `barang_keluar`
--

CREATE TABLE `barang_keluar` (
  `id_barang_keluar` varchar(6) NOT NULL,
  `barang_keluar` date NOT NULL,
  `kd_barang` varchar(6) DEFAULT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `barang_masuk` date NOT NULL,
  `jumlah_barang_keluar` int(11) NOT NULL,
  `tgl_exp` date NOT NULL,
  `keterangan_keluar` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang_keluar`
--

INSERT INTO `barang_keluar` (`id_barang_keluar`, `barang_keluar`, `kd_barang`, `nama_barang`, `barang_masuk`, `jumlah_barang_keluar`, `tgl_exp`, `keterangan_keluar`) VALUES
('BK0001', '2022-01-05', 'KB0001', 'Aqua', '2021-12-28', 15, '2050-10-15', 'Terjual'),
('BK0002', '2022-01-05', 'KB0004', 'Le Minerale', '2021-12-31', 35, '2041-01-30', 'Terjual'),
('BK0003', '2022-01-06', 'KB0006', 'Good Day', '2022-01-02', 1, '2028-01-07', 'Barang Rusak'),
('BK0004', '2022-01-06', 'KB0008', 'Hydro Coco', '2022-01-02', 28, '2030-06-30', 'Terjual'),
('BK0005', '2022-01-07', 'KB0011', 'Ultramilk', '2022-01-03', 25, '2044-12-31', 'Terjual'),
('BK0006', '2022-01-07', 'KB0010', 'Ultramilk', '2022-01-03', 12, '2044-12-31', 'Terjual'),
('BK0007', '2022-01-10', 'KB0007', 'Pocari Sweat', '2022-01-02', 6, '2030-10-12', 'Terjual'),
('BK0008', '2022-01-10', 'KB0012', 'Floridina', '2022-01-05', 7, '2030-05-30', 'Terjual'),
('BK0009', '2022-01-12', 'KB0005', 'Teh Botol', '2022-01-01', 55, '2022-01-12', 'Expired');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', 'admin'),
('admin123', 'admin123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `barang_keluar`
--
ALTER TABLE `barang_keluar`
  ADD PRIMARY KEY (`id_barang_keluar`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
