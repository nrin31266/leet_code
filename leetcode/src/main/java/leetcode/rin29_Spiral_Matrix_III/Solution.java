package leetcode.rin29_Spiral_Matrix_III;

import java.util.Arrays;

public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows*cols][2];
        int direction = 0; // 0 = right, 1 = down, 2 = left, 3 = up
        int steps = 1;
        int index = 0;
        result[index] = new int[]{rStart, cStart};
        index++;
        while (index < rows * cols) {
            for (int i = 0; i < (steps); i++) {
                switch (direction) {
                    case 0: cStart++; break; // right
                    case 1: rStart++; break; // down
                    case 2: cStart--; break; // left
                    case 3: rStart--; break; // up
                }

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[index++] = new int[]{rStart, cStart};
                }
            }

            if (direction == 1 || direction == 3) {
                steps++;
            }

            direction = (direction + 1) % 4;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.spiralMatrixIII(5, 6, 1, 4);
        for (int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

}
