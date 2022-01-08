DROP TABLE IF EXISTS drink CASCADE;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `flavour` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `volume` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);
