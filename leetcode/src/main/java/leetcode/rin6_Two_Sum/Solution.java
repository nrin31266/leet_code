package leetcode.rin6_Two_Sum;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString((solution.twoSum(new int[]{3,2,4}, 8))));

    }
}
