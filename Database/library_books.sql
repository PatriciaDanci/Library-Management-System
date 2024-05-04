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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `book_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `available_copies` int DEFAULT NULL,
  `total_copies` int DEFAULT NULL,
  `publisher_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `publisher_id` (`publisher_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`publisher_id`),
  CONSTRAINT `books_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Great Gatsby','978-0-7432-7356-5',5,7,1,1),(2,'To Kill a Mockingbird','978-0-06-112008-4',8,9,2,2),(3,'1984','978-0-452-28423-4',3,5,3,3),(4,'Brave New World','978-0-06-085052-4',6,8,4,3),(5,'The Catcher in the Rye','978-0-316-76948-0',7,10,5,2),(6,'The Hobbit','978-0-261-10212-2',4,6,6,4),(7,'Harry Potter and the Sorcerer\'s Stone','978-0-7475-3269-6',10,10,7,5),(8,'The Lord of the Rings','978-0-261-10240-5',7,10,6,4),(9,'Pride and Prejudice','978-1-85326-000-0',5,8,8,1),(10,'The Shining','978-0-385-12167-5',2,4,9,2),(11,'Animal Farm','978-0-452-28423-4',0,1,3,8),(12,'War and Peace','978-0-19-923276-5',0,0,10,6),(13,'The Chronicles of Narnia','978-0-06-112008-4',0,0,11,5),(14,'The Great Expectations','978-0-14-143984-6',0,0,10,7),(15,'The Hitchhiker\'s Guide to the Galaxy','978-0-330-25864-7',1,1,11,3),(16,'Wuthering Heights','978-1-85326-001-7',0,0,4,6),(17,'Dracula','978-0-553-21079-0',0,0,5,7),(18,'Alice\'s Adventures in Wonderland','978-1-85326-000-0',0,0,1,4),(19,'One Hundred Years of Solitude','978-0-06-088328-7',0,0,6,6),(20,'Harry Potter and the Chamber of Secrets','978-0-439064873',0,0,1,5),(21,'The Cat in the Hat','978-0-394800011',0,0,2,9),(22,'Where the Wild Things Are','978-0-060254926',0,0,3,9),(23,'The Lightning Thief','978-0-786838653',0,0,4,13),(24,'Norse Mythology','978-0-393609097',0,0,5,13),(25,'The Song of Achilles','978-0-062060624',1,1,6,13),(26,'Harry Potter and the Prisoner of Azkaban','	‎978-0-590353427',0,0,1,5),(27,'Romeo and Juliet','978-0-743477116',0,0,8,6),(28,'The Notebook','978-0-552159970',0,1,9,6),(29,'P.S. I Love You','978-1-401308582',0,0,10,6),(30,'Sense and Sensibility','978-1612930885',0,0,11,6),(31,'The Fault in Our Stars','978-0525478812',0,1,1,6),(32,'13 Reasons Why','978-1-59514-788-2',0,0,6,15),(33,'Girl, Interrupted','978-0-679-75564-4',0,0,4,14),(34,'The Little Mermaid','978-396-372-00000',0,0,2,9),(35,'The Ugly Duckling','978-067-006-1778',0,0,2,9);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
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
