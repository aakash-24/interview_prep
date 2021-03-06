package com.DynamicProgramming.Others;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class StockBuySell2 {

    public int maxProfit(final int[] A) {
        if (A.length <= 1)
            return 0;
        int maxprofit = 0;
        for (int i = 1; i < A.length; i++) {
            maxprofit += Math.max(0, A[i] - A[i - 1]);
        }
        return maxprofit;
    }

}
