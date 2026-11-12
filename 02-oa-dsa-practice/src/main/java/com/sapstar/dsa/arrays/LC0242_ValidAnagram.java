package com.sapstar.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #242: Valid Anagram (Kiểm tra Đảo Ngữ)
 * 
 * Đề bài:
 * Cho 2 chuỗi s và t. Trả về true nếu t là đảo ngữ của s, ngược lại trả về false.
 * (Một từ là Anagram nếu nó được tạo thành bằng cách sắp xếp lại các chữ cái
 * của từ ban đầu, sử dụng tất cả các chữ cái gốc đúng một lần).
 * 
 * Ví dụ 1:
 * Input: s = "anagram", t = "nagaram" -> Output: true
 * 
 * Ví dụ 2:
 * Input: s = "rat", t = "car" -> Output: false
 * 
 * -------------------------------------------------------------
 * 3 CÁCH TIẾP CẬN TƯ DUY:
 * 1. Sorting: O(N log N) time, O(N) space.
 * 2. HashMap: O(N) time, O(K) space (K = số ký tự phân biệt).
 * 3. Fixed Array 26 chars: O(N) time, O(1) space (TỐI ƯU NHẤT).
 */
public class LC0242_ValidAnagram {

    /**
     * CÁCH 3: Tối ưu nhất - Dùng mảng đếm tần suất 26 ký tự
     * - Time Complexity: O(n)
     * - Space Complexity: O(1) (Mảng cố định 26 phần tử = 104 bytes trong RAM)
     */
    public boolean isAnagram(String s, String t) {
        // Điều kiện tiên quyết: Nếu độ dài khác nhau thì không thể là đảo ngữ
        if (s.length() != t.length()) {
            return false;
        }

        // Mảng đếm tần suất 26 chữ cái tiếng Anh in thường ('a' -> 'z')
        int[] count = new int[26];

        // Duyệt 1 vòng qua cả 2 chuỗi cùng lúc:
        // Ký tự trong s thì cộng 1 (+1), ký tự trong t thì trừ 1 (-1)
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Nếu t là đảo ngữ của s thì mọi vị trí phải triệt tiêu về 0
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * CÂU HỎI PHỎNG VẤN NÂNG CAO:
     * "Nếu chuỗi chứa ký tự Unicode (tiếng Việt, emoji, tiếng Trung...) thì sao?"
     * -> Khi đó không thể dùng mảng 26 ký tự, mà phải dùng HashMap:
     */
    public boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!countMap.containsKey(c)) {
                return false;
            }
            int remaining = countMap.get(c) - 1;
            if (remaining == 0) {
                countMap.remove(c);
            } else {
                countMap.put(c, remaining);
            }
        }

        return countMap.isEmpty();
    }

    public static void main(String[] args) {
        LC0242_ValidAnagram solver = new LC0242_ValidAnagram();

        System.out.println("=== KIỂM THỬ THUẬT TOÁN TỐI ƯU O(1) SPACE ===");
        
        // Test 1: Chuỗi đảo ngữ chuẩn
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Test 1 (\"anagram\", \"nagaram\"): " + solver.isAnagram(s1, t1) + " (Expected: true)");

        // Test 2: Khác ký tự
        String s2 = "rat", t2 = "car";
        System.out.println("Test 2 (\"rat\", \"car\"): " + solver.isAnagram(s2, t2) + " (Expected: false)");

        // Test 3: Độ dài khác nhau
        String s3 = "a", t3 = "ab";
        System.out.println("Test 3 (\"a\", \"ab\"): " + solver.isAnagram(s3, t3) + " (Expected: false)");

        // Test 4: Trùng ký tự nhưng khác số lượng
        String s4 = "aa", t4 = "a";
        System.out.println("Test 4 (\"aa\", \"a\"): " + solver.isAnagram(s4, t4) + " (Expected: false)");

        System.out.println("\n=== KIỂM THỬ UNICODE ===");
        String s5 = "học tập", t5 = "tập học";
        System.out.println("Test 5 Unicode (\"học tập\", \"tập học\"): " + solver.isAnagramUnicode(s5, t5) + " (Expected: true)");
    }
}
