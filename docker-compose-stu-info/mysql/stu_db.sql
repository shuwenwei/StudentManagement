-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: stu_db
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` varchar(6) NOT NULL COMMENT '班级id',
  `number` varchar(2) NOT NULL COMMENT '班号',
  `maj_id` varchar(3) NOT NULL COMMENT '所属专业',
  `instructor` varchar(10) DEFAULT NULL COMMENT '所属辅导员id',
  `grade` varchar(4) NOT NULL COMMENT '年级',
  PRIMARY KEY (`id`),
  KEY `maj_id` (`maj_id`),
  KEY `class_ibfk_2` (`instructor`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`maj_id`) REFERENCES `major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`instructor`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES ('1','1','1','6104119053','2019'),('2','2','1','6104119053','2018'),('3','1','2','6104119053','2019');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_member`
--

DROP TABLE IF EXISTS `family_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family_member` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '家庭成员id',
  `user_id` varchar(10) NOT NULL COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `relation` varchar(10) NOT NULL COMMENT '关系',
  `job` varchar(20) NOT NULL COMMENT '工作',
  `telephone` varchar(15) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `family_member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_member`
--

LOCK TABLES `family_member` WRITE;
/*!40000 ALTER TABLE `family_member` DISABLE KEYS */;
INSERT INTO `family_member` VALUES (1,'6104119052','1aaaaa','string','string','1414124124'),(2,'6104119052','b','母','无','123'),(3,'6104119055','c','父','aa','124124');
/*!40000 ALTER TABLE `family_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute`
--

DROP TABLE IF EXISTS `institute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institute` (
  `id` varchar(3) NOT NULL COMMENT '学院id',
  `name` varchar(20) NOT NULL COMMENT '学院名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute`
--

LOCK TABLES `institute` WRITE;
/*!40000 ALTER TABLE `institute` DISABLE KEYS */;
INSERT INTO `institute` VALUES ('1','信息工程学院'),('2','机电工程学院');
/*!40000 ALTER TABLE `institute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `id` varchar(3) NOT NULL COMMENT '专业id',
  `name` varchar(20) NOT NULL COMMENT '专业名',
  `ins_id` varchar(3) NOT NULL COMMENT '所属学院id',
  PRIMARY KEY (`id`),
  KEY `major_ibfk_1` (`ins_id`),
  CONSTRAINT `major_ibfk_1` FOREIGN KEY (`ins_id`) REFERENCES `institute` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES ('1','电气工程及其自动化','1'),('11','major111','2'),('2','自动化','1');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu_info`
--

DROP TABLE IF EXISTS `stu_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu_info` (
  `id` varchar(10) NOT NULL COMMENT '学生id',
  `cls_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级id',
  `maj_id` varchar(3) DEFAULT NULL COMMENT '专业id',
  `ins_id` varchar(3) DEFAULT NULL COMMENT '学院id',
  `instructor` varchar(10) DEFAULT NULL COMMENT '辅导员id',
  PRIMARY KEY (`id`),
  KEY `instructor` (`instructor`),
  KEY `maj_id` (`maj_id`),
  KEY `cls_id` (`cls_id`),
  KEY `stu_info_ibfk_5` (`ins_id`),
  CONSTRAINT `stu_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `stu_info_ibfk_2` FOREIGN KEY (`instructor`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `stu_info_ibfk_3` FOREIGN KEY (`maj_id`) REFERENCES `class` (`maj_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_info_ibfk_4` FOREIGN KEY (`cls_id`) REFERENCES `class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `stu_info_ibfk_5` FOREIGN KEY (`ins_id`) REFERENCES `institute` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu_info`
--

LOCK TABLES `stu_info` WRITE;
/*!40000 ALTER TABLE `stu_info` DISABLE KEYS */;
INSERT INTO `stu_info` VALUES ('6104119052','1','1','1','6104119053'),('6104119055','1','1','1','6104119053'),('6104119056','2','1','1','6104119053'),('6104119057','1','1','1','6104119053');
/*!40000 ALTER TABLE `stu_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(10) NOT NULL COMMENT 'id',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` enum('instructor','admin','stu') NOT NULL DEFAULT 'stu' COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('6104119052','9f23844f705ceec957fe05d05fd0917a','stu'),('6104119053','9f23844f705ceec957fe05d05fd0917a','instructor'),('6104119054','password','admin'),('6104119055','123456','stu'),('6104119056','123456','stu'),('6104119057','123456','stu'),('6104119058','111111','instructor'),('6104119059','9f23844f705ceec957fe05d05fd0917a','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `id` varchar(10) NOT NULL COMMENT 'user_id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` enum('男','女') NOT NULL COMMENT '性别',
  `telephone` varchar(15) NOT NULL COMMENT '电话',
  `qq` varchar(11) NOT NULL COMMENT 'qq号',
  `we_chat` varchar(20) NOT NULL COMMENT '微信号',
  `id_card` varchar(17) NOT NULL COMMENT '身份证号',
  `province` varchar(20) NOT NULL COMMENT '省',
  `city` varchar(20) NOT NULL COMMENT '市',
  `address` varchar(30) NOT NULL COMMENT '详细住址',
  PRIMARY KEY (`id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('6104119052','sww2','男','13911111111','111111111','1111111','1111111111111111','jiangxi','xiny','1111111'),('6104119053','user2','男','12113','13134','13413','1343','jx','a','afeq'),('6104119055','user3','男','1111111','124124','12412','11111111','aa','aa','af');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-26 21:10:41
