package com.sapstar.dsa.arrays;

import java.util.*;

public class HR_NewYearChaos {

    /*
     * ====================================================================
     * COPY TOÀN BỘ CLASS RESULT NÀY (HOẶC HÀM minimumBribes) DÁN VÀO HACKERRANK:
     * ====================================================================
     */
    public static class Result {

        /*
         * Complete the 'minimumBribes' function below.
         *
         * The function accepts INTEGER_ARRAY q as parameter.
         *
         * Độ phức tạp:
         * - Time Complexity: O(n) (Mỗi phần tử chỉ so sánh tối đa 2 lần với người đứng trước)
         * - Space Complexity: O(1) (Không dùng thêm mảng hay cấu trúc dữ liệu phụ)
         */
        public static void minimumBribes(List<Integer> q) {
            int totalBribes = 0;

            for (int i = 0; i < q.size(); i++) {
                int currentPerson = q.get(i); // Số áo của người hiện tại
                int currentPosition = i + 1;  // Vị trí thực tế trong hàng (1-based index)

                // 1. KIỂM TRA GIAN LẬN:
                // Nếu người này nhảy lên phía trước nhiều hơn 2 bước so với vị trí ban đầu
                if (currentPerson - currentPosition > 2) {
                    System.out.println("Too chaotic");
                    return; // Dừng hàm ngay lập tức
                }

                // 2. ĐẾM SỐ LẦN BỊ NGƯỜI KHÁC VƯỢT MẶT:
                // Ai có thể hối lộ để vượt qua mặt người `currentPerson`?
                // Chỉ những người có số áo LỚN HƠN mà hiện tại lại đang đứng ĐẰNG TRƯỚC người này.
                // Vì mỗi người chỉ được nhảy lên tối đa 2 bước, nên người lớn hơn chỉ có thể
                // đứng xa nhất về phía trước ở vị trí `currentPerson - 2` (index: currentPerson - 2).
                int start = Math.max(0, currentPerson - 2);
                for (int j = start; j < i; j++) {
                    if (q.get(j) > currentPerson) {
                        totalBribes++;
                    }
                }
            }

            // In tổng số lần hối lộ
            System.out.println(totalBribes);
        }

        /*
         * CÁCH 2: MÔ PHỎNG ĐI NGƯỢC (REVERSE GREEDY SIMULATION)
         * Đưa từng người từ cuối hàng về đúng vị trí ban đầu bằng cách đổi chỗ.
         * Cả 2 cách đều đạt điểm tuyệt đối 100% trên HackerRank.
         */
        public static void minimumBribesSimulation(List<Integer> q) {
            // Chuyển List sang mảng để hoán đổi (swap) dễ dàng
            int[] arr = q.stream().mapToInt(Integer::intValue).toArray();
            int bribes = 0;

            for (int i = arr.length - 1; i >= 0; i--) {
                int expectedPerson = i + 1; // Người đáng lẽ phải đứng ở vị trí này

                if (arr[i] == expectedPerson) {
                    // Người đó đang đứng đúng vị trí -> Không cần làm gì
                    continue;
                } else if (i - 1 >= 0 && arr[i - 1] == expectedPerson) {
                    // Người đó đang đứng ngay trước mặt 1 bước -> Cần 1 lần swap
                    bribes += 1;
                    swap(arr, i - 1, i);
                } else if (i - 2 >= 0 && arr[i - 2] == expectedPerson) {
                    // Người đó đang đứng trước mặt 2 bước -> Cần 2 lần swap
                    bribes += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else {
                    // Người đó ở cách xa hơn 2 bước -> Chắc chắn đã nhảy quá 2 lần!
                    System.out.println("Too chaotic");
                    return;
                }
            }

            System.out.println(bribes);
        }

        private static void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== KIỂM THỬ THUẬT TOÁN NEW YEAR CHAOS ===");

        // Test Case 1: Hợp lệ -> Kỳ vọng in: 3
        System.out.print("Test 1 [2, 1, 5, 3, 4] -> Kết quả: ");
        Result.minimumBribes(Arrays.asList(2, 1, 5, 3, 4));

        // Test Case 2: Vi phạm (người 5 nhảy 3 bước) -> Kỳ vọng in: Too chaotic
        System.out.print("Test 2 [2, 5, 1, 3, 4] -> Kết quả: ");
        Result.minimumBribes(Arrays.asList(2, 5, 1, 3, 4));

        // Test Case 3: Vi phạm (người 5 nhảy lên vị trí 1) -> Kỳ vọng in: Too chaotic
        System.out.print("Test 3 [5, 1, 2, 3, 7, 8, 6, 4] -> Kết quả: ");
        Result.minimumBribes(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));

        // Test Case 4: Hợp lệ -> Kỳ vọng in: 7
        System.out.print("Test 4 [1, 2, 5, 3, 7, 8, 6, 4] -> Kết quả: ");
        Result.minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));

        System.out.println("\n=== KIỂM THỬ BẰNG CÁCH 2 (MÔ PHỎNG ĐI NGƯỢC) ===");
        System.out.print("Test 1 -> Kết quả: ");
        Result.minimumBribesSimulation(Arrays.asList(2, 1, 5, 3, 4));
        System.out.print("Test 2 -> Kết quả: ");
        Result.minimumBribesSimulation(Arrays.asList(2, 5, 1, 3, 4));
        System.out.print("Test 3 -> Kết quả: ");
        Result.minimumBribesSimulation(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));
        System.out.print("Test 4 -> Kết quả: ");
        Result.minimumBribesSimulation(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
    }
}
