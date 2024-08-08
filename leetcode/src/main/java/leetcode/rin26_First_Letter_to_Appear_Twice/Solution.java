package leetcode.rin26_First_Letter_to_Appear_Twice;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char repeatedCharacter(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return s.charAt(i);
            }else{
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        return '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedCharacter("abcdeg"));
    }
}
