CREATE DATABASE  IF NOT EXISTS `pizzaria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizzaria`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzaria
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
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `DONO` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dpoda45n3tcxn3jsv51axi6d3` (`DONO`),
  CONSTRAINT `FK_dpoda45n3tcxn3jsv51axi6d3` FOREIGN KEY (`DONO`) REFERENCES `pizzaria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (2,'CARNE','goibada',1),(3,'FRIOS','hhh',1),(4,'SALADA','bbbbb',1),(5,'SALADA','ggegg',1);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'ROLE_PIZZARIA');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  `DONO` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_g4ia6i4hq0u3fg99kyvtekh9r` (`DONO`),
  CONSTRAINT `FK_g4ia6i4hq0u3fg99kyvtekh9r` FOREIGN KEY (`DONO`) REFERENCES `pizzaria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'BROTINHO','gggg',4555,1),(2,'GRANDE','hhh',7,1),(3,'MEDIA','gef',1000,1);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_ingrediente`
--

DROP TABLE IF EXISTS `pizza_ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_ingrediente` (
  `Pizza_id` bigint(20) NOT NULL,
  `ingredientes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Pizza_id`,`ingredientes_id`),
  KEY `FK_j1g0as0cosyak3tg4nkccos16` (`ingredientes_id`),
  CONSTRAINT `FK_j1g0as0cosyak3tg4nkccos16` FOREIGN KEY (`ingredientes_id`) REFERENCES `ingrediente` (`id`),
  CONSTRAINT `FK_ome5cf3h5r4pa3mqwu79k45j3` FOREIGN KEY (`Pizza_id`) REFERENCES `pizza` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_ingrediente`
--

LOCK TABLES `pizza_ingrediente` WRITE;
/*!40000 ALTER TABLE `pizza_ingrediente` DISABLE KEYS */;
INSERT INTO `pizza_ingrediente` VALUES (2,2),(3,3);
/*!40000 ALTER TABLE `pizza_ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaria`
--

DROP TABLE IF EXISTS `pizzaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` datetime NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6q878x4obwhpuajq954359psw` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaria`
--

LOCK TABLES `pizzaria` WRITE;
/*!40000 ALTER TABLE `pizzaria` DISABLE KEYS */;
INSERT INTO `pizzaria` VALUES (1,'2018-11-21 02:21:33','Rua PIZZARIA','Pizzaria 1','admin','$2a$10$U0v5OM2VNgyxGzT2gWfdY.IjTRQ7.essLZ4a5foH5O2AQUqBK7tR2');
/*!40000 ALTER TABLE `pizzaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaria_emails`
--

DROP TABLE IF EXISTS `pizzaria_emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaria_emails` (
  `Pizzaria_id` bigint(20) NOT NULL,
  `emails` varchar(255) DEFAULT NULL,
  KEY `FK_o4tabl6xu1fwn3w41q9ccmkmd` (`Pizzaria_id`),
  CONSTRAINT `FK_o4tabl6xu1fwn3w41q9ccmkmd` FOREIGN KEY (`Pizzaria_id`) REFERENCES `pizzaria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaria_emails`
--

LOCK TABLES `pizzaria_emails` WRITE;
/*!40000 ALTER TABLE `pizzaria_emails` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizzaria_emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaria_permissao`
--

DROP TABLE IF EXISTS `pizzaria_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaria_permissao` (
  `Pizzaria_id` bigint(20) NOT NULL,
  `permissoes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Pizzaria_id`,`permissoes_id`),
  KEY `FK_jn2629rjcfl79vlirkqbbdi65` (`permissoes_id`),
  CONSTRAINT `FK_dnherisxn19wrtabu77r7rf6l` FOREIGN KEY (`Pizzaria_id`) REFERENCES `pizzaria` (`id`),
  CONSTRAINT `FK_jn2629rjcfl79vlirkqbbdi65` FOREIGN KEY (`permissoes_id`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaria_permissao`
--

LOCK TABLES `pizzaria_permissao` WRITE;
/*!40000 ALTER TABLE `pizzaria_permissao` DISABLE KEYS */;
INSERT INTO `pizzaria_permissao` VALUES (1,1);
/*!40000 ALTER TABLE `pizzaria_permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaria_telefones`
--

DROP TABLE IF EXISTS `pizzaria_telefones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaria_telefones` (
  `Pizzaria_id` bigint(20) NOT NULL,
  `telefones` varchar(255) DEFAULT NULL,
  KEY `FK_swj8x6ltbcw9m14qscoglya14` (`Pizzaria_id`),
  CONSTRAINT `FK_swj8x6ltbcw9m14qscoglya14` FOREIGN KEY (`Pizzaria_id`) REFERENCES `pizzaria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaria_telefones`
--

LOCK TABLES `pizzaria_telefones` WRITE;
/*!40000 ALTER TABLE `pizzaria_telefones` DISABLE KEYS */;
/*!40000 ALTER TABLE `pizzaria_telefones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pizzaria'
--

--
-- Dumping routines for database 'pizzaria'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23 18:16:11
