CREATE DATABASE  IF NOT EXISTS `sistemaapartado` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `sistemaapartado`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemaapartado
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abonos`
--

DROP TABLE IF EXISTS `abonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abonos` (
  `idAbono` int(11) NOT NULL AUTO_INCREMENT,
  `abono_idProdApartado` int(11) NOT NULL,
  `fechaAbono` date NOT NULL,
  `abono` float NOT NULL,
  PRIMARY KEY (`idAbono`),
  KEY `abonos_ibfk_3` (`abono_idProdApartado`),
  CONSTRAINT `abonos_ibfk_3` FOREIGN KEY (`abono_idProdApartado`) REFERENCES `productoapartado` (`idProdApartado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonos`
--

LOCK TABLES `abonos` WRITE;
/*!40000 ALTER TABLE `abonos` DISABLE KEYS */;
INSERT INTO `abonos` VALUES (6,21,'2024-08-11',500000),(7,21,'2024-08-11',500000),(8,20,'2024-08-11',110),(9,23,'2024-08-11',100),(11,22,'2024-08-11',10),(13,25,'2024-08-11',110),(14,24,'2024-08-11',110),(15,22,'2024-08-11',100),(16,23,'2024-08-11',29),(17,26,'2024-08-12',90),(18,26,'2024-08-12',20),(19,27,'2024-08-12',200),(20,35,'2024-08-15',89),(21,49,'2024-08-15',400),(22,50,'2024-08-15',999),(23,49,'2024-08-15',216),(24,32,'2024-08-15',110),(25,33,'2024-08-15',99),(26,38,'2024-08-15',300),(27,52,'2024-08-15',220),(29,57,'2025-01-08',99),(30,59,'2025-01-08',700),(31,59,'2025-01-08',300),(32,57,'2025-02-05',0),(35,18,'2025-02-05',1),(38,69,'2025-02-05',99),(39,69,'2025-02-05',0),(40,69,'2025-02-06',0),(41,72,'2025-02-06',500),(42,72,'2025-02-06',500),(43,76,'2025-03-20',6);
/*!40000 ALTER TABLE `abonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCliente` varchar(60) NOT NULL,
  `EstadoCliente` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Juan Manuel Valdez Lerma',1),(2,'Miguel Angel Lopez Lopez',1),(3,'Roberto Guerra Perez',1),(6,'Uziel Isaac Larez Nuñez',1),(7,'Vladimir Reyes Lopez',0),(8,'Gael Bernal Salazar',1),(9,'Pablo Manuel Tiznado Ramirez',1),(10,'Emiliano Galeana Avila',1),(11,'Danielillo',1),(12,'Zyon Luis Aguirre Ibarra',1),(13,'Sebastian de Jesus Zatarain Sanchez',1),(14,'Suarez',0),(15,'panfilo',0),(16,'UzielitoMix',0),(17,'Christopher Castillo Herrera',1),(18,'Juancho',0),(19,'perron',0),(20,'juan2',0),(21,'Miguel Angel Lopez Lopez',0),(22,'Robert Smith',1),(23,'prueba',0),(24,'Danii',0),(25,'Oscar Vizcarra',1),(26,'Messi',0),(27,'Juan Manuel Valdez Lerma',1),(28,'Miguel Angel Lopez Lopez',0),(29,'Miguel Angel Lopez Lopez',0),(30,'Miguel Angel Lopez Lopez',0),(31,'Norma Monserrat Bustamante Laferte',1),(32,'papuh skibidi',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correoclientes`
--

