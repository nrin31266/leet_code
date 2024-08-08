package leetcode.rin8_Remove_Duplicates_from_Sorted_Array;


import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int key = nums[0];

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i] != key) {
                count=count+1;
                key = nums[i];
            }
        }
        int[] temp;
        temp = new int[count];
        temp[0] = nums[0];
        int j = 1;

        key = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ( nums[i] != key) {
                temp[j] = nums[i];
                j++;
                key = nums[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }

        return count;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,2,3,3,4};

        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
