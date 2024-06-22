USE master;
GO
CREATE DATABASE Minecraft;
GO
USE Minecraft;
GO
-- #### Liên quan tới sản phẩm ####
CREATE TABLE Gameplay(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);
CREATE TABLE Platform(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);
CREATE TABLE Version(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);
-- Create the Mouse table
CREATE TABLE Product(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price INT,
    gameplay_id INT,
    version_id INT,
    platform_id INT,
    FOREIGN KEY (gameplay_id) REFERENCES Gameplay(id),
    FOREIGN KEY (version_id) REFERENCES Version(id),
    FOREIGN KEY (platform_id) REFERENCES Platform(id),
);
-- Insert data into Product table
INSERT INTO Product
    (name, description, price, gameplay_id, platform_id, version_id)
VALUES
    ('Minecraft', '', 1790000, 1, 1, 1)
-- Tạo bảng Account
CREATE TABLE Account(
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    avt VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    sex VARCHAR(10),
    status INT
);

-- Thêm dữ liệu vào bảng Account
INSERT INTO Account
    (username, password, name, email, phone, sex, status)
VALUES
    ('admin', '123', N'Quản Trị Viên', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1),
    ('user', '123', N'Người Dùng', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1);
