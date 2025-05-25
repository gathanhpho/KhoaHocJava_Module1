-- Tạo cơ sở dữ liệu shop_book2
CREATE DATABASE shop_book2;
USE shop_book2;

-- Tạo bảng roles
CREATE TABLE roles (
                       id BIGINT PRIMARY KEY,
                       role_name VARCHAR(255)
);

-- Tạo bảng users
CREATE TABLE users (
                       id BIGINT PRIMARY KEY,
                       username VARCHAR(255),
                       password VARCHAR(255)
);

-- Tạo bảng user_roles (mối quan hệ nhiều-nhiều giữa users và roles)
CREATE TABLE user_roles (
                            user_id BIGINT,
                            role_id BIGINT,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Tạo bảng categories
CREATE TABLE categories (
                            id INT PRIMARY KEY,
                            category_name VARCHAR(255),
                            description VARCHAR(255)
);

-- Tạo bảng products
CREATE TABLE products (
                          id INT PRIMARY KEY,
                          title VARCHAR(255),
                          author VARCHAR(255),
                          page_count INT,
                          publisher VARCHAR(255),
                          publication_year INT,
                          genre VARCHAR(255),
                          price DOUBLE,
                          discount DOUBLE,
                          stock_quantity INT,
                          description VARCHAR(255),
                          book_title VARCHAR(255),
                          image VARCHAR(255),
                          pageCount INT,
                          publicationYear INT,
                          stockQuantity INT,
                          category_id INT,
                          FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Tạo bảng identity_cards
CREATE TABLE identity_cards (
                                id BIGINT PRIMARY KEY,
                                date_of_birth VARCHAR(255),
                                full_name VARCHAR(255),
                                identity_number VARCHAR(255),
                                user_id BIGINT,
                                FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tạo bảng production (giả định là bảng bổ sung, cần thêm thông tin nếu có)
CREATE TABLE production (
                            id INT PRIMARY KEY,
                            title VARCHAR(255),
                            author VARCHAR(255),
                            description VARCHAR(255),
                            genre VARCHAR(255),
                            publisher VARCHAR(1000),
                            publication_year INT,
                            page_count INT,
                            price DECIMAL(10, 2),
                            discount_percent DECIMAL(5, 2),
                            stock_quantity INT,
                            category_id INT,
                            FOREIGN KEY (category_id) REFERENCES categories(id)
);

USE shop_book2;

-- Thêm dữ liệu vào bảng roles
INSERT INTO roles (id, role_name) VALUES
                                      (1, 'ADMIN'),
                                      (2, 'USER'),
                                      (3, 'MODERATOR');

-- Thêm dữ liệu vào bảng users
INSERT INTO users (id, username, password) VALUES
                                               (1, 'admin_user', 'admin123'),
                                               (2, 'john_doe', 'johnpass'),
                                               (3, 'jane_smith', 'janepass');

-- Thêm dữ liệu vào bảng user_roles (liên kết users và roles)
INSERT INTO user_roles (user_id, role_id) VALUES
                                              (1, 1), -- admin_user là ADMIN
                                              (2, 2), -- john_doe là USER
                                              (3, 2), -- jane_smith là USER
                                              (3, 3); -- jane_smith cũng là MODERATOR

-- Thêm dữ liệu vào bảng categories
INSERT INTO categories (id, category_name, description) VALUES
                                                            (1, 'Fiction', 'Novels and fictional stories'),
                                                            (2, 'Non-Fiction', 'Biographies and factual books'),
                                                            (3, 'Science', 'Books on scientific topics');

-- Thêm dữ liệu vào bảng products
INSERT INTO products (id, title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, book_title, image, pageCount, publicationYear, stockQuantity, category_id) VALUES
                                                                                                                                                                                                                      (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 180, 'Scribner', 1925, 'Fiction', 15.99, 0.1, 50, 'A classic novel about the American Dream', 'The Great Gatsby', 'great_gatsby.jpg', 180, 1925, 50, 1),
                                                                                                                                                                                                                      (2, 'Sapiens', 'Yuval Noah Harari', 443, 'Harper', 2014, 'Non-Fiction', 20.50, 0.15, 30, 'A brief history of humankind', 'Sapiens', 'sapiens.jpg', 443, 2014, 30, 2),
                                                                                                                                                                                                                      (3, 'A Brief History of Time', 'Stephen Hawking', 256, 'Bantam', 1988, 'Science', 18.75, 0.2, 20, 'Exploration of cosmology', 'A Brief History of Time', 'brief_history.jpg', 256, 1988, 20, 3);

-- Thêm dữ liệu vào bảng identity_cards
INSERT INTO identity_cards (id, date_of_birth, full_name, identity_number, user_id) VALUES
                                                                                        (1, '1990-05-15', 'Admin User', '123456789', 1),
                                                                                        (2, '1995-08-22', 'John Doe', '987654321', 2),
                                                                                        (3, '1992-03-10', 'Jane Smith', '456789123', 3);

-- Thêm dữ liệu vào bảng production
INSERT INTO production (id, title, author, description, genre, publisher, publication_year, page_count, price, discount_percent, stock_quantity, category_id) VALUES
                                                                                                                                                                  (1, '1984', 'George Orwell', 'A dystopian novel about totalitarianism', 'Fiction', 'Penguin Books', 1949, 328, 14.99, 0.1, 40, 1),
                                                                                                                                                                  (2, 'Educated', 'Tara Westover', 'A memoir about education and self-discovery', 'Non-Fiction', 'Random House', 2018, 352, 22.00, 0.12, 25, 2),
                                                                                                                                                                  (3, 'The Selfish Gene', 'Richard Dawkins', 'A book on evolutionary biology', 'Science', 'Oxford University Press', 1976, 224, 16.50, 0.18, 15, 3);