package leetcode.rin1_Xoa_Min_a_DungTrc_b;

public class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int minDeletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else if (c == 'a') {
                if (countB > 0) {
                    minDeletions++;
                    countB--;
                }
            }
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Ví dụ 1:
        String s1 = "babbb";
        System.out.println(solution.minimumDeletions(s1));  // Đầu ra: 2

        // Ví dụ 2:
        String s2 = "bbaaaaabb";
        System.out.println(solution.minimumDeletions(s2));  // Đầu ra: 2
    }
}

