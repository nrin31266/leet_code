package leetcode.rin20_Sqrt;

public class Solution {
    public int mySqrt(int x) {
        double y = Math.sqrt(x);

        return (int) (y/1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(10));
    }
}