DROP TABLE IF EXISTS `correoclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correoclientes` (
  `CorreoClientes_idClientes` int(11) NOT NULL,
  `CorreoClientes` varchar(60) DEFAULT NULL,
  KEY `CorreoClientes_idClientes` (`CorreoClientes_idClientes`),
  CONSTRAINT `correoclientes_ibfk_1` FOREIGN KEY (`CorreoClientes_idClientes`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correoclientes`
--

LOCK TABLES `correoclientes` WRITE;
/*!40000 ALTER TABLE `correoclientes` DISABLE KEYS */;
INSERT INTO `correoclientes` VALUES (6,'uziel@gmail.com'),(8,'gael@gmail.com'),(9,'pablo@gmail.com'),(3,'roberto@gmail.com'),(2,'miguel@gmail.com'),(11,'daniel@gmail.com'),(13,'sebas@gmail.com'),(14,'messi@gmail.com'),(14,'cristiano@gmail.com'),(15,'panfilo@gmail.com'),(16,'UzielitoMix@gmail.com'),(17,'christopher@gmail.com'),(18,'juanin@gmail.cow'),(7,'vladimir@gmail.com'),(19,'perro@gmail.com'),(20,'juan@hotmail.com'),(12,'123@#'),(22,'thecurerobert@gmail.com'),(10,'jorge'),(24,'DaniCORREO'),(25,'oscar@gmail..com'),(26,'neymar@gmail.com'),(30,'ada'),(31,'monlaferte@gmail.com'),(32,'skibidi@gmail.com');
/*!40000 ALTER TABLE `correoclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `NombreEmpleado` varchar(60) NOT NULL,
  `contraseña` varchar(60) DEFAULT NULL,
  `EstadoEmpleados` tinyint(1) DEFAULT NULL,
  `empleado_idTipo` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `NombreEmpleado_UNIQUE` (`NombreEmpleado`),
  KEY `referencia_idtipo` (`empleado_idTipo`),
  CONSTRAINT `referencia_idtipo` FOREIGN KEY (`empleado_idTipo`) REFERENCES `tipoempleado` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'GUILLERMO','cisco',1,1),(2,'Juan','cisco',1,2),(3,'miguel','cisco',1,2),(4,'dani','cisco',1,2),(6,'Zyon','cisco',1,2),(11,'Panchito','cisco',1,2),(13,'messi','cisco',0,2),(14,'papu','cisco',0,2),(18,'lol','cisco',0,1),(21,'epic','cisco',0,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoapartado`
--

DROP TABLE IF EXISTS `productoapartado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoapartado` (
  `idProdApartado` int(11) NOT NULL AUTO_INCREMENT,
  `Apartado_idReserva` int(11) NOT NULL,
  `Apartado_idProducto` varchar(18) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idProdApartado`),
  KEY `Apartado_idReserva` (`Apartado_idReserva`),
  KEY `Apartado_idProducto` (`Apartado_idProducto`),
  CONSTRAINT `productoapartado_ibfk_1` FOREIGN KEY (`Apartado_idReserva`) REFERENCES `ticketreserva` (`idReserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productoapartado_ibfk_2` FOREIGN KEY (`Apartado_idProducto`) REFERENCES `productos` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoapartado`
--

LOCK TABLES `productoapartado` WRITE;
/*!40000 ALTER TABLE `productoapartado` DISABLE KEYS */;
INSERT INTO `productoapartado` VALUES (1,2,'9786075280325',1),(2,2,'9786075280400',2),(3,4,'9786075280325',2),(4,4,'602557130317',2),(5,5,'9786075280400',1),(6,6,'602557130317',1),(7,6,'9786075280325',1),(8,6,'9786075280400',1),(9,7,'602557130317',1),(10,8,'602557130317',1),(11,12,'602557130317',1),(12,13,'9786075280325',1),(13,14,'602557130317',1),(14,44,'123',1),(15,45,'123',1),(16,49,'123',1),(17,50,'123',1),(18,51,'123',1),(19,53,'123',1),(20,58,'123',1),(21,58,'123456789',1),(22,59,'123',1),(23,59,'602557130317',1),(24,61,'123',1),(25,62,'123',1),(26,63,'123',1),(27,63,'456',1),(32,66,'123',1),(33,66,'222',1),(35,66,'333',1),(38,66,'789',1),(40,67,'555',1),(49,75,'616',1),(50,75,'444',1),(52,76,'123',2),(57,77,'100',1),(58,77,'123',2),(59,77,'111',1),(60,77,'222',1),(61,77,'333',1),(62,78,'777',1),(64,78,'111',1),(69,79,'100',1),(70,79,'123',1),(71,80,'777',1),(72,82,'777',2),(73,82,'111',1),(74,82,'333',1),(76,83,'666',1);
/*!40000 ALTER TABLE `productoapartado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` varchar(18) NOT NULL,
  `Productos_idTipo` int(11) NOT NULL,
  `NombreProducto` varchar(50) NOT NULL,
  `Descripcion` varchar(80) DEFAULT NULL,
  `Precio` float NOT NULL,
  `FechaLanzamiento` date DEFAULT NULL,
  `EstadoProductos` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `Productos_idTipo` (`Productos_idTipo`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`Productos_idTipo`) REFERENCES `tipoproducto` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('100',1,'Oyasumi Punpun Vol.2','Oyasumi!',99,'2007-03-15',1),('10001',1,'Jujutsu Kaisen Vol 8','Jujutsu',129,NULL,0),('1010',4,'Twin Fantasy (FtF)','Car Seat Headrest 2018',750,NULL,1),('111',5,'TLOZ Breath of the Wild','Juego para Nintendo Switch',1000,NULL,1),('123',1,'Oyasumi Punpun Vol. 1','man',110,NULL,1),('1234',5,'Persona 4 Golden','Version de Nintendo Switch',1000,NULL,1),('123456789',2,'El Libro Fornite','Fornite Battle Pass',1000000,NULL,1),('222',1,'HunterXHunter Vol.1','manga bien',99,NULL,1),('333',1,'Jujutsu Kaisen tomo 24','Nah I\'d Win poster',89,NULL,1),('444',9,'Rei Fumo','Neon Genesis Evangelion plush',999,NULL,1),('445',9,'Pen Pen EVA','NGE',654,NULL,1),('452',4,'Weezer Weezer','blue!',750,NULL,1),('456',3,'Camisa Gorillaz!','demon days!',200,NULL,1),('555',1,'Jujutsu Kaisen Vol.25','chapter 423 jujutsu kaisen!',109,NULL,1),('5552',1,'hamood','qq',12,NULL,0),('602557130317',2,'Mon Laferte Vol. 1','Mon Laferte',129,NULL,1),('616',5,'h','',6,NULL,0),('666',5,'Hello Neighbor','tinyBuild',666,NULL,1),('678',3,'Fortnite Playera Llama','Camisa para todos',350,NULL,1),('777',9,'Enderman Minecraft','Peluche',500,NULL,1),('789',2,'AM','Artic Monkeys CD',300,NULL,1),('896786',1,'dfg','gd',12.7,NULL,0),('9786075280325',2,'dragon ball','Tomo 2 Super',199,NULL,1),('9786075280400',1,'One Piece 3','Tomo 3 One Piece',99,NULL,1),('999',6,'Hollow Knight Pin','Pin del Caballero',300,NULL,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonoclientes`
--

DROP TABLE IF EXISTS `telefonoclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonoclientes` (
  `TelefonoClientes_idClientes` int(11) NOT NULL,
  `NumTelefonoClientes` varchar(21) DEFAULT NULL,
  KEY `TelefonoClientes_idClientes` (`TelefonoClientes_idClientes`),
  CONSTRAINT `telefonoclientes_ibfk_1` FOREIGN KEY (`TelefonoClientes_idClientes`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonoclientes`
--

LOCK TABLES `telefonoclientes` WRITE;
/*!40000 ALTER TABLE `telefonoclientes` DISABLE KEYS */;
INSERT INTO `telefonoclientes` VALUES (6,'6691172585'),(8,'6699321609'),(9,'699321611'),(10,'6699321612'),(11,'6699321613'),(13,'6699322252'),(14,'10101010'),(15,'66923555'),(16,'6691172585'),(17,'0000001'),(18,'666 666 666'),(19,'123-gua'),(20,'12'),(1,'6699321605'),(12,'6691'),(11,'55 9225 5994'),(24,'6868686868'),(25,'19410'),(3,'6695331815'),(26,'3591326'),(30,'da'),(31,'6699844590'),(32,'669');
/*!40000 ALTER TABLE `telefonoclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketreserva`
--

DROP TABLE IF EXISTS `ticketreserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketreserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `Reserva_idCliente` int(11) NOT NULL,
  `Reserva_idEmpleado` int(11) NOT NULL,
  `FechaApartado` date NOT NULL,
  `EstadoTicket` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `Reserva_idCliente` (`Reserva_idCliente`),
  KEY `Reserva_idEmpleado` (`Reserva_idEmpleado`),
  CONSTRAINT `ticketreserva_ibfk_1` FOREIGN KEY (`Reserva_idCliente`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ticketreserva_ibfk_2` FOREIGN KEY (`Reserva_idEmpleado`) REFERENCES `empleados` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketreserva`
--

LOCK TABLES `ticketreserva` WRITE;
/*!40000 ALTER TABLE `ticketreserva` DISABLE KEYS */;
INSERT INTO `ticketreserva` VALUES (1,23,1,'2024-06-29',0),(2,1,1,'2024-06-29',1),(3,9,1,'2024-08-03',1),(4,3,1,'2024-08-05',1),(5,10,1,'2024-08-05',1),(6,11,1,'2024-08-05',1),(7,13,1,'2024-08-06',1),(8,7,1,'2024-08-06',1),(9,1,1,'2024-08-07',1),(10,14,1,'2024-08-07',1),(11,14,1,'2024-08-07',1),(12,15,1,'2024-08-08',1),(13,16,1,'2024-08-08',1),(14,3,1,'2024-08-08',1),(15,7,1,'2024-08-09',1),(16,1,1,'2024-08-09',1),(17,6,1,'2024-08-09',1),(18,17,2,'2024-08-10',1),(19,1,2,'2024-08-10',1),(20,19,2,'2024-08-10',1),(21,18,2,'2024-08-10',1),(22,1,2,'2024-08-10',1),(23,1,2,'2024-08-10',1),(24,3,2,'2024-08-10',1),(25,7,2,'2024-08-10',1),(26,1,2,'2024-08-10',1),(27,19,1,'2024-08-10',1),(28,1,1,'2024-08-10',1),(29,1,1,'2024-08-10',1),(30,17,1,'2024-08-10',1),(31,1,1,'2024-08-10',1),(32,2,3,'2024-08-10',1),(33,3,3,'2024-08-10',1),(34,3,3,'2024-08-10',1),(35,3,3,'2024-08-10',1),(36,6,3,'2024-08-10',1),(37,7,3,'2024-08-10',1),(38,2,1,'2024-08-10',1),(39,1,3,'2024-08-10',1),(40,1,3,'2024-08-10',1),(41,2,3,'2024-08-10',1),(42,3,3,'2024-08-10',1),(43,1,1,'2024-08-10',1),(44,2,1,'2024-08-10',1),(45,1,1,'2024-08-10',1),(46,1,3,'2024-08-10',1),(47,2,3,'2024-08-10',1),(48,9,3,'2024-08-10',1),(49,7,2,'2024-08-10',1),(50,2,1,'2024-08-11',1),(51,10,1,'2024-08-11',1),(52,1,1,'2024-08-11',1),(53,22,1,'2024-08-11',1),(54,8,1,'2024-08-11',1),(55,1,1,'2024-08-11',1),(56,6,1,'2024-08-11',1),(57,2,2,'2024-08-11',1),(58,1,1,'2024-08-11',1),(59,6,1,'2024-08-11',1),(60,9,1,'2024-08-11',1),(61,10,1,'2024-08-11',1),(62,14,1,'2024-08-11',1),(63,3,1,'2024-08-12',1),(64,2,1,'2024-08-12',1),(65,1,3,'2024-08-13',1),(66,1,3,'2024-08-15',1),(67,11,1,'2024-08-15',1),(68,6,2,'2024-08-15',1),(69,1,2,'2024-08-15',1),(70,10,2,'2024-08-15',1),(71,1,1,'2024-08-15',1),(72,1,2,'2024-08-15',1),(73,10,6,'2024-08-15',1),(74,3,1,'2024-08-15',1),(75,1,1,'2024-08-15',1),(76,3,1,'2024-08-15',1),(77,10,1,'2025-01-08',1),(78,10,1,'2025-01-27',1),(79,1,1,'2025-02-05',1),(80,1,1,'2025-02-06',1),(81,3,1,'2025-02-06',1),(82,2,1,'2025-02-06',1),(83,1,1,'2025-03-13',1),(84,2,1,'2025-03-20',1);
/*!40000 ALTER TABLE `ticketreserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoempleado`
--

DROP TABLE IF EXISTS `tipoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoempleado` (
  `idTipo` int(11) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoempleado`
--

LOCK TABLES `tipoempleado` WRITE;
/*!40000 ALTER TABLE `tipoempleado` DISABLE KEYS */;
INSERT INTO `tipoempleado` VALUES (1,'Gerente',1),(2,'Empleado',1);
/*!40000 ALTER TABLE `tipoempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoproducto` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `NombreTipo` varchar(40) NOT NULL,
  `EstadoTipoProducto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` VALUES (1,'Manga',1),(2,'CD',1),(3,'Playera',1),(4,'Vinilo',1),(5,'Juego',1),(6,'pin',1),(8,'Poster',1),(9,'Peluche',1),(10,'Vinilo',1),(11,'-',1),(12,'Manga',1);
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sistemaapartado'
--
/*!50003 DROP FUNCTION IF EXISTS `calcular_cambio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `calcular_cambio`(saldoIngresado DECIMAL(10,2), saldoGuardado DECIMAL(10,2)) RETURNS decimal(10,2)
BEGIN
    DECLARE cambio DECIMAL(10,2);

    IF saldoIngresado > saldoGuardado THEN
        SET cambio = saldoIngresado - saldoGuardado;
    ELSE
        SET cambio = 0;
    END IF;

    RETURN cambio;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `obtener_idReserva` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `obtener_idReserva`() RETURNS int(11)
BEGIN
	DECLARE id int;
	SET id = (SELECT idReserva FROM ticketreserva ORDER BY idReserva DESC
	Limit 1);
RETURN id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `obtener_idTicket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `obtener_idTicket`() RETURNS int(11)
BEGIN
	DECLARE id int;
	SET id = (SELECT idReserva FROM ticketreserva ORDER BY idReserva DESC
	Limit 1);
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `actualizarCantidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `actualizarCantidad`(in idRes int, idPro VARCHAR(15))
BEGIN
    UPDATE productoapartado
    SET Cantidad = Cantidad + 1
    WHERE Apartado_idProducto = IdPro AND Apartado_idReserva = IdRes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agregar_correo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `agregar_correo`(in idCli int, corr varchar(60))
BEGIN
	INSERT INTO correoclientes VALUES (idCli, corr);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agregar_telefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `agregar_telefono`(in idCli int, tel varchar(21))
BEGIN
	INSERT INTO telefonoclientes VALUES (idCli, tel);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `buscar_cliente`(in nomCli varchar(60))
BEGIN
	SELECT idCliente as Id, NombreCliente as Nombre FROM CLIENTES
	WHERE NombreCliente LIKE CONCAT(nomCli,'%') AND EstadoCliente=1 ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `buscar_empleado`(in nombre VARCHAR(60))
BEGIN
	SELECT idEmpleado, NombreEmpleado,empleado_idTipo, tipo FROM empleados as e
	JOIN tipoempleado as te ON e.empleado_idTipo = te.idTipo
    WHERE NombreEmpleado LIKE CONCAT(nombre,"%") AND EstadoEmpleados = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `buscar_producto`(in nomPro varchar(50))
BEGIN
	SELECT idProducto as Id, NombreProducto as Nombre, Descripcion, tp.NombreTipo as Tipo, Precio
	FROM productos as p
	JOIN tipoproducto as tp ON p.Productos_idTipo = tp.idTipo
	WHERE NombreProducto LIKE CONCAT(nomPro,'%') AND EstadoProductos = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_producto_apartado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_producto_apartado`(IN id INT)
BEGIN
    SELECT 
        pa.idProdApartado, -- Agregado para que coincida con el código Java
        p.NombreProducto, 
        p.idProducto, 
        p.precio, 
        pa.cantidad, 
        p.precio * pa.cantidad AS total, 
        (p.precio * pa.cantidad - COALESCE(sa.total_abonos, 0)) AS saldo
    FROM 
        productoapartado AS pa
    JOIN 
        productos AS p ON pa.Apartado_idProducto = p.idProducto
    LEFT JOIN (
        SELECT 
            pa2.idProdApartado,
            SUM(a.abono) AS total_abonos
        FROM 
            abonos AS a
        JOIN 
            productoapartado AS pa2 ON a.abono_idProdApartado = pa2.idProdApartado
        WHERE 
            pa2.Apartado_idReserva = id
        GROUP BY 
            pa2.idProdApartado
    ) AS sa ON sa.idProdApartado = pa.idProdApartado
    WHERE 
        pa.Apartado_idReserva = id
    GROUP BY 
        pa.idProdApartado, -- Agregado para garantizar que se agrupe por esta columna
        p.NombreProducto, 
        p.idProducto, 
        p.precio, 
        pa.cantidad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `comprobar_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `comprobar_usuario`()
BEGIN
	SELECT IdEmpleado, NombreEmpleado, contraseña, empleado_idTipo, Tipo FROM empleados
    JOIN tipoempleado ON idTipo = empleado_idTipo where EstadoEmpleados=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consultaParamsTabla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultaParamsTabla`(in tableName VARCHAR(30))
BEGIN
    SET @sql = CONCAT('DESC ', tableName); -- Construye la consulta como una cadena
    PREPARE stmt FROM @sql;               -- Prepara la consulta
    EXECUTE stmt;                         -- Ejecuta la consulta
    DEALLOCATE PREPARE stmt;              -- Libera los recursos de la consulta preparada
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consultaTablas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consultaTablas`()
BEGIN
	SHOW TABLES;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_abonos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `consulta_abonos`(in idRes int)
BEGIN
	SELECT idAbono, Apartado_idProducto as idProd, NombreProducto as nombre, fechaAbono as fecha, abono 
FROM abonos
JOIN productoapartado ON abono_idProdApartado = idProdApartado
JOIN productos ON idProducto = Apartado_idProducto
WHERE Apartado_idReserva = idRes;  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_apartados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consulta_apartados`()
BEGIN
    SELECT 
        t.idReserva AS ID,
        c.NombreCliente AS CLIENTE,
        t.FechaApartado AS FECHA,
        CONCAT('$', FORMAT(SUM(p.precio * pa.cantidad), 2)) AS TOTAL,
        CONCAT('$', FORMAT(
            SUM(p.precio * pa.cantidad) - COALESCE(
                (SELECT SUM(a.abono)
                 FROM abonos AS a
                 JOIN productoapartado AS pa2 ON a.abono_idProdApartado = pa2.idProdApartado
                 WHERE pa2.Apartado_idReserva = t.idReserva), 0), 2)) AS SALDO
    FROM ticketreserva AS t
    JOIN clientes AS c ON t.Reserva_idCliente = c.idCliente
    LEFT JOIN productoapartado AS pa ON t.idReserva = pa.Apartado_idReserva
    LEFT JOIN productos AS p ON pa.Apartado_idProducto = p.idProducto
    WHERE c.EstadoCliente = 1
    GROUP BY t.idReserva, c.NombreCliente, t.FechaApartado
    HAVING SUM(p.precio * pa.cantidad) - COALESCE(
        (SELECT SUM(a.abono)
         FROM abonos AS a
         JOIN productoapartado AS pa2 ON a.abono_idProdApartado = pa2.idProdApartado
         WHERE pa2.Apartado_idReserva = t.idReserva), 0) != 0
    ORDER BY t.idReserva DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_correo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `consulta_correo`(in nombre varchar(60))
BEGIN
	SELECT c.NombreCliente, cc.CorreoClientes as correo FROM correoclientes as cc
	JOIN clientes as c ON c.idCliente = cc.CorreoClientes_idClientes
	WHERE NombreCliente = nombre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_numero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `consulta_numero`(in nombre varchar(60))
BEGIN
	SELECT c.NombreCliente, tc.NumTelefonoClientes as telefono FROM telefonoclientes as tc
	JOIN clientes as c ON c.idCliente = tc.TelefonoClientes_idClientes
	WHERE NombreCliente = nombre;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `consulta_tipo_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `consulta_tipo_empleado`()
BEGIN
	SELECT idTipo as id, Tipo as nombre FROM tipoempleado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_abono`(in idAbo int)
BEGIN
	DELETE FROM abonos 
    WHERE idAbono = idAbo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_cliente`(in idCli int)
BEGIN
    UPDATE clientes set EstadoCliente = 0 WHERE idCliente = idCli;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_correo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_correo`(in idCli int, correo varchar(60))
BEGIN
	DELETE FROM correoclientes WHERE CorreoClientes_idClientes = idCli AND CorreoClientes = correo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_empleado`(in idEmp int)
BEGIN
	UPDATE empleados SET EstadoEmpleados = 0 WHERE idEmpleado = idEmp;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_producto`(in idPro varchar(18))
BEGIN
	UPDATE productos set EstadoProductos = 0 WHERE idProducto = idPro;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_producto_apartado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_producto_apartado`(in idRes int, idPro varchar(18))
BEGIN
	DECLARE cant int;
	SELECT cantidad INTO cant
    FROM productoapartado
    WHERE Apartado_idReserva = idRes
    AND Apartado_idProducto = idPro;
	
    IF cant = 1 THEN
		DELETE FROM productoapartado
		WHERE Apartado_idReserva = idRes
		AND Apartado_idProducto = idPro;
	ELSE
		UPDATE productoapartado
        SET cantidad = cantidad - 1
        WHERE Apartado_idReserva = idRes
        AND Apartado_idProducto = idPro;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_telefono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `eliminar_telefono`(in idCli int, telefono varchar(60))
BEGIN
	DELETE FROM telefonoclientes WHERE TelefonoClientes_idClientes = idCli AND NumTelefonoClientes = telefono;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_ticket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_ticket`(in idRes int)
BEGIN
	-- Eliminar la consulta
    DELETE FROM ticketreserva WHERE idReserva = idRes;
    -- Reasignar el id default del ticket
    SET @sql = CONCAT('ALTER TABLE ticketreserva AUTO_INCREMENT = ', idRes);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `insercion_abono`(in idPro int, fecha date, abono float)
BEGIN
	INSERT INTO abonos VALUES (default,idPro, fecha, abono);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_cliente_datos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `insercion_cliente_datos`(in nombre varchar(60), correo varchar(60), telefono varchar(21))
BEGIN
	DECLARE idCli INT;
	-- Insertar cliente
	INSERT INTO clientes VALUES (default, nombre, 1);
    -- Obtener id del cliente
    SELECT idCliente INTO idCli
    FROM clientes
    WHERE NombreCliente = nombre;
	-- Insertar correo
    IF correo IS NOT NULL AND correo != '' THEN
    INSERT INTO correoclientes (CorreoClientes_idClientes, CorreoClientes)
    VALUES (idCli, correo);
    END IF;
    -- Insertar telefono
    IF telefono IS NOT NULL AND telefono != '' THEN
    INSERT INTO telefonoclientes (TelefonoClientes_idClientes, NumTelefonoClientes)
    VALUES (idCli, telefono);
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `insercion_empleado`(in nom varchar(60), con varchar(60), tipo int)
BEGIN
	INSERT INTO empleados VALUES
    (default, nom, con, 1, tipo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_producto_datos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `insercion_producto_datos`(in codigo varchar(18), nombre varchar(50), descripcion varchar(80),idTipo int, precio float, fecha date)
BEGIN
	INSERT INTO productos VALUES (
    codigo, idTipo, nombre, descripcion, precio, fecha, 1
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_p_apartado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `insercion_p_apartado`(in idRes int, idPro varchar(15), cant int)
BEGIN
	    -- Verifica si el registro ya existe en la reserva
    IF EXISTS (SELECT 1 FROM productoapartado 
               WHERE Apartado_idProducto = idPro 
                 AND Apartado_idReserva = idRes) THEN
        -- Si el registro existe, actualiza la cantidad
        UPDATE productoapartado
        SET Cantidad = Cantidad + cant
        WHERE Apartado_idProducto = idPro 
          AND Apartado_idReserva = idRes;
    ELSE
        -- Si el registro no existe, inserta un nuevo registro
        INSERT INTO productoapartado (idProdApartado, Apartado_idReserva, Apartado_idProducto, Cantidad)
        VALUES (default, idRes, idPro, cant);
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_ticket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `insercion_ticket`(in idCli int, idEmp int, fecha date)
BEGIN
	INSERT INTO ticketreserva VALUES (default, idCli , idEmp, fecha, 1);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insercion_tipo_producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insercion_tipo_producto`(in nom VARCHAR(40))
BEGIN
	INSERT INTO tipoproducto VALUES (default, nom, 1);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificar_cliente_datos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `modificar_cliente_datos`(in idCli int, nombre varchar(60))
BEGIN
	UPDATE clientes SET NombreCliente = nombre
    WHERE idCliente = idCli;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificar_producto_datos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`gerente-ds`@`localhost` PROCEDURE `modificar_producto_datos`(in codigo varchar(18), nombre varchar(50), descripcion varchar(80),idTipo int, precio float, fecha date)
BEGIN
	UPDATE productos
    set Productos_idTipo = idTipo, NombreProducto = nombre,Descripcion = descripcion,Precio = precio, FechaLanzamiento = fecha
    WHERE idProducto = codigo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtenerNombre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`empleado-ds`@`localhost` PROCEDURE `obtenerNombre`(in idRes int)
BEGIN
	SELECT NombreCliente
    FROM ticketreserva
	JOIN clientes ON idCliente = Reserva_idCliente
	WHERE idReserva = idRes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-25  9:45:55
