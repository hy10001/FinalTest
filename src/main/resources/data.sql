CREATE DATABASE canteen_management;
USE canteen_management;

-- 用户表
CREATE TABLE users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('admin', 'staff') NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 菜品表
CREATE TABLE dishes (
                        dish_id INT PRIMARY KEY AUTO_INCREMENT,
                        dish_name VARCHAR(100) NOT NULL,
                        price DECIMAL(10,2) NOT NULL,
                        category VARCHAR(50) NOT NULL,
                        status ENUM('available', 'unavailable') DEFAULT 'available',
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 订单主表
CREATE TABLE orders (
                        order_id INT PRIMARY KEY AUTO_INCREMENT,
                        total_amount DECIMAL(10,2) NOT NULL,
                        status ENUM('pending', 'completed', 'cancelled') DEFAULT 'pending',
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 订单详情表
CREATE TABLE order_details (
                               detail_id INT PRIMARY KEY AUTO_INCREMENT,
                               order_id INT,
                               dish_id INT,
                               quantity INT NOT NULL,
                               price DECIMAL(10,2) NOT NULL,
                               FOREIGN KEY (order_id) REFERENCES orders(order_id),
                               FOREIGN KEY (dish_id) REFERENCES dishes(dish_id)
);

-- 库存表
CREATE TABLE inventory (
                           inventory_id INT PRIMARY KEY AUTO_INCREMENT,
                           item_name VARCHAR(100) NOT NULL,
                           category VARCHAR(50) NOT NULL,
                           quantity DECIMAL(10,2) NOT NULL,
                           unit VARCHAR(20) NOT NULL,
                           status ENUM('normal', 'warning', 'shortage') DEFAULT 'normal',
                           last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 库存记录表（出入库记录）
CREATE TABLE inventory_records (
                                   record_id INT PRIMARY KEY AUTO_INCREMENT,
                                   inventory_id INT,
                                   type ENUM('in', 'out') NOT NULL,
                                   quantity DECIMAL(10,2) NOT NULL,
                                   unit_price DECIMAL(10,2),
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);

-- 财务记录表
CREATE TABLE financial_records (
                                   record_id INT PRIMARY KEY AUTO_INCREMENT,
                                   type ENUM('income', 'expense') NOT NULL,
                                   amount DECIMAL(10,2) NOT NULL,
                                   category VARCHAR(50) NOT NULL,
                                   description TEXT,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);