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
-- Table `bibliouned`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`User` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `active` BOOLEAN NOT NULL DEFAULT 1,
  `password` VARCHAR(60) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `Biblioteca_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_User_Biblioteca`
    FOREIGN KEY (`Biblioteca_id`)
    REFERENCES `bibliouned`.`Biblioteca` (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`User` (`id` ASC);

CREATE UNIQUE INDEX `usuario_UNIQUE` ON `bibliouned`.`User` (`usuario` ASC);

CREATE INDEX `usuario_pass` ON `bibliouned`.`User` (`usuario` ASC, `password` ASC);

CREATE INDEX `fk_User_Biblioteca_idx` ON `bibliouned`.`User` (`Biblioteca_id` ASC);

CREATE TABLE IF NOT EXISTS `bibliouned`.`UserRoles` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  `User_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_UserRoles_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `bibliouned`.`User` (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`UserRoles` (`id` ASC);
    
-- -----------------------------------------------------
-- Table `bibliouned`.`UserExterno`
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
  `foto` blob NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `Biblioteca_id` BIGINT(10) NULL,
  `User_id` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_UserExterno_Biblioteca`
    FOREIGN KEY (`Biblioteca_id`)
    REFERENCES `bibliouned`.`Biblioteca` (`id`),
  CONSTRAINT `fk_UsuarioExterno_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `bibliouned`.`User` (`id`));
    
CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`UsuarioExterno` (`id` ASC);

CREATE INDEX `fk_UsuarioExterno_Biblioteca_idx` ON `bibliouned`.`UsuarioExterno` (`Biblioteca_id` ASC);

CREATE INDEX `fk_UsuarioExterno_User_idx` ON `bibliouned`.`UsuarioExterno` (`User_id` ASC);
-- Prueba git
INSERT INTO BIBLIOTECA (Identificador,Nombre,Direccion) VALUES ('ITU','Iturralde','asdf');
INSERT INTO USER (Usuario,Password,Active,Biblioteca_id) VALUES ('asdf','$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.','1','1');  -- Usuario asdf con pass 123456
INSERT INTO USERROLES (User_id,Role) VALUES(1,'ROLE_USER');