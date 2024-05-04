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
-- Table structure for table `bookcopy`
--

DROP TABLE IF EXISTS `bookcopy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookcopy` (
  `copy_id` int NOT NULL,
  `book_id` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`copy_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `bookcopy_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcopy`
--

LOCK TABLES `bookcopy` WRITE;
/*!40000 ALTER TABLE `bookcopy` DISABLE KEYS */;
INSERT INTO `bookcopy` VALUES (1,1,'Available'),(2,1,'Available'),(3,1,'Available'),(4,1,'Available'),(5,1,'Available'),(6,1,'Not Available'),(7,1,'Not Available'),(8,2,'Available'),(9,2,'Available'),(10,2,'Available'),(11,2,'Available'),(12,2,'Available'),(13,2,'Available'),(14,2,'Available'),(15,2,'Available'),(16,2,'Not Available'),(17,3,'Available'),(18,3,'Available'),(19,3,'Available'),(20,3,'Not Available'),(21,3,'Not Available'),(22,4,'Available'),(23,4,'Available'),(24,4,'Available'),(25,4,'Available'),(26,4,'Available'),(27,4,'Available'),(28,4,'Not Available'),(29,4,'Not Available'),(30,5,'Available'),(31,5,'Available'),(32,5,'Available'),(33,5,'Available'),(34,5,'Available'),(35,5,'Available'),(36,5,'Available'),(37,5,'Not Available'),(38,5,'Not Available'),(39,5,'Not Available'),(40,6,'Available'),(41,6,'Available'),(42,6,'Available'),(43,6,'Available'),(44,6,'Not Available'),(45,6,'Not Available'),(46,7,'Available'),(47,7,'Available'),(48,7,'Available'),(49,7,'Available'),(50,7,'Available'),(51,7,'Available'),(52,7,'Available'),(53,7,'Available'),(54,7,'Available'),(55,7,'Available'),(56,8,'Available'),(57,8,'Available'),(58,8,'Available'),(59,8,'Available'),(60,8,'Available'),(61,8,'Available'),(62,8,'Available'),(63,8,'Not Available'),(64,8,'Not Available'),(65,8,'Not Available'),(66,9,'Available'),(67,9,'Available'),(68,9,'Available'),(69,9,'Available'),(70,9,'Available'),(71,9,'Not Available'),(72,9,'Not Available'),(73,9,'Not Available'),(74,10,'Not Available'),(75,10,'Available'),(76,10,'Available'),(77,10,'Not Available'),(78,11,'Not Available'),(79,15,'Available'),(80,25,'Available'),(81,28,'Not Available'),(82,31,'Not Available');
/*!40000 ALTER TABLE `bookcopy` ENABLE KEYS */;
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
