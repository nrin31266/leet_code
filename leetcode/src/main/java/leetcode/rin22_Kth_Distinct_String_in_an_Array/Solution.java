package leetcode.rin22_Kth_Distinct_String_in_an_Array;

import java.util.*;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        int len = arr.length;
        Map<String, Boolean> map = new HashMap<>();

        for (String s : arr) {
            if (!map.containsKey(s)) {
                map.put(s, true);
            } else {
                if (map.get(s)) {
                    map.put(s, false);
                }
            }
        }
        for (String s : arr) {
            if (map.get(s)) {
                k--;
            }
            if (k == 0) {
                return s;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = {"a","b","a"};
        System.out.println(solution.kthDistinct(arr, 3));
    }
}
