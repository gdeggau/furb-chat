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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `ds_caminho_foto` varchar(255) DEFAULT NULL,
  `ds_email` varchar(255) DEFAULT NULL,
  `ds_frase_perfil` varchar(255) DEFAULT NULL,
  `ds_senha` varchar(255) DEFAULT NULL,
  `dt_cadastro` datetime DEFAULT NULL,
  `dt_inativacao` datetime DEFAULT NULL,
  `dt_nascimento` datetime DEFAULT NULL,
  `fl_ativo` char(1) DEFAULT NULL,
  `fl_status` char(1) DEFAULT NULL,
  `nm_usuario_exibicao` varchar(255) DEFAULT NULL,
  `nm_usuario` varchar(255) DEFAULT NULL,
  `nr_telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'','gabrieldeggau@hotmail.com','','202cb962ac59075b964b07152d234b70','2019-05-13 17:47:44',NULL,'1998-04-23 03:00:00','A','D','Gabriel Deggau Schmidt','Gabriel','5547000000001'),(2,'','cleber@hotmail.com','','202cb962ac59075b964b07152d234b70','2019-05-13 17:54:39',NULL,'1998-06-13 03:00:00','A','A','Cleber Tomazoni','Cleber','5547000000002'),(3,'','1213123r@hotmail.com','','202cb962ac59075b964b07152d234b70','2019-05-13 17:55:32',NULL,'1998-06-13 03:00:00','A','A','Nicolas Viana','Nicoals','5547000000003'),(4,'','bentor@hotmail.com','','202cb962ac59075b964b07152d234b70','2019-05-16 23:34:52',NULL,'1999-06-13 03:00:00','A','A','Gabriel Chico Bento','Bento','5547000000004'),(5,'','senna@hotmail.com','','202cb962ac59075b964b07152d234b70','2019-05-16 23:35:24',NULL,'1980-06-13 03:00:00','A','A','Ayrton Senna','Ayrton','5547000000005'),(6,NULL,'sdagudas@gmail.com','olaaaa legal','202cb962ac59075b964b07152d234b70','2019-06-12 22:58:33',NULL,NULL,'A','D','Teste','Teste','5547000000006'),(7,NULL,'','','202cb962ac59075b964b07152d234b70','2019-06-21 22:23:21',NULL,'1996-03-23 06:00:00','A','D','cuca de banana','cuca de banana','5547000000007'),(0,NULL,NULL,NULL,NULL,'1900-01-01 00:00:00',NULL,'1900-01-01 00:00:00','A','D',NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
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
