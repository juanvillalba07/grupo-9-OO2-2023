CREATE DATABASE  IF NOT EXISTS `smart-city`;
USE `smart-city`;
-- contraseñas root y crud
INSERT INTO `user` VALUES (1,'2023-05-26 00:16:06',1,'$2a$10$.fo2Uwnx3wALgj9G5vQZtu3jJVBgTwuSK0PGAG/pVtVLClHPi18/6','2023-05-26 00:16:06','Administrador');
INSERT INTO `user_role` VALUES (1,'2023-05-26 00:16:06','ROLE_ADMIN','2023-05-26 00:16:06',1);

INSERT INTO `user` VALUES (2,'2023-05-26 00:16:06',1,'$2a$10$YDClEjJtqgTNtDnq9nM.B./HzIIGl6ezjnQt/S1FwF8iJ3hCZLnhu','2023-05-26 00:16:06','Auditor');
INSERT INTO `user_role` VALUES (2,'2023-05-26 00:16:06','ROLE_AUDITOR','2023-05-26 00:16:06',2);

select*from user;
select*from user_role;