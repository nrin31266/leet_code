package example.Combinations;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

    public static List<List<Integer>> getCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= arr.length) {
            combine(arr, k, result);
        }
        return result;
    }

    private static void combine(int[] arr, int k, List<List<Integer>> result) {
        Stack<Integer> stack = new Stack<>();

        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = i;
            stack.push(arr[i]);
        }

        while (true) {
            // Thêm tổ hợp hiện tại vào kết quả
            result.add(new ArrayList<>(stack));

            // Tìm chỉ số bên phải nhất có thể tăng lên
            int i;
            for (i = k - 1; i >= 0; i--) {
                if (indices[i] < arr.length - k + i) {
                    break;
                }
            }

            // Nếu không có chỉ số nào như vậy thì chúng ta đã xong
            if (i < 0) {
                return;
            }

            // Tăng chỉ số hiện tại và điều chỉnh các chỉ số tiếp theo
            indices[i]++;
            stack.set(i, arr[indices[i]]);
            for (int j = i + 1; j < k; j++) {
                indices[j] = indices[j - 1] + 1;
                stack.set(j, arr[indices[j]]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // Trường hợp k = 1
        int k1 = 1;
        List<List<Integer>> combinations1 = getCombinations(arr, k1);
        System.out.println("Combinations of 1 element: " + combinations1);

        // Trường hợp k = 2
        int k2 = 2;
        List<List<Integer>> combinations2 = getCombinations(arr, k2);
        System.out.println("Combinations of 2 elements: " + combinations2);

        // Trường hợp k = 3
        int k3 = 3;
        List<List<Integer>> combinations3 = getCombinations(arr, k3);
        System.out.println("Combinations of 3 elements: " + combinations3);
    }
}

