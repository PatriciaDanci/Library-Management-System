-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `student_address` varchar(255) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Eleanor Thompson','eleanor_thompson@student.com','0712345678'),(2,'Oscar Palmer','oscar_palmer@student.com','0723456789'),(3,'Hazel Simmons','hazel_simmons@student.com','0734567890'),(4,'Leonard Turner','leonard_turner@student.com','0745678901'),(5,'Mia Fletcher','mia_fletcher@student.com','0756789012'),(6,'Silas Hawkins','silas_hawkins@student.com','0767890123'),(7,'Eva Hughes','eva_hughes@student.com','0778901234'),(8,'Malcolm Barnes','malcolm_barnes@student.com','0789012345'),(9,'Vivian Perry','vivian_perry@student.com','0790123456'),(10,'Kai Campbell','kai_campbell@student.com','0711234567'),(11,'Giselle Hunter','giselle_hunter@student.com','0722345678'),(12,'Ronan Scott','ronan_scott@student.com','0733456789'),(13,'Felicity Newman','felicity_newman@student.com','0744567890'),(14,'Winston Dean','winston_dean@student.com','0755678901'),(15,'Clara Barker','clara_barker@student.com','0766789012'),(16,'Dominic Floyd','dominic_floyd@student.com','0777890123'),(17,'Isabel Weaver','isabel_weaver@student.com','0788901234'),(18,'Ryder Reynolds','ryder_reynolds@student.com','0799012345'),(19,'Catalina Ortiz','catalina_ortiz@student.com','0710123456'),(20,'Jasper McLaughlin','jasper_mclaughlin@student.com','0721234567'),(21,'Emery Turner','emery_turner@student.com','0732345678'),(22,'Aurora Tucker','aurora_tucker@student.com','0743456789'),(23,'Damon Warren','damon_warren@student.com','0754567890'),(24,'Eliza Simmons','eliza_simmons@student.com','0765678901'),(25,'Reed Garcia','reed_garcia@student.com','0776789012'),(26,'Ivy Blackwell','ivy_blackwell@student.com','0787890123'),(27,'Desmond Flores','desmond_flores@student.com','0798901234'),(28,'Lucia Casey','lucia_casey@student.com','0709012345'),(29,'Gideon McMillan','gideon_mcmillan@student.com','0711234567'),(30,'Sylvie Bennett','sylvie_bennett@student.com','0722345678');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-15  3:25:29
