package com.sapstar.dsa.arrays;

import java.io.*;
import java.util.*;

/*
 * ====================================================================
 * ĐÂY LÀ CLASS RESULT CHUẨN CỦA HACKERRANK
 * Bạn hãy viết code vào hàm twoStrings bên dưới.
 * Khi code xong, bạn chỉ cần copy nguyên class Result này (hoặc ruột hàm)
 * dán vào trang web HackerRank là xong!
 * ====================================================================
 */
class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING ("YES" hoặc "NO").
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public static String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (char c: s1.toCharArray())
        {
            set.add(c);
        }

        for(char x: s2.toCharArray())
        {
            if(set.contains(x))
                return "YES";
        }
        return "NO";
    }

}

public class HR_TwoStrings {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CHẠY THỬ TEST CASES HACKERRANK: TWO STRINGS   ");
        System.out.println("==================================================");

        // Test 1: Có chung chữ 'a' -> Expected: YES
        String s1 = "and", s2 = "art";
        String r1 = Result.twoStrings(s1, s2);
        System.out.println("Test 1 (\"and\", \"art\")     -> Output: " + r1 
            + " | Expected: YES -> " + ("YES".equals(r1) ? "✅ PASS" : "❌ FAIL"));

        // Test 2: Không có chữ nào chung -> Expected: NO
        String s3 = "be", s4 = "cat";
        String r2 = Result.twoStrings(s3, s4);
        System.out.println("Test 2 (\"be\", \"cat\")       -> Output: " + r2 
            + " | Expected: NO  -> " + ("NO".equals(r2) ? "✅ PASS" : "❌ FAIL"));

        // Test 3: Có chung chữ 'l', 'o' -> Expected: YES
        String s5 = "hello", s6 = "world";
        String r3 = Result.twoStrings(s5, s6);
        System.out.println("Test 3 (\"hello\", \"world\") -> Output: " + r3 
            + " | Expected: YES -> " + ("YES".equals(r3) ? "✅ PASS" : "❌ FAIL"));

        // Test 4: Không chung chữ nào -> Expected: NO
        String s7 = "hi", s8 = "world";
        String r4 = Result.twoStrings(s7, s8);
        System.out.println("Test 4 (\"hi\", \"world\")    -> Output: " + r4 
            + " | Expected: NO  -> " + ("NO".equals(r4) ? "✅ PASS" : "❌ FAIL"));
            
        System.out.println("==================================================");
    }
}
