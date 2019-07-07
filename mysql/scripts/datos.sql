CREATE DATABASE  IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `banco`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asesor`
--

DROP TABLE IF EXISTS `asesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `especialidad` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asesor`
--

LOCK TABLES `asesor` WRITE;
/*!40000 ALTER TABLE `asesor` DISABLE KEYS */;
INSERT INTO `asesor` VALUES (1,'Luz Estella Salazar','Cartera'),(2,'Alvaro Velez','Credito Hipotecario'),(3,'Maria Benitez','Creditos'),(7,'Claudia Restrepo','Analista Financiera'),(8,'Abelardo Gutierrez','Credito y Cartera'),(9,'Evan','Finanzas');
/*!40000 ALTER TABLE `asesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `telefono` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Mauricio Acevedo','Calle 26 # 43 - 23','Medellin',5101112),(2,'Ana Cristina','Carrera 2 # 36 - 21','Bogota',8242526),(3,'Julieta','Calle 10 # 10 - 12','Medellin',4263036),(4,'Son Goku','Calle 101 # 98 - 20','Medellin',62635);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumos`
--

DROP TABLE IF EXISTS `consumos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consumos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_consumo` datetime NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `monto` decimal(12,0) NOT NULL,
  `tarjeta_id` int(11) NOT NULL,
  `cuotas` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `consumos_fk0` (`tarjeta_id`),
  CONSTRAINT `consumos_fk0` FOREIGN KEY (`tarjeta_id`) REFERENCES `tarjetas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumos`
--

LOCK TABLES `consumos` WRITE;
/*!40000 ALTER TABLE `consumos` DISABLE KEYS */;
INSERT INTO `consumos` VALUES (1,'2019-02-01 08:23:23','COMPRA EXITO',150000,3,1),(2,'2019-06-01 18:23:23','ARTURO CALLE',2300000,2,36),(3,'2019-04-11 10:23:23','FALLABELA',528363,1,3),(4,'2019-07-06 11:23:23','ALKOMPRAR ONLINE',855238,4,10),(5,'2019-05-20 23:23:23','COMPRA EXITO',36250,2,1),(6,'2019-03-15 00:23:23','HAMBURGUESAS EL CORRAL',96330,3,1),(7,'2019-01-02 06:23:23','VIAJES ÉXITO',5210650,3,12),(8,'2019-07-04 20:23:23','TERPEL LA 33',75000,3,2);
/*!40000 ALTER TABLE `consumos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarjetas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_tarjeta` varchar(19) NOT NULL,
  `ccv` varchar(4) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `cliente` int(11) NOT NULL,
  `estado_tarjeta` varchar(10) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_expiracion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `asesor_bancario` int(11) DEFAULT NULL,
  `capacidad` decimal(10,0) NOT NULL DEFAULT '2000000',
  PRIMARY KEY (`id`),
  KEY `tarjetas_fk0` (`cliente`),
  KEY `tarjetas_fk1` (`asesor_bancario`),
  CONSTRAINT `tarjetas_fk0` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `tarjetas_fk1` FOREIGN KEY (`asesor_bancario`) REFERENCES `asesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
INSERT INTO `tarjetas` VALUES (1,'0001 2021 8081 9091','113','VISA',1,'ACTIVA','2018-07-05 22:06:06','2020-07-05 22:06:06',3,2000000),(2,'0002 1023 0085 2125','123','MASTERCARD',3,'ACTIVA','2019-01-05 22:20:16','2022-01-05 22:20:16',2,2000000),(3,'0011 1187 6672 4354','813','AMERICAN',2,'ACTIVA','2018-07-05 22:21:56','2020-07-05 22:21:56',1,2000000),(4,'8801 2346 0023 1150','915','VISA',4,'ACTIVA','2019-01-05 22:30:44','2021-01-05 22:30:44',1,2000000),(5,'9801 0012 1038 4566','389','AMERICAN',1,'ACTIVA','2018-12-05 22:30:44','2020-07-06 22:59:15',1,2000000);
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-07 10:09:38
