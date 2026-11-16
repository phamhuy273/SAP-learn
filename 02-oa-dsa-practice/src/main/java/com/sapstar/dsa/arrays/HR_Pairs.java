package com.sapstar.dsa.arrays;

import java.util.*;

public class HR_Pairs {

    /*
     * ====================================================================
     * COPY TOÀN BỘ CLASS RESULT NÀY (HOẶC HÀM PAIRS) DÁN VÀO HACKERRANK:
     * ====================================================================
     */
    public static class Result {

        /*
         * Complete the 'pairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY arr
         * 
         * Độ phức tạp:
         * - Time Complexity: O(n) (Chỉ 1 vòng lặp duy nhất)
         * - Space Complexity: O(n) (Dùng HashSet lưu các số đã đi qua)
         */
        public static int pairs(int k, List<Integer> arr) {
            int count = 0;
            Set<Integer> seen = new HashSet<>();

            for (int num : arr) {
                // Kiểm tra xem trước đó có số nào lớn hơn k đơn vị đã xuất hiện chưa
                if (seen.contains(num + k)) {
                    count++;
                }

                // Kiểm tra xem trước đó có số nào nhỏ hơn k đơn vị đã xuất hiện chưa
                if (seen.contains(num - k)) {
                    count++;
                }

                // Luôn luôn lưu số hiện tại vào Set để các số sau tìm kiếm
                seen.add(num);
            }

            return count;
        }

    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       CHẠY THỬ TEST CASES HACKERRANK: PAIRS      ");
        System.out.println("==================================================");

        // Test 1:
        // k = 2, arr = [1, 5, 3, 4, 2]
        // Các cặp có hiệu = 2: (5, 3), (4, 2), (3, 1) -> Có 3 cặp
        int k1 = 2;
        List<Integer> arr1 = Arrays.asList(1, 5, 3, 4, 2);
        int r1 = Result.pairs(k1, arr1);
        System.out.println("Test 1 (k=2, [1, 5, 3, 4, 2]) -> Output: " + r1 
            + " | Expected: 3 -> " + (r1 == 3 ? "✅ PASS" : "❌ FAIL"));

        // Test 2:
        // k = 1, arr = [1, 2, 3, 4]
        // Các cặp có hiệu = 1: (2, 1), (3, 2), (4, 3) -> Có 3 cặp
        int k2 = 1;
        List<Integer> arr2 = Arrays.asList(1, 2, 3, 4);
        int r2 = Result.pairs(k2, arr2);
        System.out.println("Test 2 (k=1, [1, 2, 3, 4])       -> Output: " + r2 
            + " | Expected: 3 -> " + (r2 == 3 ? "✅ PASS" : "❌ FAIL"));

        // Test 3:
        // k = 2, arr = [1, 3, 5, 8, 6, 4, 2]
        // (3,1), (5,3), (8,6), (6,4), (4,2) -> Có 5 cặp
        int k3 = 2;
        List<Integer> arr3 = Arrays.asList(1, 3, 5, 8, 6, 4, 2);
        int r3 = Result.pairs(k3, arr3);
        System.out.println("Test 3 (k=2, [1, 3, 5, 8, 6, 4, 2]) -> Output: " + r3 
            + " | Expected: 5 -> " + (r3 == 5 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("==================================================");
    }
}
