CREATE DATABASE  IF NOT EXISTS `smart-city`;
USE `smart-city`;

DROP TABLE IF EXISTS `dispositivo_entity`;

CREATE TABLE `dispositivo_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `dispositivo_entity` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `evento_entity`;

CREATE TABLE `evento_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_hora` datetime(6) DEFAULT NULL,
  `dispositivo_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdelvwh65p7719cswabc475ef1` (`dispositivo_id`),
  CONSTRAINT `FKdelvwh65p7719cswabc475ef1` FOREIGN KEY (`dispositivo_id`) REFERENCES `dispositivo_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `evento_entity` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sensor_alumbrado_entity`;

CREATE TABLE `sensor_alumbrado_entity` (
  `estado` bit(1) NOT NULL,
  `intensidad` int DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  `luz_ambiente` int DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK2c1ltn814gdpwphv0kyl72pym` FOREIGN KEY (`id`) REFERENCES `dispositivo_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sensor_alumbrado_entity` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sensor_banio_entity`;

CREATE TABLE `sensor_banio_entity` (
  `edificio` varchar(255) DEFAULT NULL,
  `estado` smallint DEFAULT NULL,
  `hora_final_limpieza` time NOT NULL,
  `hora_inicial_limpieza` time NOT NULL,
  `turno` varchar(255) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKpf8guw5u4k6ivt5ypxrdntc2w` FOREIGN KEY (`id`) REFERENCES `dispositivo_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sensor_banio_entity` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sensor_estacionamiento_entity`;

CREATE TABLE `sensor_estacionamiento_entity` (
  `estado` smallint DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKcfdeke3ewr14byb3jp1hvnowa` FOREIGN KEY (`id`) REFERENCES `dispositivo_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sensor_estacionamiento_entity` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sensor_humedad`;

CREATE TABLE `sensor_humedad` (
  `createdat` datetime(6) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `humedad_actual` int NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK2r9g9p7oqmhwn3rg54dfx3dk7` FOREIGN KEY (`id`) REFERENCES `dispositivo_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sensor_humedad` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKscfpive7aa0o9savdwmxmnaij` (`role`,`user_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user_role` WRITE;
UNLOCK TABLES;

-- Contraseñas admin y audi
INSERT INTO `user` VALUES (1,'2023-05-26 00:16:06',1,'$2a$10$.fo2Uwnx3wALgj9G5vQZtu3jJVBgTwuSK0PGAG/pVtVLClHPi18/6','2023-05-26 00:16:06','Administrador');
INSERT INTO `user_role` VALUES (1,'2023-05-26 00:16:06','ROLE_ADMIN','2023-05-26 00:16:06',1);

INSERT INTO `user` VALUES (2,'2023-05-26 00:16:06',1,'$2a$10$YDClEjJtqgTNtDnq9nM.B./HzIIGl6ezjnQt/S1FwF8iJ3hCZLnhu','2023-05-26 00:16:06','Auditor');
INSERT INTO `user_role` VALUES (2,'2023-05-26 00:16:06','ROLE_AUDITOR','2023-05-26 00:16:06',2);

INSERT INTO dispositivo_entity VALUES (1, 1, 'Alumbrado');
INSERT INTO dispositivo_entity VALUES (2, 1, 'Alumbrado');
INSERT INTO dispositivo_entity VALUES (3, 0, 'Alumbrado');
INSERT INTO dispositivo_entity VALUES (4, 1, 'Estacionamiento');
INSERT INTO dispositivo_entity VALUES (5, 0, 'Estacionamiento');
INSERT INTO dispositivo_entity VALUES (6, 1, 'Limpieza');
INSERT INTO dispositivo_entity VALUES (7, 0, 'Limpieza');
INSERT INTO dispositivo_entity VALUES (8, 1, 'Regado');
INSERT INTO dispositivo_entity VALUES (9, 1, 'Regado');

INSERT INTO sensor_alumbrado_entity VALUES (0, 50, 'La Plaza del 10', '4', '1');
INSERT INTO sensor_alumbrado_entity VALUES (1, 100, 'Plaza de la Gratuidad Universitaria', '2', '2');
INSERT INTO sensor_alumbrado_entity VALUES (0, 50, 'Edificio Leopoldo Marechal', '5', '3');

INSERT INTO sensor_estacionamiento_entity VALUES ('0', 'A1', '4');
INSERT INTO sensor_estacionamiento_entity VALUES ('1', 'A2', '5');

INSERT INTO sensor_banio_entity VALUES ('Marechal', '0', '7:45:00', '07:00:00', 'Mañana', '6');
INSERT INTO sensor_banio_entity VALUES ('Jose Hernandez', '0', '20:45:00', '19:00:00', 'Noche', '7');

INSERT INTO sensor_humedad VALUES ('2023-06-21 10:08:32.484515', '0', '63', '2023-06-21 10:10:49.532692', '8');
INSERT INTO sensor_humedad VALUES ('2023-06-21 10:08:44.383842', '0', '61', '2023-06-21 10:10:54.793665', '9');
