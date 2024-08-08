package leetcode.rin11_Filing_Bookcase_Shelves;

import java.util.Arrays;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;

        int[] widths = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = books[i][0];
            heights[i] = books[i][1];
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // Khởi tạo dp[0] = 0 vì không có sách nào thì chiều cao là 0

        for (int i = 1; i <= n; i++) {
//            System.out.println("Sach thu: "+ i);
            int width = 0, height = 0;
//            System.out.println("w: "+ width +", h: "+ height);
            for (int j = i; j > 0; j--) {
                width += widths[j - 1];
                if (width > shelfWidth) break;

                height = Math.max(height, heights[j - 1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
//            System.out.println("w: " + width+", h: "+ height);
//            System.out.println("dp: " + Arrays.toString(dp));
        }

        return dp[n];
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
//        int[][] books = {{1, 3}, {2, 4}, {3, 2}};


        System.out.println(solution.minHeightShelves(books, 4));
    }
}