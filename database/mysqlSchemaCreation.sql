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
  `Nombre` VARCHAR(256) NULL,
  `Direccion` VARCHAR(256) NULL,
  PRIMARY KEY (`id`));

CREATE UNIQUE INDEX `id_UNIQUE` ON `bibliouned`.`Biblioteca` (`id` ASC);


-- -----------------------------------------------------
-- Table `bibliouned`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`User` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(64) NULL,
  `apellidos` VARCHAR(128) NULL,
  `usuario` VARCHAR(64) NOT NULL,
  `email` VARCHAR(256) NULL,
  `active` BOOLEAN NOT NULL DEFAULT 1,
  `password` VARCHAR(64) NOT NULL,
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
-- Table `bibliouned`.`UsuarioExterno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliouned`.`UsuarioExterno` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(15) NULL,
  `nombre` VARCHAR(64) NULL,
  `apellido1` VARCHAR(64) NULL,
  `apellido2` VARCHAR(64) NULL,
  `nif_pasaporte` VARCHAR(15) NULL,
  `mail` VARCHAR(128) NULL,
  `telefono` VARCHAR(15) NULL,
  `localidad` VARCHAR(64) NULL,
  `codigopostal` VARCHAR(5) NULL,
  `direccion` VARCHAR(256) NULL,
  `observaciones` VARCHAR(256) NULL,
  `foto` VARCHAR(256) NULL,
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

INSERT INTO BIBLIOTECA (Identificador,Nombre,Direccion) VALUES ('ITU','Iturralde','asdf');
INSERT INTO USER (Nombre,Apellidos,Email,Usuario,Password,Active,Biblioteca_id) VALUES ('asdf','ghjk','jjj@asdf.com','prueba','$2a$10$Jq.5lT0D6V6baokkfO9nU.4cgXMeaz16xL/tBR9MMJ4rlZxtO1OP2','1','1');  -- Usuario asdf con pass 123456
INSERT INTO USERROLES (User_id,Role) VALUES(1,'ROLE_USER');