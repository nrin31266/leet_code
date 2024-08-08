package leetcode.rin27_Find_the_Distance_Value_Between_Two_Arrays;

public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int res = 0;
        for (int k : arr1) {
            boolean check = true;
            for (int i : arr2) {
                if (Math.abs(k - i) <= d) {
                    check = false;
                    break;
                }
            }
            if (check) res += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[]{2,1,100,3};
        int[] arr2 = new int[]{-5,-2,10,-3,7};
        System.out.println(solution.findTheDistanceValue(arr1, arr2, 6));
    }
}
