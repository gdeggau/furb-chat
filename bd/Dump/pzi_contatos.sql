-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: pzi
-- ------------------------------------------------------
-- Server version	5.7.23

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
-- Table structure for table `contatos`
--

DROP TABLE IF EXISTS `contatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contatos` (
  `id_contato` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_vinculo` datetime DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `id_usuario_contato` bigint(20) DEFAULT NULL,
  `dt_inativacao` datetime DEFAULT NULL,
  `fl_ativo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_contato`),
  KEY `FKckehbdvs6wex8catlym2g781n` (`id_usuario`),
  KEY `FKmw8jkg4deugsg5p2qx25ct1e0` (`id_usuario_contato`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contatos`
--

LOCK TABLES `contatos` WRITE;
/*!40000 ALTER TABLE `contatos` DISABLE KEYS */;
INSERT INTO `contatos` VALUES (1,NULL,2,1,NULL,'\0'),(2,NULL,1,2,NULL,'\0'),(3,'2019-06-15 19:50:53',5,1,'2019-06-16 17:25:15','I'),(4,'2019-06-15 19:50:53',1,5,'2019-06-16 17:25:15','I'),(5,'2019-06-15 19:51:01',3,1,NULL,'A'),(6,'2019-06-15 19:51:01',1,3,NULL,'A'),(7,'2019-06-15 19:52:13',4,2,NULL,'A'),(8,'2019-06-15 19:52:13',2,4,NULL,'A'),(9,'2019-06-15 19:52:25',5,2,NULL,'A'),(10,'2019-06-15 19:52:25',2,5,NULL,'A'),(11,'2019-06-21 22:27:55',1,7,NULL,'A');
/*!40000 ALTER TABLE `contatos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-23 21:28:19
