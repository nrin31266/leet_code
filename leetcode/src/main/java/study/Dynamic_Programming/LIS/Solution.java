package study.Dynamic_Programming.LIS;

import java.util.Collections;
import java.util.List;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        Vector<Integer> listNums = new Vector<>();
        listNums.addElements(dp);

        int n = listNums.size();

        Vector<Integer> ans = new Vector<>();
        ans.setSize(n, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(listNums.get(i) > listNums.get(j)) {
                    ans.set(i, Math.max(ans.get(i), ans.get(j)+1));
                }
            }
        }

        return Collections.max(ans);
    }
    public int lengthOfLISMethod2(int[] nums){
        List<Integer> ans = new java.util.ArrayList<>(Collections.nCopies(nums.length, 1));
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    ans.set(i, Math.max(ans.get(i), ans.get(j)+1));
                }
            }
        }
        return Collections.max(ans);
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(solution.lengthOfLISMethod2(nums));
    }
}

