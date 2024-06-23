USE master;
GO
CREATE DATABASE Minecraft;
GO
USE Minecraft;
GO
-- Category for products
CREATE TABLE Gameplay
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);
CREATE TABLE Platform
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);
CREATE TABLE Version
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

-- Create the Product table
CREATE TABLE Product
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price INT,
);
CREATE TABLE Product_Gameplay
(
    product_id INT,
    gameplay_id INT,
    PRIMARY KEY (product_id, gameplay_id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (gameplay_id) REFERENCES Gameplay(id)
);

CREATE TABLE Product_Platform
(
    product_id INT,
    platform_id INT,
    PRIMARY KEY (product_id, platform_id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (platform_id) REFERENCES Platform(id)
);

CREATE TABLE Product_Version
(
    product_id INT,
    version_id INT,
    PRIMARY KEY (product_id, version_id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    FOREIGN KEY (version_id) REFERENCES Version(id)
);
CREATE TABLE ImageUrl
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_id INT,
    url TEXT,
    FOREIGN KEY (product_id) REFERENCES Product(id)
);
CREATE TABLE Account
(
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    avt VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    sex int,
    status INT
);
-- Insert data
INSERT INTO Gameplay
    (name)
VALUES('Sandbox Survival'),
    ('Adventure'),
    ('Dungeon Crawl'),
    ('Action RPG'),
    ('Strategy'),
    ('Education')

INSERT INTO Version
    (name)
VALUES('Single-player'),
    ('Multiplayer')

INSERT INTO Platform
    (name)
VALUES('WINDOW'),
    ('XBOX'),
    ('MAC'),
    ('LINUX'),
    ('PLAYSTATION'),
    ('NINTENDO'),
    ('ANDROID'),
    ('IOS'),
    ('CHROMEBOOK')

INSERT INTO Product
    (name, description,price)
VALUES('Minecraft', '', 1790000),
    ('Minecraft Dungeons', '', 1790000),
    ('Minecraft Legends', '', 1790000),
    ('Minecraft Education', '', 1790000)

INSERT INTO ImageUrl
    (product_id, url)
VALUES(1, 'https://www.minecraft.net/content/dam/minecraftnet/games/minecraft/key-art/Homepage_Discover-our-games_MC-Vanilla-KeyArt_864x864.jpg'),
    (2, 'https://www.minecraft.net/content/dam/minecraftnet/games/dungeons/key-art/Homepage_Discover-our-games_MC-Dungeons-KeyArt_864x864.jpg'),
    (3, 'https://www.minecraft.net/content/dam/minecraftnet/games/badger/key-art/Homepage_Discover-our-games_MC-Legends-KeyArt_864x864.jpg'),
    (4, 'https://www.minecraft.net/content/dam/minecraftnet/education-edition/key-art/Homepage_Discover-our-games_MC-Education-KeyArt_864x864.jpg')

INSERT INTO Account
    (username, password, name, email, phone, sex, status)
VALUES('admin', '123', N'Quản Trị Viên', 'khoacdpp02847@fpt.edu.vn', '0869938981', 1, 1),
    ('user', '123', N'Người Dùng', 'khoacdpp02847@fpt.edu.vn', '0869938981', 2, 1);