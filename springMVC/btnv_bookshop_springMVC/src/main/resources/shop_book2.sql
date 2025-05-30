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
INSERT INTO products (id, title, author, page_count, publisher, publication_year, genre, price, discount, stock_quantity, description, book_title, image, pageCount, publicationYear, stockQuantity, category_id) VALUES
                                                                                                                                                                                                                      (4, '1984', 'George Orwell', 328, 'Secker & Warburg', 1949, 'Dystopian', 12.99, 0.1, 40, 'A dystopian social science fiction novel', '1984', '1984.jpg', 328, 1949, 40, 1),
                                                                                                                                                                                                                      (5, 'To Kill a Mockingbird', 'Harper Lee', 281, 'J.B. Lippincott & Co.', 1960, 'Classic', 14.99, 0.2, 35, 'A novel about racial injustice in the Deep South', 'To Kill a Mockingbird', 'mockingbird.jpg', 281, 1960, 35, 1),
                                                                                                                                                                                                                      (6, 'The Selfish Gene', 'Richard Dawkins', 360, 'Oxford University Press', 1976, 'Science', 17.25, 0.1, 25, 'Explores the gene-centered view of evolution', 'The Selfish Gene', 'selfish_gene.jpg', 360, 1976, 25, 3),
                                                                                                                                                                                                                      (7, 'Thinking, Fast and Slow', 'Daniel Kahneman', 499, 'Farrar, Straus and Giroux', 2011, 'Psychology', 19.99, 0.15, 22, 'Insights into how we think', 'Thinking, Fast and Slow', 'thinking_fast_slow.jpg', 499, 2011, 22, 2),
                                                                                                                                                                                                                      (8, 'The Catcher in the Rye', 'J.D. Salinger', 277, 'Little, Brown and Company', 1951, 'Fiction', 13.50, 0.1, 18, 'A story about teenage alienation', 'The Catcher in the Rye', 'catcher_rye.jpg', 277, 1951, 18, 1),
                                                                                                                                                                                                                      (9, 'The Alchemist', 'Paulo Coelho', 208, 'HarperOne', 1988, 'Fiction', 16.00, 0.2, 28, 'A philosophical story about following your dreams', 'The Alchemist', 'alchemist.jpg', 208, 1988, 28, 1),
                                                                                                                                                                                                                      (10, 'Brief Answers to the Big Questions', 'Stephen Hawking', 256, 'Bantam', 2018, 'Science', 18.00, 0.1, 30, 'Final thoughts of Stephen Hawking', 'Brief Answers to the Big Questions', 'brief_answers.jpg', 256, 2018, 30, 3),
                                                                                                                                                                                                                      (11, 'The Subtle Art of Not Giving a F*ck', 'Mark Manson', 224, 'HarperOne', 2016, 'Self-help', 15.95, 0.2, 34, 'A counterintuitive approach to living a good life', 'The Subtle Art of Not Giving a F*ck', 'subtle_art.jpg', 224, 2016, 34, 2),
                                                                                                                                                                                                                      (12, 'Educated', 'Tara Westover', 334, 'Random House', 2018, 'Memoir', 17.50, 0.15, 29, 'A memoir about growing up off the grid', 'Educated', 'educated.jpg', 334, 2018, 29, 2),
                                                                                                                                                                                                                      (13, 'The Road', 'Cormac McCarthy', 287, 'Alfred A. Knopf', 2006, 'Post-apocalyptic', 14.00, 0.1, 16, 'A journey of father and son in a bleak world', 'The Road', 'the_road.jpg', 287, 2006, 16, 1),
                                                                                                                                                                                                                      (14, 'Man’s Search for Meaning', 'Viktor E. Frankl', 200, 'Beacon Press', 1946, 'Psychology', 13.99, 0.15, 27, 'A Holocaust survivor’s insight into finding purpose', 'Man’s Search for Meaning', 'search_meaning.jpg', 200, 1946, 27, 2),
                                                                                                                                                                                                                      (15, 'Zero to One', 'Peter Thiel', 224, 'Crown Business', 2014, 'Business', 18.00, 0.1, 19, 'Notes on startups and the future', 'Zero to One', 'zero_to_one.jpg', 224, 2014, 19, 2),
                                                                                                                                                                                                                      (16, 'Atomic Habits', 'James Clear', 320, 'Penguin Random House', 2018, 'Self-help', 21.00, 0.2, 42, 'An easy way to build good habits and break bad ones', 'Atomic Habits', 'atomic_habits.jpg', 320, 2018, 42, 2),
                                                                                                                                                                                                                      (17, 'The Hobbit', 'J.R.R. Tolkien', 310, 'George Allen & Unwin', 1937, 'Fantasy', 15.00, 0.1, 45, 'A fantasy adventure novel', 'The Hobbit', 'hobbit.jpg', 310, 1937, 45, 1),
                                                                                                                                                                                                                      (18, 'Cosmos', 'Carl Sagan', 384, 'Random House', 1980, 'Science', 20.00, 0.2, 24, 'A personal voyage through the universe', 'Cosmos', 'cosmos.jpg', 384, 1980, 24, 3);
