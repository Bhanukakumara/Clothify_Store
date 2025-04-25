# Clothing Store Management System

## Project Overview
The **Clothing Store Management System** is a JavaFX application designed to automate the operations of a clothing store. The system includes functionality for managing users (employees and admins), products, inventory, suppliers, employees, and orders. It provides an admin interface for the store owner to manage all aspects of the store and a default interface for employees to perform sales and other tasks.

## Features
- **User Management**
    - Admin can register users (employees and other admins).
    - Users can reset their password using OTP sent via email.
    - Admin and employees can log in with email and password.

- **Product Management**
    - Admin and employees can add new products to the store.
    - Products are categorized into Ladies, Gents, and Kids sections.
    - Each product has details such as ID, name, size, price, and quantity.

- **Inventory Management**
    - Admin and employees can update product stock.
    - The system tracks available stock and updates in real-time.
    - Order returns update the inventory.

- **Supplier Management**
    - Admin can add, update, or delete suppliers.
    - View details of the items provided by each supplier.

- **Employee Management**
    - Admin can manage employee details (add, update, delete).

- **Order Management**
    - Admin and employees can place orders.
    - Orders contain details like order ID, items purchased, total cost, and payment type.
    - Receipts are sent to customers via email.

- **Reports**
    - Admin can generate daily, monthly, and annual sales reports.
    - Reports are shown using charts (line charts and pie charts).
    - Admin can generate inventory, employee, and supplier reports.

## Technologies Used
- **JavaFX**: For building the graphical user interface (GUI).
- **Java 8**: Programming language for backend logic.
- **MySQL**: Database for storing user, product, order, and other details.
- **Jasper Reports**: For generating reports in the system.
- **JDBC**: To interact with the MySQL database from Java.

## Database Schema

```sql
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    size VARCHAR(50),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(50) NOT NULL,
    image_url VARCHAR(255),
    supplier_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_cost DECIMAL(10, 2) NOT NULL,
    payment_type VARCHAR(50) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


