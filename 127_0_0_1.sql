-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-08-2021 a las 16:09:13
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `camilocarreraautos`
--
DROP DATABASE IF EXISTS `camilocarreraautos`;
CREATE DATABASE IF NOT EXISTS `camilocarreraautos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `camilocarreraautos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganadores`
--

DROP TABLE IF EXISTS `ganadores`;
CREATE TABLE `ganadores` (
  `carreraNumero` int(11) DEFAULT NULL,
  `carro` varchar(20) DEFAULT NULL,
  `ubicacion` int(11) DEFAULT NULL,
  `diadecompetencia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ganadores`
--

INSERT INTO `ganadores` (`carreraNumero`, `carro`, `ubicacion`, `diadecompetencia`) VALUES
(1, 'PORSCHE', 1, '2021/07/31 23:25:10'),
(1, 'BUGATTI', 2, '2021/07/31 23:25:11'),
(1, 'RIMAC', 3, '2021/07/31 23:25:11'),
(1, 'TESLA', 4, '2021/07/31 23:25:11'),
(1, 'PAGANI', 5, '2021/07/31 23:25:11'),
(1, 'LOTUS', 6, '2021/07/31 23:25:11'),
(1, 'MERCEDES BENZ', 7, '2021/07/31 23:25:11'),
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
