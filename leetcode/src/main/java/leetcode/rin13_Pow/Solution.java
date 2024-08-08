package leetcode.rin13_Pow;

public class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.format("%.5f" ,solution.myPow(2, 10));
    }
}
