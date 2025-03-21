package ktCuoiModule1.phan4;

import java.util.Arrays;
import java.util.Scanner;
/*
Câu 1 Viết chương trình nhập vào một mảng số nguyên từ người dùng và tìm ra giá trị lớn nhất và giá trị nhỏ nhất trong mảng.
In ra các giá trị này.
Yêu cầu:
1. Nhập vào số lượng phần tử mảng.
2. Nhập các phần tử mảng/
3. Tìm giá trị lớn nhất và giá trị nhỏ nhất và in ra kết quả.
4. Tính tổng các phần tử của mảng
5. Thêm 1 phần tử vào mảng với vị trí do người dùng nhập, nếu mảng không đủ ô nhớ sẽ tự động tăng thêm 100% ô nhớ hiện tại.
6. Cho người dùng nhập vào 1 phần tử, xóa đi tất cả các phần tử đó trong mảng
7. Tìm phần tử lớn thứ 3 trong mảng
*/
public class Cau1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập số lượng phần tử và mảng
        int[] arr = nhapMang(scanner);
        int elementCount = arr.length; // Số phần tử thực tế trong mảng

        // 2. Tìm giá trị lớn nhất và nhỏ nhất
        timMaxMin(arr, elementCount);

        // 3. Tính tổng các phần tử
        tinhTong(arr, elementCount);

        // 4. Thêm 1 phần tử vào mảng tại vị trí do người dùng nhập
        arr = themPhanTu(arr, elementCount, scanner);
        elementCount++;

        // 5. Xóa tất cả các phần tử có giá trị do người dùng nhập
        arr = xoaPhanTu(arr, elementCount, scanner);
        elementCount = tinhKichThuocSauXoa(arr, elementCount);

        // 6. Tìm phần tử lớn thứ 3 trong mảng
        timPhanTuLonThu3(arr, elementCount);

        // Đóng Scanner
        scanner.close();
    }

    // 1. Hàm nhập số lượng phần tử và mảng
    public static int[] nhapMang(Scanner scanner) {
        System.out.print("Nhập số lượng phần tử mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.print("Mảng ban đầu: ");
        inMang(arr, n);
        return arr;
    }

    // 2. Hàm tìm giá trị lớn nhất và nhỏ nhất
    public static void timMaxMin(int[] arr, int elementCount) {
        if (elementCount == 0) {
            System.out.println("Mảng rỗng, không thể tìm giá trị lớn nhất và nhỏ nhất.");
        } else {
            int max = arr[0];
            int min = arr[0];
            for (int i = 1; i < elementCount; i++) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];
            }
            System.out.println("Giá trị lớn nhất trong mảng: " + max);
            System.out.println("Giá trị nhỏ nhất trong mảng: " + min);
        }
    }

    // 3. Hàm tính tổng các phần tử
    public static void tinhTong(int[] arr, int elementCount) {
        int sum = 0;
        for (int i = 0; i < elementCount; i++) {
            sum += arr[i];
        }
        System.out.println("Tổng các phần tử của mảng: " + sum);
    }

    // 4. Hàm thêm 1 phần tử vào mảng tại vị trí do người dùng nhập
    public static int[] themPhanTu(int[] arr, int elementCount, Scanner scanner) {
        System.out.print("Nhập giá trị phần tử cần thêm: ");
        int newElement = scanner.nextInt();
        System.out.print("Nhập vị trí cần thêm (từ 0 đến " + elementCount + "): ");
        int position = scanner.nextInt();

        if (position < 0 || position > elementCount) {
            System.out.println("Vị trí không hợp lệ. Không thể thêm phần tử.");
            return arr;
        }

        // Kiểm tra nếu mảng đầy, mở rộng mảng 100%
        int currentSize = arr.length;
        if (elementCount == currentSize) {
            currentSize = currentSize * 2; // Tăng kích thước mảng lên 100%
            int[] newArr = new int[currentSize];
            for (int i = 0; i < elementCount; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            System.out.println("Mảng đã được mở rộng lên " + currentSize + " ô nhớ.");
        }

        // Dịch chuyển các phần tử để chèn phần tử mới
        for (int i = elementCount - 1; i >= position; i--) {
            arr[i + 1] = arr[i];
        }

        // Thêm phần tử mới vào vị trí position
        arr[position] = newElement;

        // In mảng sau khi thêm
        System.out.print("Mảng sau khi thêm phần tử: ");
        inMang(arr, elementCount + 1);
        return arr;
    }

    // 5. Hàm xóa tất cả các phần tử có giá trị do người dùng nhập
    public static int[] xoaPhanTu(int[] arr, int elementCount, Scanner scanner) {
        System.out.print("Nhập giá trị cần xóa khỏi mảng: ");
        int valueToRemove = scanner.nextInt();

        // Đếm số phần tử sẽ bị xóa
        int countToRemove = 0;
        for (int i = 0; i < elementCount; i++) {
            if (arr[i] == valueToRemove) {
                countToRemove++;
            }
        }

        // Nếu không có phần tử nào bị xóa
        if (countToRemove == 0) {
            System.out.println("Không tìm thấy phần tử " + valueToRemove + " trong mảng.");
            return arr;
        }

        // Tạo mảng mới với kích thước giảm đi số phần tử bị xóa
        int newCount = elementCount - countToRemove;
        int[] newArr = new int[newCount];
        int index = 0;

        // Sao chép các phần tử không bị xóa
        for (int i = 0; i < elementCount; i++) {
            if (arr[i] != valueToRemove) {
                newArr[index] = arr[i];
                index++;
            }
        }

        // In mảng sau khi xóa
        System.out.print("Mảng sau khi xóa các phần tử " + valueToRemove + ": ");
        inMang(newArr, newCount);
        return newArr;
    }

    // Hàm tính kích thước mảng sau khi xóa
    public static int tinhKichThuocSauXoa(int[] arr, int elementCount) {
        return arr.length; // Kích thước thực tế sau xóa là độ dài mảng mới
    }

    // 6. Hàm tìm phần tử lớn thứ 3 trong mảng
    public static void timPhanTuLonThu3(int[] arr, int elementCount) {
        if (elementCount < 3) {
            System.out.println("Mảng không đủ phần tử để tìm phần tử lớn thứ 3.");
        } else {
            int firstMax = Integer.MIN_VALUE;  // Giá trị lớn nhất
            int secondMax = Integer.MIN_VALUE; // Giá trị lớn thứ 2
            int thirdMax = Integer.MIN_VALUE;  // Giá trị lớn thứ 3

            // Duyệt qua mảng để tìm 3 giá trị lớn nhất
            for (int i = 0; i < elementCount; i++) {
                if (arr[i] > firstMax) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = arr[i];
                } else if (arr[i] > secondMax && arr[i] != firstMax) {
                    thirdMax = secondMax;
                    secondMax = arr[i];
                } else if (arr[i] > thirdMax && arr[i] != secondMax && arr[i] != firstMax) {
                    thirdMax = arr[i];
                }
            }

            // Kiểm tra nếu không tìm thấy giá trị lớn thứ 3 hợp lệ
            if (thirdMax == Integer.MIN_VALUE) {
                System.out.println("Không tìm thấy phần tử lớn thứ 3 (có thể do trùng lặp).");
            } else {
                System.out.println("Phần tử lớn thứ 3 trong mảng: " + thirdMax);
            }
        }
    }

    // Hàm in mảng
    public static void inMang(int[] arr, int elementCount) {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
