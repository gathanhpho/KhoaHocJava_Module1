package ktCuoiModule2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.khoiTaoNhanVienMacDinh();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị tất cả nhân viên");
            System.out.println("3. Thêm hoặc sửa lương");
            System.out.println("4. Tìm lương theo tên");
            System.out.println("5. Thêm phòng ban");
            System.out.println("6. Hiển thị tất cả phòng ban");
            System.out.println("7. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("8. Tìm nhân viên theo tên");
            System.out.println("9. Hiển thị lương đã tính phụ cấp cho từng nhân viên");
            System.out.println("10. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    System.out.print("Lương: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Là quản lý? (y/n): ");
                    String isManager = sc.nextLine();
                    if (isManager.equalsIgnoreCase("y")) {
                        System.out.print("Phòng ban: ");
                        String dept = sc.nextLine();
                        company.themMoiNhanVien(new Manager(name, age, salary, dept));
                    } else {
                        company.themMoiNhanVien(new Employee(name, age, salary));
                    }
                    break;
                case 2:
                    company.displayAllNhanVien();
                    break;
                case 3:
                    System.out.print("Tên nhân viên: ");
                    String n1 = sc.nextLine();
                    System.out.print("Lương mới: ");
                    double s1 = sc.nextDouble();
                    company.updateSalary(n1, s1);
                    break;
                case 4:
                    System.out.print("Tên nhân viên: ");
                    String searchName = sc.nextLine();
                    company.findLuongNhanVien(searchName);
                    break;
                case 5:
                    System.out.print("Tên phòng ban: ");
                    String newDept = sc.nextLine();
                    company.themPhongBan(newDept);
                    break;
                case 6:
                    company.displayAllDepartments();
                    break;
                case 7:
                    company.xapSepNVTheoLuong();
                    break;
                case 8:
                    System.out.print("Nhập tên nhân viên cần tìm: ");
                    String searchEmp = sc.nextLine();
                    company.findNvByTenNhanVien(searchEmp);
                    break;
                case 9:
                    System.out.println("--- Lương sau khi tính phụ cấp ---");
                    for (Employee e : company.getEmployees()) {
                        double luongThucNhan = luong(e); // sử dụng lambda
                        System.out.println(e.getName() + ": " + luongThucNhan);
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 10);

        sc.close();
    }

    public static double luong(Employee employee) {
        SalaryCalculation calculation = emp -> {
            if (emp instanceof Manager) {
                return emp.getSalary() + 1000;
            }
            return emp.getSalary()+ 300;
        };
        return calculation.calculateSalary(employee);
    }

    public static void newSalary(Employee employee, double newSalary) {
        try {
            employee.updateSalary(employee, newSalary);
            System.out.println("Cập nhập lương thành cng cho NV: " + employee.getName());
            employee.displayInfo();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
