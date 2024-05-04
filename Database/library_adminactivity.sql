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
-- Table structure for table `adminactivity`
--

DROP TABLE IF EXISTS `adminactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminactivity` (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `admin_id` int DEFAULT NULL,
  `copy_id` int DEFAULT NULL,
  `activity_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `activity_date` date DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `admin_id` (`admin_id`),
  KEY `copy_id` (`copy_id`),
  CONSTRAINT `adminactivity_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`user_id`),
  CONSTRAINT `adminactivity_ibfk_2` FOREIGN KEY (`copy_id`) REFERENCES `bookcopy` (`copy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminactivity`
--

LOCK TABLES `adminactivity` WRITE;
/*!40000 ALTER TABLE `adminactivity` DISABLE KEYS */;
INSERT INTO `adminactivity` VALUES (1,1,6,'checkout','2023-12-15'),(2,1,7,'checkout','2023-12-15'),(3,1,16,'checkout','2023-12-15'),(4,5,20,'checkout','2023-12-16'),(5,5,21,'checkout','2023-12-16'),(6,9,28,'checkout','2023-12-17'),(7,9,29,'checkout','2023-12-17'),(8,9,37,'checkout','2023-12-17'),(9,7,38,'checkout','2023-12-21'),(10,7,39,'checkout','2023-12-21'),(11,7,44,'checkout','2023-12-21'),(12,7,45,'checkout','2023-12-21'),(13,10,63,'checkout','2023-12-23'),(14,10,64,'checkout','2023-12-23'),(15,4,65,'checkout','2023-12-24'),(16,2,71,'checkout','2023-12-29'),(17,3,72,'checkout','2023-12-30'),(18,6,73,'checkout','2024-01-06'),(19,6,77,'checkout','2024-01-06'),(20,6,78,'checkout','2024-01-06'),(21,6,79,'checkout','2024-01-06'),(22,6,80,'checkout','2024-01-06'),(23,6,81,'checkout','2024-01-06'),(24,6,82,'checkout','2024-01-06');
/*!40000 ALTER TABLE `adminactivity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-15  3:25:28
