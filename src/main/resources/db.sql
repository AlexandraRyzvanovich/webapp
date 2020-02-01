CREATE DATABASE fitnessdb;

USE fitnessdb;

CREATE TABLE user (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name NVARCHAR(63) NULL,
  last_name  NVARCHAR(63) NULL,
  email      NVARCHAR(63) NOT NULL UNIQUE,
  password   VARCHAR (32) NOT NULL,
  bonus      INT UNSIGNED NULL,
  trainer_id INT UNSIGNED NULL,
  role       ENUM ('CLIENT', 'TRAINER', 'ADMIN'),
  PRIMARY KEY (id),
  FOREIGN KEY (trainer_id) REFERENCES user (id),
);

CREATE TABLE training_program (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id     INT UNSIGNED NOT NULL,
  exercise_description NVARCHAR(255) NULL,
  exercise_list NVARCHAR(255) NULL,
  diet_description     NVARCHAR(255) NULL,
  food_list NVARCHAR(255), null,
  additional_info NVARCHAR(255) NULL,
  status       ENUM('NEW', 'IN PROGRESS', 'DONE', 'DECLINED')  NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE review (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id    INT UNSIGNED NOT NULL,
  review_msg varchar(255),
  star INT NOT NULL,
  date DATE NOT NULL,
  is_approved BOOLEAN NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE subscription (
  id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  description NVARCHAR(255) NOT NULL,
  period INT UNSIGNED NOT NULL,
  price    DECIMAL(5, 2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE orders (
  id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id   INT UNSIGNED NOT NULL,
  paid_date DATETIME      NOT NULL,
  amount    DECIMAL(5, 2) NOT NULL,
  status    ENUM('NEW', 'PROCESSED', 'DECLINED')  NOT NULL,
  subscription_id  INT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (subscription_id) references subscription (id)
);