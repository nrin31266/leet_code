package leetcode.rin7_Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int temp = x, rev = 0;

        while (temp != 0){
            int num = temp % 10;
            temp /= 10;
            rev = rev * 10 + num;
        }

        return rev == x;
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
}
