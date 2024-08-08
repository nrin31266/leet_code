package leetcode.rin3_ChuyenSangSoLaMa;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final String[] i={"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] ii={"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] iii={"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] iiii={"M", "MM", "MMM"};

    private static final Map<Integer, String[]> roman;

    static {
        roman=new HashMap<>();
        roman.put(0, i);
        roman.put(1, ii);
        roman.put(2, iii);
        roman.put(3, iiii);
    }


    public String intToRoman(int num) {
        StringBuilder convert = new StringBuilder();
        int size = String.valueOf(num).length();
        for (int i = 0; i < size; i++) {

            int rem = num % 10;
            num /= 10;
            if(rem == 0) continue;
            convert.insert(0, roman.get(i)[rem - 1]);
        }
        return convert.toString();
    }

    public static void main(String[] args) {
        int integer= 3999;

        Solution solution = new Solution();

        System.out.print(solution.intToRoman(integer));
    }
}
