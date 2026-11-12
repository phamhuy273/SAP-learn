package com.sapstar.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #217: Contains Duplicate
 * 
 * Đề bài:
 * Cho mảng số nguyên nums. Trả về true nếu có bất kỳ giá trị nào xuất hiện
 * ít nhất 2 lần trong mảng, và false nếu mọi phần tử đều là duy nhất.
 * 
 * Ví dụ 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Ví dụ 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Độ phức tạp kỳ vọng:
 * - Time Complexity: O(n)
 * - Space Complexity: O(n)
 */
public class LC0217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC0217_ContainsDuplicate solver = new LC0217_ContainsDuplicate();

        // Test Case 1: Có trùng lặp
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1 [1, 2, 3, 1] -> Expected: true, Actual: " + solver.containsDuplicate(test1));

        // Test Case 2: Không có trùng lặp
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2 [1, 2, 3, 4] -> Expected: false, Actual: " + solver.containsDuplicate(test2));

        // Test Case 3: Trùng lặp nhiều số
        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test 3 [1, 1, ...] -> Expected: true, Actual: " + solver.containsDuplicate(test3));
    }
}
