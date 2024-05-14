CREATE DATABASE IF NOT EXISTS SocketApplication;
USE SocketApplication;

CREATE TABLE IF NOT EXISTS Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL
);


CREATE TABLE IF NOT EXISTS TextMessages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender_id INT NOT NULL,
    sendTime DATETIME NOT NULL,
    message TEXT NOT NULL,
);