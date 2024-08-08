package leetcode.rin2;



public class Solution {
    private int reverse(int x) {

        int reversed = 0;
        while (x!=0){
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Tràn số dương
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Tràn số âm
            }
            reversed = reversed * 10 +digit;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Solution solution= new Solution();

        int a= -1234;

        System.out.println(solution.reverse(a));
    }
}
