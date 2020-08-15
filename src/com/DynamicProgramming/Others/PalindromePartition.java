package com.DynamicProgramming.Others;

// Question and Explanation : https://www.techiedelight.com/find-minimum-cuts-needed-palindromic-partition-string/
// Solution is from leetcode
public class PalindromePartition {

    public int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n+1][n+1];
        int min[] = new int[n];
        for(int i=0; i<n; ++i) {
            min[i] = i;
            for(int j=0; j<=i; ++j) {
                if(s.charAt(i) == s.charAt(j) && (j+1 > i-1 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    min[i] = j == 0 ? 0 : Math.min(min[i], min[j-1] + 1);
                }
            }
        }
        return min[n-1];
    }

}