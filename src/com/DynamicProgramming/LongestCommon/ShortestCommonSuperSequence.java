package com.DynamicProgramming.LongestCommon;

// https://www.geeksforgeeks.org/shortest-common-supersequence/
public class ShortestCommonSuperSequence {

    static int shortestSuperSequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int l = lcs(X, Y, m, n);
        return (m + n - l);
    }
    static int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

}
