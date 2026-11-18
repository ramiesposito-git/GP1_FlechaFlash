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


-- --------------------------------------------------------
-- Datos de prueba para FlechaFlashDB
-- Los estados se inicializan en 1 (activos/disponibles).
-- Cada colectivo tiene exactamente tantos asientos como su capacidad.
-- La tabla pasaje se deja intencionalmente vacía.
-- --------------------------------------------------------

START TRANSACTION;

INSERT INTO `colectivos`
  (`ID_colectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `chofer`, `estado`)
VALUES
    (1, 'AB123CD', 'Mercedes-Benz', 'O500', 20, 'Roberto Sánchez', 1),
    (2, 'AC456EF', 'Scania', 'K360', 24, 'Marcelo Gómez', 1),
    (3, 'AD789GH', 'Volvo', 'B290R', 30, 'Daniel Fernández', 1),
    (4, 'AE234JK', 'Mercedes-Benz', 'O500 RSD', 36, 'Jorge Martínez', 1),
    (5, 'AF567LM', 'Scania', 'K400', 40, 'Pablo Rodríguez', 1),
    (6, 'AG890NP', 'Volvo', 'B430R', 45, 'Carlos López', 1);

INSERT INTO `asiento`
  (`ID_asiento`, `ID_colectivo`, `numero_asiento`, `estado`)
VALUES
    (1, 1, 1, 1),
    (2, 1, 2, 1),
    (3, 1, 3, 1),
    (4, 1, 4, 1),
    (5, 1, 5, 1),
    (6, 1, 6, 1),
    (7, 1, 7, 1),
    (8, 1, 8, 1),
    (9, 1, 9, 1),
    (10, 1, 10, 1),
    (11, 1, 11, 1),
    (12, 1, 12, 1),
    (13, 1, 13, 1),
    (14, 1, 14, 1),
    (15, 1, 15, 1),
    (16, 1, 16, 1),
    (17, 1, 17, 1),
    (18, 1, 18, 1),
    (19, 1, 19, 1),
    (20, 1, 20, 1),
    (21, 2, 1, 1),
    (22, 2, 2, 1),
    (23, 2, 3, 1),
    (24, 2, 4, 1),
    (25, 2, 5, 1),
    (26, 2, 6, 1),
    (27, 2, 7, 1),
    (28, 2, 8, 1),
    (29, 2, 9, 1),
    (30, 2, 10, 1),
    (31, 2, 11, 1),
    (32, 2, 12, 1),
    (33, 2, 13, 1),
    (34, 2, 14, 1),
    (35, 2, 15, 1),
    (36, 2, 16, 1),
    (37, 2, 17, 1),
    (38, 2, 18, 1),
    (39, 2, 19, 1),
    (40, 2, 20, 1),
    (41, 2, 21, 1),
    (42, 2, 22, 1),
    (43, 2, 23, 1),
    (44, 2, 24, 1),
    (45, 3, 1, 1),
    (46, 3, 2, 1),
    (47, 3, 3, 1),
    (48, 3, 4, 1),
    (49, 3, 5, 1),
    (50, 3, 6, 1),
    (51, 3, 7, 1),
    (52, 3, 8, 1),
    (53, 3, 9, 1),
    (54, 3, 10, 1),
    (55, 3, 11, 1),
    (56, 3, 12, 1),
    (57, 3, 13, 1),
    (58, 3, 14, 1),
    (59, 3, 15, 1),
    (60, 3, 16, 1),
    (61, 3, 17, 1),
    (62, 3, 18, 1),
    (63, 3, 19, 1),
    (64, 3, 20, 1),
    (65, 3, 21, 1),
    (66, 3, 22, 1),
    (67, 3, 23, 1),
    (68, 3, 24, 1),
    (69, 3, 25, 1),
    (70, 3, 26, 1),
    (71, 3, 27, 1),
    (72, 3, 28, 1),
    (73, 3, 29, 1),
    (74, 3, 30, 1),
    (75, 4, 1, 1),
    (76, 4, 2, 1),
    (77, 4, 3, 1),
    (78, 4, 4, 1),
    (79, 4, 5, 1),
    (80, 4, 6, 1),
    (81, 4, 7, 1),
    (82, 4, 8, 1),
    (83, 4, 9, 1),
    (84, 4, 10, 1),
    (85, 4, 11, 1),
    (86, 4, 12, 1),
    (87, 4, 13, 1),
    (88, 4, 14, 1),
    (89, 4, 15, 1),
    (90, 4, 16, 1),
    (91, 4, 17, 1),
    (92, 4, 18, 1),
    (93, 4, 19, 1),
    (94, 4, 20, 1),
    (95, 4, 21, 1),
    (96, 4, 22, 1),
    (97, 4, 23, 1),
    (98, 4, 24, 1),
    (99, 4, 25, 1),
    (100, 4, 26, 1),
    (101, 4, 27, 1),
    (102, 4, 28, 1),
    (103, 4, 29, 1),
    (104, 4, 30, 1),
    (105, 4, 31, 1),
    (106, 4, 32, 1),
    (107, 4, 33, 1),
    (108, 4, 34, 1),
    (109, 4, 35, 1),
    (110, 4, 36, 1),
    (111, 5, 1, 1),
    (112, 5, 2, 1),
    (113, 5, 3, 1),
    (114, 5, 4, 1),
    (115, 5, 5, 1),
    (116, 5, 6, 1),
    (117, 5, 7, 1),
    (118, 5, 8, 1),
    (119, 5, 9, 1),
    (120, 5, 10, 1),
    (121, 5, 11, 1),
    (122, 5, 12, 1),
    (123, 5, 13, 1),
    (124, 5, 14, 1),
    (125, 5, 15, 1),
    (126, 5, 16, 1),
    (127, 5, 17, 1),
    (128, 5, 18, 1),
    (129, 5, 19, 1),
    (130, 5, 20, 1),
    (131, 5, 21, 1),
    (132, 5, 22, 1),
    (133, 5, 23, 1),
    (134, 5, 24, 1),
    (135, 5, 25, 1),
    (136, 5, 26, 1),
    (137, 5, 27, 1),
    (138, 5, 28, 1),
    (139, 5, 29, 1),
    (140, 5, 30, 1),
    (141, 5, 31, 1),
    (142, 5, 32, 1),
    (143, 5, 33, 1),
    (144, 5, 34, 1),
    (145, 5, 35, 1),
    (146, 5, 36, 1),
    (147, 5, 37, 1),
    (148, 5, 38, 1),
    (149, 5, 39, 1),
    (150, 5, 40, 1),
    (151, 6, 1, 1),
    (152, 6, 2, 1),
    (153, 6, 3, 1),
    (154, 6, 4, 1),
    (155, 6, 5, 1),
    (156, 6, 6, 1),
    (157, 6, 7, 1),
    (158, 6, 8, 1),
    (159, 6, 9, 1),
    (160, 6, 10, 1),
    (161, 6, 11, 1),
    (162, 6, 12, 1),
    (163, 6, 13, 1),
    (164, 6, 14, 1),
    (165, 6, 15, 1),
    (166, 6, 16, 1),
    (167, 6, 17, 1),
    (168, 6, 18, 1),
    (169, 6, 19, 1),
    (170, 6, 20, 1),
    (171, 6, 21, 1),
    (172, 6, 22, 1),
    (173, 6, 23, 1),
    (174, 6, 24, 1),
    (175, 6, 25, 1),
    (176, 6, 26, 1),
    (177, 6, 27, 1),
    (178, 6, 28, 1),
    (179, 6, 29, 1),
    (180, 6, 30, 1),
    (181, 6, 31, 1),
    (182, 6, 32, 1),
    (183, 6, 33, 1),
    (184, 6, 34, 1),
    (185, 6, 35, 1),
    (186, 6, 36, 1),
    (187, 6, 37, 1),
    (188, 6, 38, 1),
    (189, 6, 39, 1),
    (190, 6, 40, 1),
    (191, 6, 41, 1),
    (192, 6, 42, 1),
    (193, 6, 43, 1),
    (194, 6, 44, 1),
    (195, 6, 45, 1);

INSERT INTO `pasajero`
  (`idPasajero`, `dni`, `nombre`, `apellido`, `correo`, `telefono`, `estado`)
VALUES
    (1, '30123456', 'Juan', 'Pérez', 'juan.perez@mail.com', '2664123001', 1),
    (2, '28456789', 'María', 'Gómez', 'maria.gomez@mail.com', '2664123002', 1),
    (3, '32789123', 'Lucas', 'Fernández', 'lucas.fernandez@mail.com', '2664123003', 1),
    (4, '35901234', 'Sofía', 'Martínez', 'sofia.martinez@mail.com', '2664123004', 1),
    (5, '27345678', 'Matías', 'Rodríguez', 'matias.rodriguez@mail.com', '2664123005', 1),
    (6, '34123456', 'Valentina', 'López', 'valentina.lopez@mail.com', '2664123006', 1),
    (7, '29567890', 'Tomás', 'Díaz', 'tomas.diaz@mail.com', '2664123007', 1),
    (8, '36890123', 'Camila', 'Torres', 'camila.torres@mail.com', '2664123008', 1),
    (9, '31234567', 'Nicolás', 'Ramírez', 'nicolas.ramirez@mail.com', '2664123009', 1),
    (10, '25678901', 'Florencia', 'Álvarez', 'florencia.alvarez@mail.com', '2664123010', 1),
    (11, '37901234', 'Santiago', 'Romero', 'santiago.romero@mail.com', '2664123011', 1),
    (12, '32345678', 'Martina', 'Sosa', 'martina.sosa@mail.com', '2664123012', 1),
    (13, '26789012', 'Agustín', 'Benítez', 'agustin.benitez@mail.com', '2664123013', 1),
    (14, '35123456', 'Julieta', 'Herrera', 'julieta.herrera@mail.com', '2664123014', 1),
    (15, '29876543', 'Franco', 'Castro', 'franco.castro@mail.com', '2664123015', 1),
    (16, '38654321', 'Renata', 'Suárez', 'renata.suarez@mail.com', '2664123016', 1),
    (17, '31456789', 'Thiago', 'Acosta', 'thiago.acosta@mail.com', '2664123017', 1),
    (18, '27987654', 'Micaela', 'Medina', 'micaela.medina@mail.com', '2664123018', 1),
    (19, '36234567', 'Benjamín', 'Pereyra', 'benjamin.pereyra@mail.com', '2664123019', 1),
    (20, '30567891', 'Agustina', 'Vega', 'agustina.vega@mail.com', '2664123020', 1),
    (21, '39456781', 'Joaquín', 'Molina', 'joaquin.molina@mail.com', '2664123021', 1),
    (22, '28890123', 'Abril', 'Ríos', 'abril.rios@mail.com', '2664123022', 1),
    (23, '33678901', 'Facundo', 'Cabrera', 'facundo.cabrera@mail.com', '2664123023', 1),
    (24, '27123456', 'Catalina', 'Navarro', 'catalina.navarro@mail.com', '2664123024', 1),
    (25, '37456789', 'Lautaro', 'Silva', 'lautaro.silva@mail.com', '2664123025', 1);

INSERT INTO `ruta_viaje`
  (`ID_ruta`, `origen`, `destino`, `Hora_Salida`, `Hora_Llegada`, `ID_colectivo`, `precio`, `estado`)
VALUES
    (1, 'San Luis', 'Mendoza', '08:00:00', '10:30:00', 1, 8500.0, 1),
    (2, 'San Luis', 'Córdoba', '09:15:00', '13:45:00', 2, 14500.0, 1),
    (3, 'San Luis', 'Villa Mercedes', '07:30:00', '09:00:00', 3, 5200.0, 1),
    (4, 'Mendoza', 'San Juan', '14:00:00', '16:30:00', 4, 9200.0, 1),
    (5, 'San Luis', 'Buenos Aires', '20:00:00', '07:00:00', 5, 38500.0, 1);

-- No se insertan registros en `pasaje`.
COMMIT;
