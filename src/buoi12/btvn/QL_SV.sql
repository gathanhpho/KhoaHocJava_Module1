-- 1. Tạo cơ sở dữ liệu
CREATE
DATABASE QL_SINHVIEN;

USE
QL_SINHVIEN;

-- 2. Tạo các bảng
CREATE TABLE SinhVien
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    ho_ten          VARCHAR(100) NOT NULL,
    ngay_sinh       DATE,
    gioi_tinh       VARCHAR(10),
    dia_chi         VARCHAR(200),
    email           VARCHAR(100) UNIQUE,
    diem_trung_binh DECIMAL(4, 2)
);

CREATE TABLE MonHoc
(
    id_mon     INT PRIMARY KEY AUTO_INCREMENT,
    ten_mon    VARCHAR(100),
    so_tin_chi INT
);

CREATE TABLE DiemThi
(
    id_diem     INT PRIMARY KEY AUTO_INCREMENT,
    id_sinhvien INT,
    id_mon      INT,
    diem        DECIMAL(4, 2),
    FOREIGN KEY (id_sinhvien) REFERENCES SinhVien (id),
    FOREIGN KEY (id_mon) REFERENCES MonHoc (id_mon)
);

-- 3. Thêm dữ liệu
-- Thêm sinh viên
INSERT INTO SinhVien (ho_ten, ngay_sinh, gioi_tinh, dia_chi, email, diem_trung_binh)
VALUES ('Nguyễn Văn A', '2000-05-15', 'Nam', 'Hà Nội', 'nguyenvana@gmail.com', 8.5),
       ('Trần Thị B', '2001-08-20', 'Nữ', 'TP.HCM', 'tranthib@yahoo.com', 7.8),
       ('Lê Văn C', '2000-12-10', 'Nam', 'Đà Nẵng', 'levanc@gmail.com', 6.5),
       ('Phạm Thị D', '2001-03-25', 'Nữ', 'Huế', 'phamthid@gmail.com', 8.9),
       ('Hoàng Văn E', '2000-09-30', 'Nam', 'Hải Phòng', 'hoangvane@yahoo.com', 7.2);

-- Thêm môn học
INSERT INTO MonHoc (ten_mon, so_tin_chi)
VALUES ('Toán Cao Cấp', 3),
       ('Lập Trình Cơ Bản', 4),
       ('Cơ Sở Dữ Liệu', 3);

-- Thêm điểm thi
INSERT INTO DiemThi (id_sinhvien, id_mon, diem)
VALUES (1, 1, 8.5),
       (2, 3, 7.5),
       (3, 2, 9.0),
       (4, 3, 8.0),
       (5, 1, 7.5);

-- 4. Cập nhật dữ liệu
-- Cập nhật điểm trung bình sinh viên id=3
UPDATE SinhVien
SET diem_trung_binh = 5.3
WHERE id = 3;
-- Cập nhật điểm thi sinh viên id=3 môn học id_mon=2
UPDATE DiemThi
SET diem = 5.0
WHERE id_sinhvien = 3
  AND id_mon = 2;

-- 5. Truy vấn dữ liệu
-- Liệt kê tất cả sinh viên
SELECT *
FROM SinhVien;

-- Liệt kê tất cả môn học
SELECT *
FROM MonHoc;

-- Hiển thị tên sinh viên, môn học và điểm thi
SELECT sv.ho_ten, mh.ten_mon, dt.diem
FROM SinhVien sv
         JOIN DiemThi dt ON sv.id = dt.id_sinhvien
         JOIN MonHoc mh ON mh.id_mon = dt.id_mon;

-- Sinh viên có điểm trung bình > 8.0
SELECT *
FROM SinhVien
WHERE diem_trung_binh > 8.0;

-- Môn học có điểm thi < 5.0
SELECT DISTINCT mh.ten_mon
FROM MonHoc mh
         JOIN DiemThi dt ON mh.id_mon = dt.id_mon
WHERE dt.diem < 5.0;