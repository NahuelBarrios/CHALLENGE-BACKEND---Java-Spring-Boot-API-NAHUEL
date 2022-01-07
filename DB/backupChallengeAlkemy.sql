CREATE DATABASE  IF NOT EXISTS `disney` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `disney`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: disney
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `nombreGenero` varchar(255) DEFAULT NULL,
  `imagenGenero` varchar(255) DEFAULT NULL,
  `peliculaAsociada` int DEFAULT NULL,
  PRIMARY KEY (`idGenero`),
  KEY `peliculaAsociada_idx` (`peliculaAsociada`),
  CONSTRAINT `peliculaAsociada` FOREIGN KEY (`peliculaAsociada`) REFERENCES `peliculas` (`idPeliculas`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (2,'Dramatico','MickeyMouse.png',1);
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas` (
  `idPeliculas` int NOT NULL AUTO_INCREMENT,
  `imagenPeliculas` varchar(500) DEFAULT NULL,
  `tituloPeliculas` varchar(128) DEFAULT NULL,
  `fechaCreacion` int DEFAULT NULL,
  `calificacionPeliculas` int DEFAULT NULL,
  `personajesAsociados` int DEFAULT NULL,
  PRIMARY KEY (`idPeliculas`),
  UNIQUE KEY `idPeliculas_UNIQUE` (`idPeliculas`),
  KEY `personajesAsociados_idx` (`personajesAsociados`),
  CONSTRAINT `personajesAsociados` FOREIGN KEY (`personajesAsociados`) REFERENCES `personaje` (`idPersonaje`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (1,'MickeyMouse.png','mickey mouse y sus amigos',1980,4,7),(2,'MickeyMouse.png','mickey mouse y sus amigos 2',1990,5,7),(7,'DonaldDuck.png','Donald y sus amigos',1988,4,7);
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `idPersonaje` int NOT NULL AUTO_INCREMENT,
  `imagenPersonaje` varchar(500) DEFAULT NULL,
  `nombrePersonaje` varchar(45) DEFAULT NULL,
  `edadPersona` varchar(45) DEFAULT NULL,
  `pesoPersonaje` varchar(45) DEFAULT NULL,
  `historiaPersonaje` varchar(500) DEFAULT NULL,
  `peliculasAsociadasPersonaje` int DEFAULT NULL,
  PRIMARY KEY (`idPersonaje`),
  KEY `peliculasAsociadasPersonaje_idx` (`peliculasAsociadasPersonaje`),
  CONSTRAINT `peliculasAsociadasPersonaje` FOREIGN KEY (`peliculasAsociadasPersonaje`) REFERENCES `peliculas` (`idPeliculas`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (7,'MickeyMouse.png','mickey mouse','12','14','Mickey un raton amigable',2);
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  PRIMARY KEY (`idRol`),
  KEY `idUsuario_idx` (`idUsuario`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',2),(3,'ROLE_USER',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','$2a$10$PV5JuhNKKxsRsdPIDxGfUutMle7rHOd0wQPwtvoJdcB0incLnbW3y'),(2,'user','$2a$10$ipSKWFipTaxx5XQSwNrZWOUBmySX.J0q9xBe1H9lSuVRZPTrglrH.');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vistaquemetraetodo`
--

DROP TABLE IF EXISTS `vistaquemetraetodo`;
/*!50001 DROP VIEW IF EXISTS `vistaquemetraetodo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vistaquemetraetodo` AS SELECT 
 1 AS `idGenero`,
 1 AS `idPeliculas`,
 1 AS `idPersonaje`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'disney'
--

--
-- Dumping routines for database 'disney'
--
/*!50003 DROP PROCEDURE IF EXISTS `SPvistaquemetraetodo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SPvistaquemetraetodo`()
BEGIN
select * from genero as t1
join peliculas as t2
on t1.idGenero = t2.idPeliculas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vistaquemetraetodo`
--

/*!50001 DROP VIEW IF EXISTS `vistaquemetraetodo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vistaquemetraetodo` AS select `t1`.`idGenero` AS `idGenero`,`t2`.`idPeliculas` AS `idPeliculas`,`t3`.`idPersonaje` AS `idPersonaje` from ((`genero` `t1` join `peliculas` `t2` on((`t1`.`idGenero` = `t2`.`idPeliculas`))) join `personaje` `t3` on((`t1`.`idGenero` = `t3`.`idPersonaje`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-05 17:44:02
