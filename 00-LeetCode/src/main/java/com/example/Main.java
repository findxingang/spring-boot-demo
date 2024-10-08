package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxingang
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "tmmzuxt";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}



class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 字符 -> 索引
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            } else {
                map.put(currentChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}