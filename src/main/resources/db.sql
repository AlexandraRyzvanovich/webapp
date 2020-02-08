CREATE DATABASE fitnessdb;

USE fitnessdb;

CREATE TABLE user
(
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name NVARCHAR(63) NULL,
    last_name  NVARCHAR(63) NULL,
    email      NVARCHAR(63) NOT NULL UNIQUE,
    password   VARCHAR(32)  NOT NULL,
    bonus      INT UNSIGNED NULL,
    trainer_id INT UNSIGNED NULL,
    role       ENUM ('CLIENT', 'TRAINER', 'ADMIN'),
    PRIMARY KEY (id),
    FOREIGN KEY (trainer_id) REFERENCES user (id)
);

CREATE TABLE program
(
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id    INT UNSIGNED NOT NULL,
    diet       ENUM ('VEGAN', 'LOW CARB', 'ULTRA LOW FAT', 'HCG') NULL,
    start_date DATETIME NOT NULL,
    end_date   DATETIME NOT NULL,
    status     ENUM ('NEW', 'IN PROGRESS', 'DONE', 'DECLINED') NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE exercise
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE training_program
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    program_id  INT UNSIGNED NOT NULL,
    exercise_id INT UNSIGNED NOT NULL,
    frequency   INT UNSIGNED NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (exercise_id) REFERENCES exercise (id),
    FOREIGN KEY (program_id) REFERENCES program (id)
);

CREATE TABLE review
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    review_msg  varchar(255),
    star        INT          NOT NULL,
    date        DATE         NOT NULL,
    is_approved BOOLEAN      NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE subscription
(
    id           INT UNSIGNED  NOT NULL AUTO_INCREMENT,
    name         VARCHAR(32)   NOT NULL,
    description  NVARCHAR(255) NOT NULL,
    period_valid INT UNSIGNED  NOT NULL,
    price        DECIMAL(5, 2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id         INT UNSIGNED NOT NULL,
    paid_date       DATETIME NOT NULL,
    amount          DECIMAL(5, 2) NOT NULL,
    status          ENUM ('PROCESSED', 'DECLINED') NOT NULL,
    subscription_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (subscription_id) references subscription (id)
);