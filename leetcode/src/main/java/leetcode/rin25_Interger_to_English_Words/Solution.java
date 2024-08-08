package leetcode.rin25_Interger_to_English_Words;

public class Solution {
    private final String[] lessThan19= {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
            , "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] dozensOutOf10 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty"
            , "Seventy", "Eighty", "Ninety"};
    private final String[] overThousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String res = "";
        //non-negative
        int i = 0;
        while (num > 0) {
            int remainder = num % 1000;

            String s =Conversion(remainder);
            res = s + (s.isEmpty() ? "" : overThousands[i] + " ") + res;

            num /= 1000;

            i++;
        }

        return res.trim();
    }

    private String Conversion(int num) {

        if (num == 0) return "";
        else if (num < 20) return lessThan19[num] + " ";
        else if (num < 100) {
            String r = "";
            r = dozensOutOf10[num / 10] + " " + Conversion(num % 10);
            return r;
        }
        else {
            String r = "";
            r = lessThan19[num / 100] + " Hundred " + Conversion(num % 100);
            return r;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1000010));
    }
}
