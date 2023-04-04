-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: controliga
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `impressoes`
--

DROP TABLE IF EXISTS `impressoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impressoes` (
  `idImpre` int(11) NOT NULL AUTO_INCREMENT,
  `qtdadeImpre` int(11) NOT NULL,
  `dataImpre` date DEFAULT NULL,
  `idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idImpre`),
  KEY `fk_idPerfilImpre` (`idPerfil`),
  CONSTRAINT `fk_idPerfilImpre` FOREIGN KEY (`idPerfil`) REFERENCES `pessoas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impressoes`
--

LOCK TABLES `impressoes` WRITE;
/*!40000 ALTER TABLE `impressoes` DISABLE KEYS */;
INSERT INTO `impressoes` VALUES (4,50,'2017-03-31',1),(6,20,'2017-04-03',1),(7,10,'2017-04-04',8),(9,20,'2017-04-05',5),(10,40,'2017-04-05',5),(16,10,'2017-04-05',5),(20,60,'2017-04-05',1),(21,10,'2017-05-05',1),(22,50,'2017-05-08',6),(24,20,'2017-05-09',5);
/*!40000 ALTER TABLE `impressoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligacoes`
--

DROP TABLE IF EXISTS `ligacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ligacoes` (
  `idLiga` int(11) NOT NULL AUTO_INCREMENT,
  `dataLiga` date NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `numeroLigado` varchar(60) NOT NULL,
  PRIMARY KEY (`idLiga`),
  KEY `fk_idPerfilLiga` (`idPerfil`),
  CONSTRAINT `fk_idPerfilLiga` FOREIGN KEY (`idPerfil`) REFERENCES `pessoas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligacoes`
--

LOCK TABLES `ligacoes` WRITE;
/*!40000 ALTER TABLE `ligacoes` DISABLE KEYS */;
INSERT INTO `ligacoes` VALUES (5,'2017-04-04',5,'67128312563271'),(6,'2017-04-05',5,'543453534343'),(7,'2017-04-05',5,'45345345345345'),(8,'2017-04-05',5,'453453453453535'),(9,'2017-04-05',5,'453453453453453'),(10,'2017-04-05',5,'4345345345345345'),(11,'2017-04-05',5,'43453453453453'),(15,'2017-04-05',1,'(32)3746-3139'),(16,'2017-04-05',1,'4154851254851'),(17,'2017-04-05',1,'84512154851254851'),(18,'2017-04-05',1,'6394144514'),(19,'2017-04-05',1,'845124845128451'),(20,'2017-04-05',1,'512044512484512'),(21,'2017-04-05',1,'65230491241'),(23,'2017-04-05',9,'56456456456'),(26,'2017-04-05',8,'3434345345345'),(28,'2017-04-10',5,'8451587451'),(32,'2017-05-09',5,'984428776');
/*!40000 ALTER TABLE `ligacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `limites`
--

DROP TABLE IF EXISTS `limites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `limites` (
  `idLimites` int(11) NOT NULL AUTO_INCREMENT,
  `qtdadeLimiteLiga` int(11) NOT NULL,
  `qtdadeLimiteImpre` int(11) NOT NULL,
  PRIMARY KEY (`idLimites`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `limites`
--

LOCK TABLES `limites` WRITE;
/*!40000 ALTER TABLE `limites` DISABLE KEYS */;
INSERT INTO `limites` VALUES (1,20,60);
/*!40000 ALTER TABLE `limites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'leonardo','123456'),(2,'higor','12345'),(6,'teste','123');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoas`
--

DROP TABLE IF EXISTS `pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCompleto` varchar(255) NOT NULL,
  `cpf` varchar(30) DEFAULT NULL,
  `cidade` varchar(80) NOT NULL,
  `estado` varchar(80) NOT NULL,
  `telefone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoas`
--

LOCK TABLES `pessoas` WRITE;
/*!40000 ALTER TABLE `pessoas` DISABLE KEYS */;
INSERT INTO `pessoas` VALUES (1,'Cliente Teste','99999999999','Espera Feliz','Minas Gerais','(32)3746-1562');
/*!40000 ALTER TABLE `pessoas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10 14:02:42
