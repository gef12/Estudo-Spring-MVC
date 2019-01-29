-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bdsuarepublica
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `republica`
--

DROP TABLE IF EXISTS `republica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `republica` (
  `republica_id` int(11) NOT NULL,
  `descricao` longtext,
  `genero` varchar(255) NOT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `lotacao` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `permite_animais` bit(1) NOT NULL,
  `permite_fumantes` bit(1) NOT NULL,
  `qnt_banheiros` int(11) NOT NULL,
  `qnt_quartos` int(11) NOT NULL,
  `qnt_vagas` int(11) NOT NULL,
  `vaga_garagem` int(11) NOT NULL,
  `endereco_endereco_id` int(11) DEFAULT NULL,
  `telefone_telefone_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`republica_id`),
  KEY `FKnhsny4clvuy4o3g7elycx7126` (`endereco_endereco_id`),
  KEY `FK3psu9htpe7kmf0msh8iuq413w` (`telefone_telefone_id`),
  KEY `FK6qijf8pri0smu041aejx4jaau` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `republica`
--

LOCK TABLES `republica` WRITE;
/*!40000 ALTER TABLE `republica` DISABLE KEYS */;
INSERT INTO `republica` VALUES (28,'sSs','MASCULINO',NULL,35,'dada','\0','\0',34,45,2,0,26,27,1),(31,'dDd','MASCULINO',NULL,5,'senzala','\0','\0',5,5,5,0,29,30,1);
/*!40000 ALTER TABLE `republica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 18:18:55
