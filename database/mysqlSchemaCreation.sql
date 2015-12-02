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
  `provincia` VARCHAR(64) NULL,
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

INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('1','EPI','Escuelas Pías','C/ Sombrerete nº 15.  28012 – Madrid');
INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('2','JVE','Jacinto Verdaguer','C/ Fuente de Lima nº 22.  28024 – Madrid.');
INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('3','GRI','Giner de los Ríos','C/ Francos Rodríguez nº 77.  28039 – Madrid.');
INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('4','TAB','Las Tablas','Avda. de Santo Domingo de la Calzada nº 9.  28050 – Madrid');
INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('5','GMA','Gregorio Marañón','C/ Argumosa nº 3.  28012 – Madrid.');
INSERT INTO BIBLIOTECA (Id,Identificador,Nombre,Direccion) VALUES ('6','ROZ','Las Rozas','Ctra. de las Rozas al Escorial Km 5. 28230 Las Rozas – Madrid');
INSERT INTO USER (Id,Nombre,Apellidos,Email,Usuario,Password,Active,Biblioteca_id) VALUES ('1','asdf','ghjk','jjj@asdf.com','prueba','$2a$10$Jq.5lT0D6V6baokkfO9nU.4cgXMeaz16xL/tBR9MMJ4rlZxtO1OP2','1','1');  -- Usuario prueba con pass 123456
INSERT INTO USER (Id,Nombre,Apellidos,Email,Usuario,Password,Active,Biblioteca_id) VALUES ('2','asdf','ghjk','jjj@asdf.com','EPias','$2a$10$Jq.5lT0D6V6baokkfO9nU.4cgXMeaz16xL/tBR9MMJ4rlZxtO1OP2','1','1');  -- Usuario EPias con pass 123456
INSERT INTO USER (Id,Nombre,Apellidos,Email,Usuario,Password,Active,Biblioteca_id) VALUES ('3','asdf','ghjk','jjj@asdf.com','GMarañon','$2a$10$Jq.5lT0D6V6baokkfO9nU.4cgXMeaz16xL/tBR9MMJ4rlZxtO1OP2','1','5');  -- Usuario GMarañon con pass 123456
INSERT INTO USERROLES (User_id,Role) VALUES('1','ROLE_USER');
INSERT INTO USERROLES (User_id,Role) VALUES('2','ROLE_USER');
INSERT INTO USERROLES (User_id,Role) VALUES('3','ROLE_USER');