-- -----------------------------------------------------
-- Schema bibliouned -- user: bibliounedapp pass: bibliouned
-- -----------------------------------------------------
DROP SCHEMA `bibliouned`;
CREATE SCHEMA IF NOT EXISTS `bibliouned` DEFAULT CHARACTER SET utf8 ;
USE `bibliouned` ;

-- -----------------------------------------------------
-- Table `bibliouned`.`Biblioteca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`Biblioteca` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(45) NULL,
  `Nombre` VARCHAR(255) NULL,
  `Direccion` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`Biblioteca` (`id` ASC);


-- -----------------------------------------------------
-- Table `bibliouned`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`Usuario` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(10) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `Biblioteca_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Usuario_Biblioteca`
    FOREIGN KEY (`Biblioteca_id`)
    REFERENCES `bibliouned`.`Biblioteca` (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`Usuario` (`id` ASC);

CREATE INDEX `usuario_pass` ON `bibliouned`.`Usuario` (`usuario` ASC, `password` ASC);

CREATE INDEX `fk_Usuario_Biblioteca_idx` ON `bibliouned`.`Usuario` (`Biblioteca_id` ASC);


-- -----------------------------------------------------
-- Table `bibliouned`.`UsuarioExterno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`UsuarioExterno` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(15) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(45) NULL,
  `apellido2` VARCHAR(45) NULL,
  `nif_pasaporte` VARCHAR(45) NULL,
  `mail` VARCHAR(255) NULL,
  `telefono` VARCHAR(15) NULL,
  `localidad` VARCHAR(45) NULL,
  `codigopostal` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `observaciones` VARCHAR(255) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `Biblioteca_id` BIGINT(10) NULL,
  `Usuario_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_UsuarioExterno_Biblioteca`
    FOREIGN KEY (`Biblioteca_id`)
    REFERENCES `bibliouned`.`Biblioteca` (`id`),
  CONSTRAINT `fk_UsuarioExterno_Usuario`
    FOREIGN KEY (`Usuario_id`)
    REFERENCES `bibliouned`.`Usuario` (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`UsuarioExterno` (`id` ASC);

CREATE INDEX `fk_UsuarioExterno_Biblioteca_idx` ON `bibliouned`.`UsuarioExterno` (`Biblioteca_id` ASC);

CREATE INDEX `fk_UsuarioExterno_Usuario_idx` ON `bibliouned`.`UsuarioExterno` (`Usuario_id` ASC);