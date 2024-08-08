package study.Dynamic_Programming.Knapsack;

import java.util.Arrays;

public class Solution {

}

class Main {
    public static void main(String[] args) {
        int n = 4, S = 6;
        int[] w = {2, 1, 4, 3};
        int[] v = {3, 3, 4, 2};

        int[][] dp = new int[n + 1][S + 1];


//        Arrays.fill(dp[0],0);
//        for(int i=0;i<dp.length;i++){
//            dp[i][0] = 0;
//        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < S + 1; j++) {
                //Không lựa chọn đồ vật thứ i vào trong túi
                dp[i][j] = dp[i - 1][j];
                //Có thể đưa đồ vật thứ i vào trong túi
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        System.out.println(dp[n][S]);

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }

}
