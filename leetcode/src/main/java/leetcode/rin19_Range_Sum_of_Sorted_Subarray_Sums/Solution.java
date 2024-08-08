package leetcode.rin19_Range_Sum_of_Sorted_Subarray_Sums;


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Solution
{
    public static int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> subarraySums = new ArrayList<>();

        // Tính tất cả các tổng của các subarray
        for (int start = 0; start < n; start++) {
            long sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                subarraySums.add(sum);
            }
        }

        // Sắp xếp tất cả các tổng subarray
        Collections.sort(subarraySums);

        // Tính tổng trong khoảng từ left đến right
        long totalSum = 0;
        for (int i = left - 1; i < right; i++) {
            totalSum += subarraySums.get(i);
        }
//        System.out.println(totalSum);
        // Đảm bảo kết quả nằm trong phạm vi của kiểu int
        return (int) (totalSum % (1_000_000_007)); // Modulo lớn để tránh tràn số
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[1000];
        Arrays.fill(nums, 100);
//        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.rangeSum(nums, nums.length, 1, 500500));
    }
}
