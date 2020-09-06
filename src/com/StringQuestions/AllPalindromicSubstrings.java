package com.StringQuestions;

// Question Link : https://leetcode.com/problems/palindromic-substrings/

public class AllPalindromicSubstrings {

    static int count = 0;

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }

    private static void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }


    public static void main(String[] args) {
        String str = "aaa";
        countSubstrings(str);
    }

}
