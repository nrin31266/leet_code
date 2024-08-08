

package leetcode.rin28_Largest_3_Same_Digit_Number_in_String;

public class Solution {


    public String largestGoodInteger(String num) {
        int len = num.length();
        int res = -1;

        for(int i = 0; i < len; ++i) {
            char c = num.charAt(i);
            if (Character.isDigit(c)) {
                int count = 1;
                ++i;

                int n;
                while(i < len) {
                    n = num.charAt(i);
                    if (c != n || !Character.isDigit((char)n)) {
                        break;
                    }

                    ++count;
                    ++i;
                }

                --i;
                if (count >= 3) {
                    n = Character.getNumericValue(c);
                    if (n > res) {
                        res = n;
                    }
                }
            }
        }

        if (res != -1) {
            String resStr = String.valueOf(res);
            return resStr + resStr + resStr;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.largestGoodInteger("477772888352338"));
    }
}
