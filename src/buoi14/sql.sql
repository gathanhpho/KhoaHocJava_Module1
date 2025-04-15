CREATE DATABASE QL_SP;

use QL_SP;

create table company_info
(
    id      integer PRIMARY KEY auto_increment,
    ten     nvarchar(50),
    dia_chi nvarchar(255) not null,
    phone   int(10)
);

create table social
(
    id   integer PRIMARY KEY,
    company_info_id int,
    link varchar(255)
);

create table branch
(
    id   integer PRIMARY KEY,
    link varchar(255)
);

CREATE TABLE category
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    ten             VARCHAR(255),
    category_parent INT
);

CREATE TABLE production
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    ten         VARCHAR(255),
    gia         DECIMAL(10, 2),
    mo_ta       TEXT,
    so_luong    INT,
    category_id INT
);

-- Bảng image
CREATE TABLE image
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    path      VARCHAR(255),
    extention VARCHAR(20)
);

-- Bảng trung gian production_image
CREATE TABLE production_image
(
    production_id INT,
    image_id      INT,
    PRIMARY KEY (production_id, image_id)
);

-- Bảng size
CREATE TABLE size
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    ten  VARCHAR(50),
    ma   VARCHAR(50),
    type VARCHAR(50)
);

-- Bảng trung gian production_size
CREATE TABLE production_size
(
    production_id INT,
    size_id       INT,
    PRIMARY KEY (production_id, size_id)
);

-- Bảng color
CREATE TABLE color
(
    id  INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(50),
    ma  VARCHAR(50)
);

ALTER TABLE social
ADD CONSTRAINT fk_social_company
FOREIGN KEY (company_info_id) REFERENCES company_info(id);

ALTER TABLE category
    ADD CONSTRAINT fk_category_parent
        FOREIGN KEY (category_parent) REFERENCES category (id);

ALTER TABLE production
    ADD CONSTRAINT fk_production_category
        FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE production_image
    ADD CONSTRAINT fk_pi_production
        FOREIGN KEY (production_id) REFERENCES production (id),
    ADD CONSTRAINT fk_pi_image
        FOREIGN KEY (image_id) REFERENCES image (id);

ALTER TABLE production_size
    ADD CONSTRAINT fk_ps_production
        FOREIGN KEY (production_id) REFERENCES production (id),
    ADD CONSTRAINT fk_ps_size
        FOREIGN KEY (size_id) REFERENCES size (id);
