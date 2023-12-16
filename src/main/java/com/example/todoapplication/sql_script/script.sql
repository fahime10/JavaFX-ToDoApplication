CREATE TABLE `todo_db`.`user` (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

CREATE TABLE `todo_db`.`task` (
  `task_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `task` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `date_created` DATETIME NOT NULL,
  PRIMARY KEY (`task_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `todo_db`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);