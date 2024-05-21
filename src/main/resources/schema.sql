-- Creating MySQL Database
DROP DATABASE IF EXISTS stock_manager;

CREATE DATABASE stock_manager;

USE stock_manager;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS stock_status;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE user (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password CHAR(80) NOT NULL,
    enabled SMALLINT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(80) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE role (
    id INT(11) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
    user_id INT(11) NOT NULL,
    role_id INT(11) NOT NULL,

    PRIMARY KEY (user_id, role_id),
    CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES user(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT FK_ROLE FOREIGN KEY (role_id) REFERENCES role(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE message (
    id INT AUTO_INCREMENT,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(700) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read SMALLINT NOT NULL DEFAULT FALSE,

    PRIMARY KEY (id),
    FOREIGN KEY (sender_id) REFERENCES user(id) ON DELETE CASCADE,
    FOREIGN KEY (receiver_id) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE category (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(50) DEFAULT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    code CHAR(14) NOT NULL,
    name VARCHAR(50) NOT NULL,
    category_id INT NOT NULL,
    quantity_in_stock INT(6) NOT NULL,
    cost_price DEC(8,2) NOT NULL,
    sale_price DEC(8,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_at TIMESTAMP DEFAULT NULL,

    UNIQUE (code),
    PRIMARY KEY (id),
    CONSTRAINT FK_CATEGORY FOREIGN KEY (category_id) REFERENCES category(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE stock_status (
    id INT,
    current_stock_capacity INT,
    previous_stock_capacity INT,
    current_product_amount INT,
    previous_product_amount INT,
    current_total_value DOUBLE,
    previous_total_value DOUBLE,
    occupancy_rate DEC(5,2),
    updated_at TIMESTAMP,

    PRIMARY KEY (id)
);