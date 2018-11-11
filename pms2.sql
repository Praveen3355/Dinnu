-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: pms
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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `company` (
  `company_id` varchar(255) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('HAR','Hardward'),('LIC','LifeInsuranceCorp'),('SBI','StateBank'),('VOY','Voyage');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hint`
--

DROP TABLE IF EXISTS `hint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hint` (
  `hint_id` int(11) NOT NULL,
  `hint_des` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hint`
--

LOCK TABLES `hint` WRITE;
/*!40000 ALTER TABLE `hint` DISABLE KEYS */;
INSERT INTO `hint` VALUES (1,'What is your Fathers Name?'),(2,'What is your Pets Name?'),(3,'What is your Mothers Name?'),(4,'Who is your favourite actor Name?'),(5,'What is your school name\"');
/*!40000 ALTER TABLE `hint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainuser`
--

DROP TABLE IF EXISTS `mainuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mainuser` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `employer` varchar(255) DEFAULT NULL,
  `employer_type` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `pan_no` varchar(255) DEFAULT NULL,
  `passcode` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL,
  `hint_hint_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_l6g3stnr31mpfmmla1wyq0i2r` (`pan_no`),
  KEY `FKwsa2utajeypjbnsgrwqj8y4r` (`hint_hint_id`),
  CONSTRAINT `FKwsa2utajeypjbnsgrwqj8y4r` FOREIGN KEY (`hint_hint_id`) REFERENCES `hint` (`hint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainuser`
--

LOCK TABLES `mainuser` WRITE;
/*!40000 ALTER TABLE `mainuser` DISABLE KEYS */;
INSERT INTO `mainuser` VALUES ('A-001','Velachary-Chennai','9834526748','1992-12-24 00:00:00','praveen.dhanasekhar2gmail.com','Cognizant','Private','Praveen','Male','Dhasekhar','BDIPD6273D','Dhasekhar','Btech',25000,1),('B-001','Adayar-Chennai','9834599291','1992-10-02 00:00:00','gowtham.purushoth@gmail.com','Insurance','Govt','Gowtham','Male','Purushoth','ADFGT56430','Bonjo','Btech',70000,2),('C-001','Kota-Rajashtan','8672378819','1985-08-12 00:00:00','priya.singham@gmail.com','NULL','Self-Employeed','Priya','Female','Singh','FDSPS2357S','Boggy','MS',125000,3),('D-001','Jamshedpur-Rajasthan','8672378757','1995-12-19 00:00:00','shanshank.pathak@gmail.com','Cognizant','Private','Shashank','Male','Pathak','FDSPS5673S','Shalini','MBA',300000,4);
/*!40000 ALTER TABLE `mainuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `bill_id` varchar(255) NOT NULL,
  `bill_date` datetime DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `fine` double DEFAULT NULL,
  `paid_amt` double DEFAULT NULL,
  `user_user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `FKrl3xo4ts3l37n1uk3vueephdh` (`user_user_id`),
  CONSTRAINT `FKrl3xo4ts3l37n1uk3vueephdh` FOREIGN KEY (`user_user_id`) REFERENCES `mainuser` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('HAR-VL-001-ON-001','2018-06-07 00:00:00','2018-10-07 00:00:00',0,500,'B-001'),('LIC-HL-001-WF-001','2018-01-05 00:00:00','2018-01-28 00:00:00',28,300,'C-001');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy_table`
--

DROP TABLE IF EXISTS `policy_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `policy_table` (
  `policy_id` varchar(255) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `interest` double DEFAULT NULL,
  `initial_deposit` double DEFAULT NULL,
  `policy_name` varchar(255) DEFAULT NULL,
  `policy_type` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `term_amount` int(11) DEFAULT NULL,
  `terms_per_year` int(11) DEFAULT NULL,
  `company_company_id` varchar(255) DEFAULT NULL,
  `type_typeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`policy_id`),
  KEY `FK8on2qfh0g89t5i0cfjp1is38n` (`company_company_id`),
  KEY `FK4fmbo7g9mhej3xy86yhsk4i22` (`type_typeid`),
  CONSTRAINT `FK4fmbo7g9mhej3xy86yhsk4i22` FOREIGN KEY (`type_typeid`) REFERENCES `usertype` (`typeid`),
  CONSTRAINT `FK8on2qfh0g89t5i0cfjp1is38n` FOREIGN KEY (`company_company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy_table`
--

LOCK TABLES `policy_table` WRITE;
/*!40000 ALTER TABLE `policy_table` DISABLE KEYS */;
INSERT INTO `policy_table` VALUES ('HAR-VL-0001',6,12,3000,'HardwardVehicle','A1','2018-01-10 00:00:00',500,3,'HAR',11),('LIC-HL-0001',4,9,1000,'LIC Health','B1','2017-03-07 00:00:00',300,3,'LIC',12),('SBI-RT-0001',7,13,2000,'SBIRetirement','C1','2019-05-08 00:00:00',500,4,'SBI',13),('VOY-CP-0001',5,8,1000,'VOYChildPlan','D1','2015-07-05 00:00:00',100,5,'VOY',14);
/*!40000 ALTER TABLE `policy_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_enrolled_policy`
--

DROP TABLE IF EXISTS `user_enrolled_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_enrolled_policy` (
  `id` int(11) NOT NULL,
  `enrolled_date` datetime DEFAULT NULL,
  `policy_policy_id` varchar(255) DEFAULT NULL,
  `user_user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfwoeva0m6hrgf6s8x3ymyq4ck` (`policy_policy_id`),
  KEY `FKf0slrf0n68yywhua3lnxfgpv8` (`user_user_id`),
  CONSTRAINT `FKf0slrf0n68yywhua3lnxfgpv8` FOREIGN KEY (`user_user_id`) REFERENCES `mainuser` (`user_id`),
  CONSTRAINT `FKfwoeva0m6hrgf6s8x3ymyq4ck` FOREIGN KEY (`policy_policy_id`) REFERENCES `policy_table` (`policy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_enrolled_policy`
--

LOCK TABLES `user_enrolled_policy` WRITE;
/*!40000 ALTER TABLE `user_enrolled_policy` DISABLE KEYS */;
INSERT INTO `user_enrolled_policy` VALUES (1,'2018-01-02 00:00:00','HAR-VL-0001','B-001'),(2,'2017-03-07 00:00:00','LIC-HL-0001','C-001');
/*!40000 ALTER TABLE `user_enrolled_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usertype` (
  `typeid` int(11) NOT NULL,
  `type_variable` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (11,'A'),(12,'B'),(13,'C'),(14,'D'),(15,'E');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-09 22:37:26
