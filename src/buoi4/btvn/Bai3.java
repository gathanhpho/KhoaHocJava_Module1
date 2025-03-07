package buoi4.btvn;

import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        tongChanLe(arr);
        soNguyenTo(arr);
        sapXep(arr);
        chiaMang(arr);
        timSoTrungLap(arr);

        // Thêm phần tử vào mảng
        System.out.print("Nhập giá trị cần thêm: ");
        int value = scanner.nextInt();
        System.out.print("Nhập vị trí cần thêm: ");
        int index = scanner.nextInt();
        arr = insertElement(arr, value, index);
        System.out.println("Mảng sau khi thêm: " + Arrays.toString(arr));

        // Xóa phần tử khỏi mảng
        System.out.print("Nhập vị trí cần xóa: ");
        int removeIndex = scanner.nextInt();
        arr = removeElement(arr, removeIndex);
        System.out.println("Mảng sau khi xóa: " + Arrays.toString(arr));
        scanner.close();
    }

    public static void tongChanLe(int[] arr) {
        int tongChan = 0, tongLe = 0;
        for (int num : arr) {
            if (num % 2 == 0) tongChan += num;
            else tongLe += num;
        }
        System.out.println("Tổng chẵn: " + tongChan + ", Tổng lẻ: " + tongLe);
    }

    public static void soNguyenTo(int[] arr) {
        List<Integer> primes = new ArrayList<>();
        for (int num : arr) {
            if (num < 2) continue; // Bỏ qua số nhỏ hơn 2 vì không phải số nguyên tố
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false; // Nếu chia hết thì không phải số nguyên tố
                    break;
                }
            }
            if (isPrime) primes.add(num); // Chỉ thêm số nếu nó là số nguyên tố
        }
        System.out.println("Các số nguyên tố: " + primes);
    }

    public static void sapXep(int[] arr) {
        List<Integer> chanTangDan = new ArrayList<>();
        List<Integer> leGiamDan = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 == 0) chanTangDan.add(num);
            else leGiamDan.add(num);
        }
        chanTangDan.sort(Collections.reverseOrder());
        Collections.sort(leGiamDan);
        System.out.println("Chẵn giảm dần: " + chanTangDan);
        System.out.println("Lẻ tăng dần: " + leGiamDan);
    }

    public static void chiaMang(int[] arr) {
        double avg = Arrays.stream(arr).average().orElse(0);
        List<Integer> nhoHonTB = new ArrayList<>();
        List<Integer> lonHonTB = new ArrayList<>();
        for (int num : arr) {
            if (num <= avg) nhoHonTB.add(num);
            else lonHonTB.add(num);
        }
        System.out.println("Mảng 1 (<= trung bình): " + nhoHonTB);
        System.out.println("Mảng 2 (> trung bình): " + lonHonTB);
    }

    public static void timSoTrungLap(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int duplicateCount = 0;
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateCount++;
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("Số lượng phần tử trùng lặp: " + duplicateCount + " (" + duplicates + ")");
    }

    public static int[] insertElement(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            System.out.println("Vị trí không hợp lệ!");
            return arr;
        }
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index) newArr[i] = value;
            else newArr[i] = arr[j++];
        }
        return newArr;
    }

    public static int[] removeElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Vị trí không hợp lệ!");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) continue;
            newArr[j++] = arr[i];
        }
        return newArr;
    }

}

