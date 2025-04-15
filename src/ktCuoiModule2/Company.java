package ktCuoiModule2;

import java.util.*;

public class Company {
    private List<Employee> employees = new ArrayList<>();
    private HashMap<String, Double> salaryMap = new HashMap<>();
    private Set<String> departments = new HashSet<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void khoiTaoNhanVienMacDinh() {
        employees.add(new Employee("Nguyễn Văn B", 30, 3000.0));
        employees.add(new Employee("Trần Thị B", 25, 4000.0));
        employees.add(new Manager("Lê Văn C", 27, 4500.0, "Kế Toán"));
    }

    public void themMoiNhanVien(Employee employee) {
        employees.add(employee);
        salaryMap.put(employee.getName(), employee.getSalary());
        if (employee instanceof Manager) {
            departments.add(((Manager) employee).getDepartment());
        }
    }

    public void displayAllNhanVien() {
        employees.stream().forEach(employee -> {
            employee.displayInfo();
            System.out.println("----");
        });
    }

    public void updateSalary(String name, double newSalary) {
        employees.stream().forEach(employee -> {
            if (employee.getName().equals(name)) {
                try {
                    employee.updateSalary(employee, newSalary);
                    salaryMap.put(employee.getName(), newSalary);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void findLuongNhanVien(String name) {
        Double salary = salaryMap.get(name);
        if (salary != null) {
            System.out.println("Lương của " + name + ": " + salary);
        } else {
            System.out.println("Không tìm thấy nhân viên.");
        }
    }

    public void themPhongBan(String department) {
        departments.add(department);
    }

    public void displayAllDepartments() {
        departments.stream().forEach(department -> {
            System.out.println(department);
        });
    }

    public void xapSepNVTheoLuong() {
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        displayAllNhanVien();
    }

    public void findNvByTenNhanVien(String name) {
        employees.stream().filter(employee -> employee.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(employee ->
                        employee.displayInfo(), () -> System.out.println("Không tìm thấy nhân viên.")
                );
    }
}
