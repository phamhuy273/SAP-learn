package com.sapstar.dsa.arrays;

import java.util.*;

/**
 * HackerRank: Hash Tables: Ransom Note
 * Độ khó: Easy / Medium (Problem Solving)
 * 
 * Đề bài:
 * Cắt các từ trong tờ báo (magazine) để dán thành bức thư tống tiền (note).
 * Mỗi từ trong magazine chỉ dùng được đúng 1 lần.
 * In ra "Yes" nếu ghép đủ, in ra "No" nếu thiếu từ.
 * 
 * Mục tiêu độ phức tạp:
 * - Time Complexity: O(m + n)
 * - Space Complexity: O(m)
 */
class RansomNoteResult {

    /*
     * Code nguyên bản do chính tay bạn viết:
     * Tư duy rành mạch, kiểm soát chặt chẽ từng trường hợp.
     */
    public static String checkMagazine(List<String> magazine, List<String> note) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : magazine) {
            if (map.containsKey(word)) {
                int old = map.get(word);
                map.put(word, old + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String word : note) {
            if (map.containsKey(word) && map.get(word) > 0) {
                int old = map.get(word);
                map.put(word, old - 1);
            } else if (map.containsKey(word) && map.get(word) == 0) {
                return "No";
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}

public class HR_RansomNote {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CHẠY THỬ TEST CASES: HASH TABLES RANSOM NOTE   ");
        System.out.println("==================================================");

        // Test 1: Đủ từ -> Expected: Yes
        List<String> mag1 = Arrays.asList("give", "me", "one", "grand", "today", "night");
        List<String> note1 = Arrays.asList("give", "one", "grand", "today");
        String r1 = RansomNoteResult.checkMagazine(mag1, note1);
        System.out.println("Test 1 -> Output: " + r1 + " | Expected: Yes -> " + ("Yes".equals(r1) ? "✅ PASS" : "❌ FAIL"));

        // Test 2: Thiếu số lượng từ "two" -> Expected: No
        List<String> mag2 = Arrays.asList("two", "times", "three", "is", "not", "four");
        List<String> note2 = Arrays.asList("two", "times", "two", "is", "four");
        String r2 = RansomNoteResult.checkMagazine(mag2, note2);
        System.out.println("Test 2 -> Output: " + r2 + " | Expected: No  -> " + ("No".equals(r2) ? "✅ PASS" : "❌ FAIL"));

        // Test 3: Khác chữ hoa - chữ thường -> Expected: No
        List<String> mag3 = Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts");
        List<String> note3 = Arrays.asList("Ive", "got", "some", "coconuts");
        String r3 = RansomNoteResult.checkMagazine(mag3, note3);
        System.out.println("Test 3 -> Output: " + r3 + " | Expected: No  -> " + ("No".equals(r3) ? "✅ PASS" : "❌ FAIL"));

        System.out.println("==================================================");
    }
}
