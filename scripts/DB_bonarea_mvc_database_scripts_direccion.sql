CREATE TABLE `direccion_verges`(
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `calle` VARCHAR(30) NOT NULL,
    `poblacion` VARCHAR(30) NOT NULL,
    `provincia` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;