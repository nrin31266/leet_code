package leetcode.rin16_Make_Two_Arrays_Equal_by_Reversing_Subarrays;


import java.util.Arrays;


public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
