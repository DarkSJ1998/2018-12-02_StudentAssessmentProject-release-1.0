-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: projectdb
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(20) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `contactNo` bigint(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','password','Sarthak Jain',9034363307,'sarthakjn12@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursecode` varchar(10) NOT NULL,
  `title` char(30) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `studentid` int(11) NOT NULL,
  `marks` int(11) DEFAULT NULL,
  `dept` char(10) DEFAULT NULL,
  PRIMARY KEY (`coursecode`,`studentid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (7,'CSL3306','Software Engineering',3,1611981066,33,'CSE'),(9,'CSL3306','Software Engineering',3,1611981339,NULL,'CSE'),(10,'CSL5301','Java Programming',5,1611981250,40,'CSE'),(12,'CSL5301','Java Programming',5,1611981262,25,'CSE'),(4,'CSL5301','Java Programming',5,1611981328,28,'CSE'),(1,'CSL5301','Java Programming',5,1611981339,28,'CSE'),(5,'CSL5301','Java Programming',5,1611981429,NULL,'CSE'),(6,'CSL5305','Data Structures with Java',5,1611981066,39,'CSE'),(11,'CSL5305','Data Structures with Java',5,1611981250,NULL,'CSE'),(3,'CSL5305','Data Structures with Java',5,1611981328,38,'CSE'),(2,'CSL5305','Data Structures with Java',5,1611981339,39,'CSE');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fathersName` char(20) DEFAULT NULL,
  `mothersName` char(20) DEFAULT NULL,
  `contactNo` bigint(20) DEFAULT NULL,
  `dept` char(10) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (9,1611981066,'password','Ankit','ankit.joshi407@gmail.com','Kapil joshi','Sushma joshi',7015276595,'CSE'),(10,1611981250,'password','Nikhil Rana','nikhil@app.com','abc','def',1234567890,'CSE'),(11,1611981262,'123456789','Nitish Sharma','nitish691@gmail.com','Mr. abc Sharma','Mrs. def Sharma',1234567890,'CSE'),(6,1611981328,'password','Sahil Sood','sahilsood1597@gmail.com','abc','def',8295749694,'CSE'),(13,1611981335,'password','Sarbeshwar Singh','sarbeshwar@gmail.com','abc','def',1234567890,'CSE'),(1,1611981339,'password','Sarthak Jain','sarthakjn12@gmail.com','Mr. Manoj Jain','Mrs. Kshama Jain',9034363307,'CSE'),(8,1611981365,'123456789','Shubham Mishra','sassssaaa@gmail.com','asdass','asdxzas',2145785412,'CSE'),(7,1611981429,'password','Sonam Chopel','scbs@gmail.com','abc','def',1234567890,'CSE');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` varchar(10) NOT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contactNo` bigint(20) DEFAULT NULL,
  `dept` char(10) DEFAULT NULL,
  `coursecode` varchar(10) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'CU123','password','Aishwary Holkar','aholkar106@gmail.com',1234567890,'CSE','CSL5301'),(2,'CU456','password','Tazeen Khan','tazeen.khan@gmail.com',1234567890,'CSE','CSL5305');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-02 14:48:43
