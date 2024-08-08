package leetcode.rin14_Rotate_Image;

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            int[] col = new int[len];
            int k = 0;
            for (int j = len - 1 ; j >= 0; j--) {
                col[k++] = matrix[j][i];
            }
            for (int j = 0 ; j < len; j++) {
                temp[i][j] = col[j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
    public void rotateMethod2(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = copyMatrix(matrix);

        for (int i = 0; i < len; i++) {
            int k = len -1;
            for (int j = 0; j < len; j++) {
                matrix[i][j] = temp[k][i];
                k--;
            }
        }
    }
    private int[][] copyMatrix(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotateMethod2(matrix);
        solution.printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}

