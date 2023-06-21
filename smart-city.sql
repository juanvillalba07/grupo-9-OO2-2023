CREATE DATABASE  IF NOT EXISTS `smart-city`;
USE `smart-city`;
-- contraseñas root y crud
INSERT INTO `user` VALUES (1,'2023-05-26 00:16:06',1,'$2a$10$.fo2Uwnx3wALgj9G5vQZtu3jJVBgTwuSK0PGAG/pVtVLClHPi18/6','2023-05-26 00:16:06','Administrador');
INSERT INTO `user_role` VALUES (1,'2023-05-26 00:16:06','ROLE_ADMIN','2023-05-26 00:16:06',1);
INSERT INTO `user` VALUES (2,'2023-05-26 00:16:06',1,'$2a$10$YDClEjJtqgTNtDnq9nM.B./HzIIGl6ezjnQt/S1FwF8iJ3hCZLnhu','2023-05-26 00:16:06','Auditor');
INSERT INTO `user_role` VALUES (2,'2023-05-26 00:16:06','ROLE_AUDITOR','2023-05-26 00:16:06',2);

select*from user;
select*from user_role;
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

SELECT * FROM sensor_alumbrado_entity;
SELECT * FROM sensor_estacionamiento_entity;
SELECT * FROM sensor_banio_entity;
SELECT * FROM sensor_humedad;

SELECT * FROM dispositivo_entity;

SELECT * FROM evento_entity;