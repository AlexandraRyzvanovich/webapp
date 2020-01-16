CREATE DATABASE fitnessdb;

USE fitnessdb;

CREATE TABLE user (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name NVARCHAR(63) NULL,
  last_name  NVARCHAR(63) NULL,
  email      NVARCHAR(63) NOT NULL UNIQUE,
  password   CHAR(32) NOT NULL,
  role       TINYINT  NULL,
  bonus      TINYINT  NULL,
  PRIMARY KEY (id)
);

CREATE TABLE trainer (
  id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
  trainer_id INT UNSIGNED NULL,
  user_id INT UNSIGNED NOT NULL,
  start_date DATE    NOT NULL,
  end_date DATE    NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (trainer_id) REFERENCES user (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE diet_program (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  food_type  NVARCHAR(255) NOT NULL,
  description NVARCHAR(255) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE exercise_program (
  id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
  exercise_name NVARCHAR(255) NOT NULL,
  frequency     NVARCHAR(255) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE program (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id     INT UNSIGNED NOT NULL,
  exercise_id INT UNSIGNED NULL,
  diet_id     INT UNSIGNED NULL,
  valid_to    DATE    NOT NULL,
  status      TINYINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (exercise_id) REFERENCES exercise_program (id),
  FOREIGN KEY (diet_id) REFERENCES diet_program (id)
);

CREATE TABLE review (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id    INT UNSIGNED NOT NULL,
  review_msg varchar(255),
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE subscription (
  id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id   INT UNSIGNED NOT NULL,
  paid_date DATETIME      NOT NULL,
  valid_to  DATE          NULL,
  amount    DECIMAL(5, 2) NOT NULL,
  status    TINYINT       NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);
