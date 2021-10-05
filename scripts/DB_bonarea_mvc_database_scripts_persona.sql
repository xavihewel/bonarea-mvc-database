CREATE TABLE `persona_verges`(
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(30) NOT NULL,
    `apellidos` VARCHAR(100) NOT NULL,
    `dni` VARCHAR(10) NOT NULL,
    CONSTRAINT FK_direccion_persona FOREIGN KEY (id) REFERENCES direccion_verges (id),
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;


