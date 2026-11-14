package com.sapstar.dsa.arrays;

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
 * Ràng buộc:
 * - s và t chỉ gồm các chữ cái tiếng Anh in thường ('a' đến 'z').
 * 
 * Mục tiêu độ phức tạp:
 * - Time Complexity: O(n)
 * - Space Complexity: O(1) hoặc O(n)
 */
public class LC0242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
      
        
        return false;
    }

    public static void main(String[] args) {
        LC0242_ValidAnagram solver = new LC0242_ValidAnagram();

        System.out.println("=== TEST CASES LEETCODE #242: VALID ANAGRAM ===");

        // Test 1: Đảo ngữ chuẩn
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Test 1 (\"anagram\", \"nagaram\"): " + solver.isAnagram(s1, t1) + " -> Expected: true");

        // Test 2: Khác ký tự
        String s2 = "rat", t2 = "car";
        System.out.println("Test 2 (\"rat\", \"car\"): " + solver.isAnagram(s2, t2) + " -> Expected: false");

        // Test 3: Độ dài khác nhau
        String s3 = "a", t3 = "ab";
        System.out.println("Test 3 (\"a\", \"ab\"): " + solver.isAnagram(s3, t3) + " -> Expected: false");

        // Test 4: Trùng ký tự nhưng khác số lượng
        String s4 = "aa", t4 = "a";
        System.out.println("Test 4 (\"aa\", \"a\"): " + solver.isAnagram(s4, t4) + " -> Expected: false");
    }
}
