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
-- Table structure for table `mensagens_destinatario`
--

DROP TABLE IF EXISTS `mensagens_destinatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mensagens_destinatario` (
  `id_mensagem_destinatario` bigint(20) NOT NULL AUTO_INCREMENT,
  `fl_lida` char(1) DEFAULT NULL,
  `id_grupos_usuarios_destino` bigint(20) DEFAULT NULL,
  `id_mensagem` bigint(20) DEFAULT NULL,
  `id_usuario_destino` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_mensagem_destinatario`),
  KEY `FKsfdal6n27xbxjw97ukv8w7m99` (`id_grupos_usuarios_destino`),
  KEY `FK9j593as8mronmv6qyjgmbbtkp` (`id_mensagem`),
  KEY `FKjin7v76dyd3hwvypsm32r8q74` (`id_usuario_destino`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagens_destinatario`
--

LOCK TABLES `mensagens_destinatario` WRITE;
/*!40000 ALTER TABLE `mensagens_destinatario` DISABLE KEYS */;
INSERT INTO `mensagens_destinatario` VALUES (2,'N',NULL,1,3),(3,'N',NULL,2,1),(4,'N',NULL,3,3),(5,'N',NULL,4,1),(6,'N',NULL,5,3),(7,'N',NULL,6,5),(8,'N',NULL,7,2),(9,'N',NULL,8,2),(10,'N',NULL,9,4),(11,'N',NULL,10,2),(12,'N',NULL,11,3),(13,'N',NULL,12,3),(14,'N',NULL,13,3),(15,'N',NULL,14,1),(16,'N',NULL,15,1),(17,'N',3,16,NULL),(18,'N',4,16,NULL),(19,'N',5,16,NULL),(20,'N',6,16,NULL),(21,'N',7,16,NULL),(23,'N',3,18,NULL),(24,'N',4,18,NULL),(25,'N',5,18,NULL),(26,'N',6,18,NULL),(27,'N',8,19,NULL),(28,'N',9,19,NULL),(29,'N',10,19,NULL),(30,'N',11,19,NULL),(31,'N',8,20,NULL),(32,'N',9,20,NULL),(33,'N',10,20,NULL),(34,'N',11,20,NULL),(35,'N',NULL,21,1),(36,'N',NULL,22,1),(37,'N',NULL,23,1),(38,'N',NULL,24,1),(39,'N',NULL,25,1),(40,'N',NULL,26,1),(41,'N',NULL,27,1),(42,'N',NULL,28,3),(44,'N',NULL,30,1),(45,'N',NULL,31,1),(46,'N',NULL,32,3),(47,'N',NULL,33,3),(49,'N',NULL,36,3),(51,'N',NULL,38,2),(52,'N',NULL,39,4),(53,'N',NULL,40,5),(54,'N',NULL,41,1),(55,'N',NULL,42,1),(56,'N',NULL,43,4),(57,'N',NULL,44,6),(58,'N',NULL,45,7),(59,'N',3,46,NULL),(60,'N',4,46,NULL),(61,'N',5,46,NULL),(62,'N',6,46,NULL),(63,'N',14,0,NULL),(64,'N',15,48,NULL),(65,'N',16,49,NULL),(66,'N',3,50,NULL),(67,'N',4,50,NULL),(68,'N',5,50,NULL),(69,'N',6,50,NULL),(70,'N',17,50,NULL),(71,'N',NULL,51,6),(72,'N',3,52,NULL),(73,'N',4,52,NULL),(74,'N',5,52,NULL),(75,'N',6,52,NULL),(76,'N',17,52,NULL);
/*!40000 ALTER TABLE `mensagens_destinatario` ENABLE KEYS */;
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
