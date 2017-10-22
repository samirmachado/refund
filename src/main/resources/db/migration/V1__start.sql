-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.20 - MySQL Community Server (GPL)
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para refund
CREATE DATABASE IF NOT EXISTS `refund` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `refund`;

-- Copiando estrutura para tabela refund.case_task_event
CREATE TABLE IF NOT EXISTS `case_task_event` (
  `case_task_event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`case_task_event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.case_task_event: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `case_task_event` DISABLE KEYS */;
INSERT INTO `case_task_event` (`case_task_event_id`, `name`, `type`) VALUES
	(1, 'Case 1', 'C'),
	(2, 'Task 1', 'T'),
	(3, 'Event 1', 'E');
/*!40000 ALTER TABLE `case_task_event` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.classification
CREATE TABLE IF NOT EXISTS `classification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `case_task_event_case_task_event_id` bigint(20) DEFAULT NULL,
  `clasz_class_id` bigint(20) DEFAULT NULL,
  `department_department_id` bigint(20) DEFAULT NULL,
  `location_location_id` bigint(20) DEFAULT NULL,
  `subsidiary_subsidiary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi4csagjk748mvkdkc4d45hy84` (`case_task_event_case_task_event_id`),
  KEY `FKluyrk0fjjv2sxjpijhjkmocca` (`clasz_class_id`),
  KEY `FK444jbt5bevb008i6v16gren2p` (`department_department_id`),
  KEY `FKevwqn9e23hj7wigh3u569m7xx` (`location_location_id`),
  KEY `FKj0cacqp7re0u5skx0ym9kr23v` (`subsidiary_subsidiary_id`),
  CONSTRAINT `FK444jbt5bevb008i6v16gren2p` FOREIGN KEY (`department_department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `FKevwqn9e23hj7wigh3u569m7xx` FOREIGN KEY (`location_location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `FKi4csagjk748mvkdkc4d45hy84` FOREIGN KEY (`case_task_event_case_task_event_id`) REFERENCES `case_task_event` (`case_task_event_id`),
  CONSTRAINT `FKj0cacqp7re0u5skx0ym9kr23v` FOREIGN KEY (`subsidiary_subsidiary_id`) REFERENCES `subsidiary` (`subsidiary_id`),
  CONSTRAINT `FKluyrk0fjjv2sxjpijhjkmocca` FOREIGN KEY (`clasz_class_id`) REFERENCES `clasz` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.classification: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.clasz
CREATE TABLE IF NOT EXISTS `clasz` (
  `class_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.clasz: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `clasz` DISABLE KEYS */;
INSERT INTO `clasz` (`class_id`, `name`) VALUES
	(1, '1 - CEO'),
	(2, '10 - Culture and People'),
	(3, '11 - Marketing'),
	(4, '12 - Strategy Office'),
	(5, '2.3 - Telecom'),
	(6, '3 - Finance');
/*!40000 ALTER TABLE `clasz` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration_information
CREATE TABLE IF NOT EXISTS `configuration_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration_information: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration_information` DISABLE KEYS */;
INSERT INTO `configuration_information` (`id`) VALUES
	(1);
/*!40000 ALTER TABLE `configuration_information` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__case_task_event
CREATE TABLE IF NOT EXISTS `configuration__case_task_event` (
  `id` bigint(20) NOT NULL,
  `case_task_event_id` bigint(20) NOT NULL,
  KEY `FK1iiiq9lxv4009hoyvlext8uy5` (`case_task_event_id`),
  KEY `FK9puksqhfvxwked7iai167jw74` (`id`),
  CONSTRAINT `FK1iiiq9lxv4009hoyvlext8uy5` FOREIGN KEY (`case_task_event_id`) REFERENCES `case_task_event` (`case_task_event_id`),
  CONSTRAINT `FK9puksqhfvxwked7iai167jw74` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__case_task_event: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__case_task_event` DISABLE KEYS */;
INSERT INTO `configuration__case_task_event` (`id`, `case_task_event_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__case_task_event` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__clasz
CREATE TABLE IF NOT EXISTS `configuration__clasz` (
  `id` bigint(20) NOT NULL,
  `class_id` bigint(20) NOT NULL,
  KEY `FKegr63ehog8wm6lq90mhh2du1r` (`class_id`),
  KEY `FK8lpwdhohq0bc6e12a6mblptmw` (`id`),
  CONSTRAINT `FK8lpwdhohq0bc6e12a6mblptmw` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`),
  CONSTRAINT `FKegr63ehog8wm6lq90mhh2du1r` FOREIGN KEY (`class_id`) REFERENCES `clasz` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__clasz: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__clasz` DISABLE KEYS */;
INSERT INTO `configuration__clasz` (`id`, `class_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__clasz` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__customer
CREATE TABLE IF NOT EXISTS `configuration__customer` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  KEY `FK54tyhpbn3tg5nc15lapmx0dej` (`customer_id`),
  KEY `FK4x3hk5jhgpbx5l8io8to4u433` (`id`),
  CONSTRAINT `FK4x3hk5jhgpbx5l8io8to4u433` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`),
  CONSTRAINT `FK54tyhpbn3tg5nc15lapmx0dej` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__customer: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__customer` DISABLE KEYS */;
INSERT INTO `configuration__customer` (`id`, `customer_id`) VALUES
	(1, 3);
/*!40000 ALTER TABLE `configuration__customer` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__department
CREATE TABLE IF NOT EXISTS `configuration__department` (
  `id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  KEY `FKjp4ffy6tyc6c4j9t52neajpdc` (`department_id`),
  KEY `FK8ow15g7g63q8ngt5m49t5ah0p` (`id`),
  CONSTRAINT `FK8ow15g7g63q8ngt5m49t5ah0p` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`),
  CONSTRAINT `FKjp4ffy6tyc6c4j9t52neajpdc` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__department: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__department` DISABLE KEYS */;
INSERT INTO `configuration__department` (`id`, `department_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__department` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__location
CREATE TABLE IF NOT EXISTS `configuration__location` (
  `id` bigint(20) NOT NULL,
  `location_id` bigint(20) NOT NULL,
  KEY `FKta4xwsssgx5l7s7r3ff119tey` (`location_id`),
  KEY `FK12o40kpi4ygir1jr80mp2hrjh` (`id`),
  CONSTRAINT `FK12o40kpi4ygir1jr80mp2hrjh` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`),
  CONSTRAINT `FKta4xwsssgx5l7s7r3ff119tey` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__location: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__location` DISABLE KEYS */;
INSERT INTO `configuration__location` (`id`, `location_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__location` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__service_item
CREATE TABLE IF NOT EXISTS `configuration__service_item` (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  KEY `FKkil1ljc70pvbdvj4aippivldk` (`item_id`),
  KEY `FKeq2puiv81gby30hbonj2nqhgh` (`id`),
  CONSTRAINT `FKeq2puiv81gby30hbonj2nqhgh` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`),
  CONSTRAINT `FKkil1ljc70pvbdvj4aippivldk` FOREIGN KEY (`item_id`) REFERENCES `service_item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__service_item: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__service_item` DISABLE KEYS */;
INSERT INTO `configuration__service_item` (`id`, `item_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__service_item` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.configuration__subsidiary
CREATE TABLE IF NOT EXISTS `configuration__subsidiary` (
  `id` bigint(20) NOT NULL,
  `subsidiary_id` bigint(20) NOT NULL,
  KEY `FK1atuu0j6jrq41kjtfjd0e19p7` (`subsidiary_id`),
  KEY `FK60dxo8btmhp5oqed3x4d0ofn2` (`id`),
  CONSTRAINT `FK1atuu0j6jrq41kjtfjd0e19p7` FOREIGN KEY (`subsidiary_id`) REFERENCES `subsidiary` (`subsidiary_id`),
  CONSTRAINT `FK60dxo8btmhp5oqed3x4d0ofn2` FOREIGN KEY (`id`) REFERENCES `configuration_information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.configuration__subsidiary: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `configuration__subsidiary` DISABLE KEYS */;
INSERT INTO `configuration__subsidiary` (`id`, `subsidiary_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `configuration__subsidiary` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.customer: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_id`, `name`) VALUES
	(1, 'Ipiranga'),
	(2, 'Santander'),
	(3, '"Banco Pine');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.department
CREATE TABLE IF NOT EXISTS `department` (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.department: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`department_id`, `name`) VALUES
	(1, 'Delivery'),
	(2, 'P&D'),
	(3, 'Departamento 3');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `employee_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.employee: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `email`, `employee_type`, `name`, `password`) VALUES
	(1, 'teste@email.com', 'USER', 'Teste', 'pass');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.location
CREATE TABLE IF NOT EXISTS `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.location: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`location_id`, `name`) VALUES
	(1, 'Belo Horizonte'),
	(2, 'Campinas'),
	(3, 'Uberlandia'),
	(4, 'Sao Jose do Rio Preto'),
	(5, 'Sao Paulo');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.primary_information
CREATE TABLE IF NOT EXISTS `primary_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billable` bit(1) DEFAULT NULL,
  `date` tinyblob,
  `duration` tinyblob,
  `end_time` tinyblob,
  `memo` varchar(255) DEFAULT NULL,
  `start_time` tinyblob,
  `case_task_event_case_task_event_id` bigint(20) DEFAULT NULL,
  `customer_customer_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `service_item_item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8hjbneavhuxsophjbl3kymxqk` (`case_task_event_case_task_event_id`),
  KEY `FK8stu634vt67pul3d0n6d0q3xl` (`customer_customer_id`),
  KEY `FK12iey2yy628kkrp9mb6f5jmq9` (`employee_id`),
  KEY `FKndhy4ig04lu8ncyc6qa06fa3b` (`service_item_item_id`),
  CONSTRAINT `FK12iey2yy628kkrp9mb6f5jmq9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK8hjbneavhuxsophjbl3kymxqk` FOREIGN KEY (`case_task_event_case_task_event_id`) REFERENCES `case_task_event` (`case_task_event_id`),
  CONSTRAINT `FK8stu634vt67pul3d0n6d0q3xl` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKndhy4ig04lu8ncyc6qa06fa3b` FOREIGN KEY (`service_item_item_id`) REFERENCES `service_item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.primary_information: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `primary_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `primary_information` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.service_item
CREATE TABLE IF NOT EXISTS `service_item` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.service_item: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `service_item` DISABLE KEYS */;
INSERT INTO `service_item` (`item_id`, `description`) VALUES
	(1, 'Desenvolvimento'),
	(2, 'Suporte'),
	(3, 'Service Item 3');
/*!40000 ALTER TABLE `service_item` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.subsidiary
CREATE TABLE IF NOT EXISTS `subsidiary` (
  `subsidiary_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subsidiary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.subsidiary: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `subsidiary` DISABLE KEYS */;
INSERT INTO `subsidiary` (`subsidiary_id`, `name`) VALUES
	(1, 'BH'),
	(2, 'CPS'),
	(3, 'UDI'),
	(4, 'SJRP'),
	(5, 'SP');
/*!40000 ALTER TABLE `subsidiary` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.time_sheet
CREATE TABLE IF NOT EXISTS `time_sheet` (
  `time_sheet_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classification_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `primary_information_id` bigint(20) DEFAULT NULL,
  `time_sheet_approval_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`time_sheet_id`),
  KEY `FKhbyv3gh6j5lc0mwqaifwg8691` (`classification_id`),
  KEY `FKs3xh9hr73dr02loe8emw5nb8p` (`employee_id`),
  KEY `FKgjqi3wdlepy7103s1y82tfo6e` (`primary_information_id`),
  KEY `FKk14jtoh9ac2arojx7dxdyabys` (`time_sheet_approval_id`),
  CONSTRAINT `FKgjqi3wdlepy7103s1y82tfo6e` FOREIGN KEY (`primary_information_id`) REFERENCES `primary_information` (`id`),
  CONSTRAINT `FKhbyv3gh6j5lc0mwqaifwg8691` FOREIGN KEY (`classification_id`) REFERENCES `classification` (`id`),
  CONSTRAINT `FKk14jtoh9ac2arojx7dxdyabys` FOREIGN KEY (`time_sheet_approval_id`) REFERENCES `time_sheet_approval` (`id`),
  CONSTRAINT `FKs3xh9hr73dr02loe8emw5nb8p` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.time_sheet: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `time_sheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_sheet` ENABLE KEYS */;

-- Copiando estrutura para tabela refund.time_sheet_approval
CREATE TABLE IF NOT EXISTS `time_sheet_approval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memo` varchar(255) DEFAULT NULL,
  `status` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `time_sheet_time_sheet_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgc5pyxh4wt42syysupfve6dil` (`employee_id`),
  KEY `FKm2fmt6yj8l9kbklcwejwfwsay` (`time_sheet_time_sheet_id`),
  CONSTRAINT `FKgc5pyxh4wt42syysupfve6dil` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKm2fmt6yj8l9kbklcwejwfwsay` FOREIGN KEY (`time_sheet_time_sheet_id`) REFERENCES `time_sheet` (`time_sheet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela refund.time_sheet_approval: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `time_sheet_approval` DISABLE KEYS */;
/*!40000 ALTER TABLE `time_sheet_approval` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;