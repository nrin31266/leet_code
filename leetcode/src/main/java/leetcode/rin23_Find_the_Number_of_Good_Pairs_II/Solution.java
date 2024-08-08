package leetcode.rin23_Find_the_Number_of_Good_Pairs_II;

public class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] % (k * nums2[j]) == 0) {
                    res += 1;
                    System.out.println(i + " " + j);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,4,12};
        int[] nums2 = new int[]{2, 4};

        System.out.println(solution.numberOfPairs(nums1, nums2, 3));
    }
}
