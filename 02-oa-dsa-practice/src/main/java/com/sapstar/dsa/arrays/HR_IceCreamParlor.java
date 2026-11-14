package com.sapstar.dsa.arrays;

import java.util.*;
public class HR_IceCreamParlor {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        Map<Integer,Integer> map = new HashMap<>();
    
        for(int i = 0; i < arr.size(); i++)
        {
            int complement = m - arr.get(i);
            if(map.containsKey(complement))
            {
                int previousIndex = map.get(complement);
                  return Arrays.asList(previousIndex + 1, i + 1);
            }
            else
            {
                map.put(arr.get(i), i);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("=== TEST CASES HACKERRANK: ICE CREAM PARLOR ===");

        // Test Case 1:
        // Giá 1 (vị trí 1) + Giá 3 (vị trí 4) = 4
        int m1 = 4;
        List<Integer> arr1 = Arrays.asList(1, 4, 5, 3, 2);
        System.out.println("Test 1 (m=4, [1, 4, 5, 3, 2]) -> Result: " 
            + icecreamParlor(m1, arr1) + " (Expected: [1, 4])");

        // Test Case 2:
        // Giá 2 (vị trí 1) + Giá 2 (vị trí 2) = 4
        int m2 = 4;
        List<Integer> arr2 = Arrays.asList(2, 2, 4, 3);
        System.out.println("Test 2 (m=4, [2, 2, 4, 3])    -> Result: " 
            + icecreamParlor(m2, arr2) + " (Expected: [1, 2])");

        // Test Case 3:
        // Giá 1 (vị trí 1) + Giá 5 (vị trí 4) = 6
        int m3 = 6;
        List<Integer> arr3 = Arrays.asList(1, 3, 4, 5, 6);
        System.out.println("Test 3 (m=6, [1, 3, 4, 5, 6]) -> Result: " 
            + icecreamParlor(m3, arr3) + " (Expected: [1, 4])");
    }
}
