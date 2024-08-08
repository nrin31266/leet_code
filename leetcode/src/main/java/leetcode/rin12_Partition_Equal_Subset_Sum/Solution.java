package leetcode.rin12_Partition_Equal_Subset_Sum;

import java.util.Arrays;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int mid = sum / 2;
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = mid; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
//        System.out.println("dp: " + Arrays.toString(dp));
        return dp[mid];
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1,2,3,6}));
    }
}
