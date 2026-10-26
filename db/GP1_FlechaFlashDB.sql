-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2026 at 06:29 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flechaflashdb`
--
CREATE DATABASE IF NOT EXISTS `flechaflashdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `flechaflashdb`;

-- --------------------------------------------------------

--
-- Table structure for table `asiento`
--

CREATE TABLE `asiento` (
  `ID_asiento` int(11) NOT NULL,
  `ID_colectivo` int(11) NOT NULL,
  `numero_asiento` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `colectivos`
--

CREATE TABLE `colectivos` (
  `ID_colectivo` int(11) NOT NULL,
  `matricula` varchar(20) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `chofer` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pasaje`
--

CREATE TABLE `pasaje` (
  `ID_pasaje` int(11) NOT NULL,
  `idPasajero` int(11) NOT NULL,
  `ID_asiento` int(11) NOT NULL,
  `ID_ruta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `hora_venta` time NOT NULL,
  `precio` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pasajero`
--

CREATE TABLE `pasajero` (
  `idPasajero` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ruta_viaje`
--

CREATE TABLE `ruta_viaje` (
  `ID_ruta` int(11) NOT NULL,
  `origen` varchar(30) NOT NULL,
  `destino` varchar(30) NOT NULL,
  `Hora_Salida` time NOT NULL,
  `Hora_Llegada` time NOT NULL,
  `ID_colectivo` int(11) NOT NULL,
  `precio` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`ID_asiento`),
  ADD KEY `ID_colectivo` (`ID_colectivo`);

--
-- Indexes for table `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`ID_colectivo`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indexes for table `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`ID_pasaje`),
  ADD KEY `idPasajero` (`idPasajero`),
  ADD KEY `ID_asiento` (`ID_asiento`),
  ADD KEY `ID_ruta` (`ID_ruta`);

--
-- Indexes for table `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`idPasajero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indexes for table `ruta_viaje`
--
ALTER TABLE `ruta_viaje`
  ADD PRIMARY KEY (`ID_ruta`),
  ADD KEY `ID_colectivo` (`ID_colectivo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asiento`
--
ALTER TABLE `asiento`
  MODIFY `ID_asiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `ID_colectivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `ID_pasaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pasajero`
--
ALTER TABLE `pasajero`
  MODIFY `idPasajero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ruta_viaje`
--
ALTER TABLE `ruta_viaje`
  MODIFY `ID_ruta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asiento`
--
ALTER TABLE `asiento`
  ADD CONSTRAINT `asiento_ibfk_1` FOREIGN KEY (`ID_colectivo`) REFERENCES `colectivos` (`ID_colectivo`);

--
-- Constraints for table `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `pasaje_ibfk_1` FOREIGN KEY (`idPasajero`) REFERENCES `pasajero` (`idPasajero`),
  ADD CONSTRAINT `pasaje_ibfk_2` FOREIGN KEY (`ID_asiento`) REFERENCES `asiento` (`ID_asiento`),
  ADD CONSTRAINT `pasaje_ibfk_3` FOREIGN KEY (`ID_ruta`) REFERENCES `ruta_viaje` (`ID_ruta`);

--
-- Constraints for table `ruta_viaje`
--
ALTER TABLE `ruta_viaje`
  ADD CONSTRAINT `ruta_viaje_ibfk_1` FOREIGN KEY (`ID_colectivo`) REFERENCES `colectivos` (`ID_colectivo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
