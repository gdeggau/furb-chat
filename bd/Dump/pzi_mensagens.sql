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
-- Table structure for table `mensagens`
--

DROP TABLE IF EXISTS `mensagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mensagens` (
  `id_mensagem` bigint(20) NOT NULL AUTO_INCREMENT,
  `ds_mensagem` varchar(255) DEFAULT NULL,
  `dt_envio` datetime DEFAULT NULL,
  `fl_tipo_mensagem` char(1) DEFAULT NULL,
  `id_usuario_envio` bigint(20) DEFAULT NULL,
  `fl_tipo_destino` char(1) DEFAULT NULL,
  `ds_titulo_conversa` varchar(255) DEFAULT NULL,
  `id_destino` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_mensagem`),
  KEY `FKokalto9ntq3535rj3caio31fl` (`id_usuario_envio`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagens`
--

LOCK TABLES `mensagens` WRITE;
/*!40000 ALTER TABLE `mensagens` DISABLE KEYS */;
INSERT INTO `mensagens` VALUES (1,'Eae Nicolas cagalhaooo','2019-05-17 00:01:32','T',1,'U','Nicolas Viana',3),(2,'Fala ai mano, beleza?','2019-05-17 00:02:40','T',3,'U','Gabriel Deggau Schmidt',1),(3,'Tudo sussegado, fizesse trampo do Aurelio?','2019-05-17 00:03:10','T',1,'U','Nicolas Viana',3),(4,'Fiz sim mano, boto teu nome, dmr??','2019-05-17 00:03:36','T',3,'U','Gabriel Deggau Schmidt',1),(5,'Feshow, vamo dale','2019-05-17 00:04:02','T',1,'U','Nicolas Viana',3),(6,'Eae bento, me ensina Unity','2019-05-17 00:04:53','T',2,'U','Ayrton Senna',5),(7,'Sem tempo irmão (Y)','2019-05-17 00:05:23','T',5,'U','Cleber Tomazoni',2),(8,'Sem tempo irmão (Y)','2019-05-17 00:05:48','T',4,'U','Cleber Tomazoni',2),(9,'Então assim, vai agir de ma fée?','2019-05-17 00:06:15','T',2,'U','Gabriel Chico Bento',4),(10,'Acontece né mano, malz aee','2019-05-17 00:06:39','T',4,'U','Cleber Tomazoni',2),(11,'O feiooo','2019-05-17 00:12:00','T',1,'U','Nicolas Viana',3),(12,'vamo pro wrngg ne , pco oscuna e pa','2019-05-17 00:12:18','T',1,'U','Nicolas Viana',3),(13,'boto uma @ eaa','2019-05-17 00:12:30','T',1,'U','Nicolas Viana',3),(14,'oo feoo, ai sim','2019-05-17 00:12:49','T',3,'U','Gabriel Deggau Schmidt',1),(15,'vamo dale bixao','2019-05-17 00:12:58','T',3,'U','Gabriel Deggau Schmidt',1),(16,'Bom dia pessoal','2019-06-03 00:19:21','T',1,'G','Furb 2019',1),(18,'quem ai vai me carregar no trabalho???','2019-06-03 00:47:00','T',2,'G','Furb 2019',1),(19,'pessoal, nao to afim de fazer nenhum trabalho blz','2019-06-04 20:44:34','T',1,'G','Trabalhos furb',2),(20,'porra deixa de ser vadio mano','2019-06-04 20:45:09','T',5,'G','Trabalhos furb',2),(21,'eae degauuu','2019-06-09 22:00:54','T',2,'U','Gabriel Deggau Schmidt',1),(22,'testando belezaa','2019-06-09 22:01:02','T',2,'U','Gabriel Deggau Schmidt',1),(23,'flw','2019-06-09 22:01:07','T',2,'U','Gabriel Deggau Schmidt',1),(24,'testeeee','2019-06-09 22:10:46','T',3,'U','Gabriel Deggau Schmidt',1),(25,'ta funcionando porra','2019-06-09 22:11:18','T',3,'U','Gabriel Deggau Schmidt',1),(26,'chioteias as feia','2019-06-09 22:11:44','T',4,'U','Gabriel Deggau Schmidt',1),(27,'dalee','2019-06-09 22:11:49','T',4,'U','Gabriel Deggau Schmidt',1),(28,'isso é um teste','2019-06-13 16:23:33','T',2,'U','Nicolas Viana',3),(30,'eae Deggau','2019-06-13 22:30:10','T',2,'U','Gabriel Deggau Schmidt',1),(31,'Agora vai','2019-06-13 22:33:33','T',3,'U','Gabriel Deggau Schmidt',1),(32,'teste','2019-06-13 23:49:10','T',1,'U','Nicolas Viana',3),(33,'opa','2019-06-14 00:09:10','T',1,'U','Nicolas Viana',3),(36,'teste campo destino','2019-06-16 18:35:17','T',1,'U','Nicolas Viana',3),(38,'boa noite cleber','2019-06-21 00:23:00','T',1,'U','Cleber Tomazoni',2),(39,'funcionou?','2019-06-21 00:24:32','T',1,'U','Gabriel Chico Bento',4),(40,'bom ayrton','2019-06-21 02:36:18','T',1,'U','Ayrton Senna',5),(41,'ai deggau vtnc teste porra','2019-06-21 03:31:13','T',3,'U','Gabriel Deggau Schmidt',1),(42,'vamo ver se funcona','2019-06-21 03:31:41','T',2,'U','Gabriel Deggau Schmidt',1),(43,'fdp','2019-06-21 04:05:20','T',1,'U','Gabriel Chico Bento',4),(44,'celular da samsung','2019-06-21 19:14:19','T',1,'U','Teste',6),(45,'ai o caralho vamo ver se ta funcionando essa porra','2019-06-21 22:28:20','T',1,'U','cuca de banana',7),(46,'bom dia grupo','2019-06-23 19:33:10','T',1,'G','Furb 2019',1),(48,'Seja bem vindo ao grupo Gabriel Deggau Schmidt','2019-06-23 22:23:36','T',0,'G','praia',6),(49,'Olá Nicolas Viana, seja bem vindo ao grupo trilha morro do macaco','2019-06-23 22:31:46','T',0,'G','trilha morro do macaco',7),(50,'Olá Teste, seja bem vindo ao grupo Furb 2019','2019-06-23 23:45:41','T',0,'G','Furb 2019',1),(51,'fala ai teste seu galhudo','2019-06-23 23:47:56','T',3,'U','Teste',6),(52,'eu amo rede neural','2019-06-24 00:22:23','T',3,'G','Furb 2019',1);
/*!40000 ALTER TABLE `mensagens` ENABLE KEYS */;
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
