-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MyTrainingApp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MyTrainingApp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MyTrainingApp` DEFAULT CHARACTER SET utf8 ;
USE `MyTrainingApp` ;

-- -----------------------------------------------------
-- Table `MyTrainingApp`.`AppMember`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyTrainingApp`.`AppMember` (
  `userName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `age` INT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`userName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyTrainingApp`.`Workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyTrainingApp`.`Workout` (
  `workoutID` INT NOT NULL AUTO_INCREMENT,
  `type` CHAR NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(300) NULL,
  PRIMARY KEY (`workoutID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyTrainingApp`.`WorkoutSession`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyTrainingApp`.`WorkoutSession` (
  `SessionID` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `workoutID` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`SessionID`),
  INDEX `fk_AppMember_has_Workout_Workout1_idx` (`workoutID` ASC) VISIBLE,
  INDEX `fk_AppMember_has_Workout_AppMember_idx` (`userName` ASC) VISIBLE,
  CONSTRAINT `fk_AppMember_has_Workout_AppMember`
    FOREIGN KEY (`userName`)
    REFERENCES `MyTrainingApp`.`AppMember` (`userName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AppMember_has_Workout_Workout1`
    FOREIGN KEY (`workoutID`)
    REFERENCES `MyTrainingApp`.`Workout` (`workoutID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MyTrainingApp`.`WorkoutSets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MyTrainingApp`.`WorkoutSets` (
  `WorkoutSetsID` INT NOT NULL AUTO_INCREMENT,
  `SessionID` INT NOT NULL,
  `weight` INT NOT NULL,
  `reps` INT NOT NULL,
  PRIMARY KEY (`WorkoutSetsID`),
  INDEX `fk_WorkoutSets_WorkoutSession1_idx` (`SessionID` ASC) VISIBLE,
  CONSTRAINT `fk_WorkoutSets_WorkoutSession1`
    FOREIGN KEY (`SessionID`)
    REFERENCES `MyTrainingApp`.`WorkoutSession` (`SessionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
