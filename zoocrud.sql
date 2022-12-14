-- MySQL Script generated by MySQL Workbench
-- Mon Dec 12 19:45:09 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zoocrud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema zoocrud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zoocrud` DEFAULT CHARACTER SET utf8 ;
USE `zoocrud` ;

-- -----------------------------------------------------
-- Table `zoocrud`.`Animal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoocrud`.`Animal` (
  `idAnimal` INT NOT NULL ,
  `nome` VARCHAR(255) NOT NULL,
  `especie` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idAnimal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoocrud`.`Jaula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zoocrud`.`Jaula` (
  `idJaula` INT NOT NULL ,
  `nome` VARCHAR(255) NOT NULL,
  `tipo` VARCHAR(255) NOT NULL,
  `idAnimal` INT NOT NULL,
  PRIMARY KEY (`idJaula`),
  INDEX `fk_Jaula_Animal_idx` (`idAnimal` ASC) ,
  CONSTRAINT `fk_Jaula_Animal`
    FOREIGN KEY (`idAnimal`)
    REFERENCES `zoocrud`.`Animal` (`idAnimal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

