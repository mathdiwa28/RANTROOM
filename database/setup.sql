-- Create the database
CREATE DATABASE IF NOT EXISTS user_login_db;

-- Use the created database
USE user_login_db;

-- Create the users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    provider ENUM('google', 'facebook') DEFAULT NULL
);