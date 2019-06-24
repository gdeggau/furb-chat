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
-- Table structure for table `grupos_usuarios`
--

DROP TABLE IF EXISTS `grupos_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupos_usuarios` (
  `id_grupos_usuarios` bigint(20) NOT NULL AUTO_INCREMENT,
  `dt_inativacao` datetime DEFAULT NULL,
  `dt_registro` datetime DEFAULT NULL,
  `fl_ativo` char(1) DEFAULT NULL,
  `id_grupo` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_grupos_usuarios`),
  KEY `FKk5ui2y0vabudf73oia38vsvrt` (`id_grupo`),
  KEY `FKl9j4xb4ov76g3cqklox2ry0lw` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos_usuarios`
--

LOCK TABLES `grupos_usuarios` WRITE;
/*!40000 ALTER TABLE `grupos_usuarios` DISABLE KEYS */;
INSERT INTO `grupos_usuarios` VALUES (3,NULL,'2019-06-02 18:33:28','A',1,1),(4,NULL,'2019-06-02 18:57:19','A',1,2),(5,NULL,'2019-06-02 18:57:44','A',1,3),(6,NULL,'2019-06-02 18:57:50','A',1,5),(7,'2019-06-02 18:58:06','2019-06-02 18:58:06','I',1,4),(8,NULL,'2019-06-04 20:40:59','A',2,2),(9,NULL,'2019-06-04 20:43:09','A',2,1),(10,NULL,'2019-06-04 20:43:16','A',2,3),(11,NULL,'2019-06-04 20:43:21','A',2,4),(12,NULL,'2019-06-23 17:59:11','A',3,1),(13,NULL,'2019-06-23 22:00:44','A',4,1),(14,NULL,'2019-06-23 22:04:59','A',5,1),(15,NULL,'2019-06-23 22:23:36','A',6,1),(16,NULL,'2019-06-23 22:31:46','A',7,3),(17,NULL,'2019-06-23 23:45:41','A',1,6);
/*!40000 ALTER TABLE `grupos_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-23 21:28:20
