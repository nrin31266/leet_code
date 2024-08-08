package example.CombinationsSumList;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSumList {

    public static List<Integer> sumOfCombinations(int[] arr, int k) {
        if (k > arr.length || k <= 0) {
            throw new IllegalArgumentException("k must be between 1 and the length of the array");
        }

        List<List<Integer>> combinations = getCombinations(arr, k);
        List<Integer> sums = new ArrayList<>();

        for (List<Integer> combination : combinations) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }
            sums.add(sum);
        }

        return sums;
    }

    private static List<List<Integer>> getCombinations(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = i;
        }

        while (true) {
            List<Integer> currentCombination = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                currentCombination.add(arr[indices[i]]);
            }
            result.add(currentCombination);

            int i;
            for (i = k - 1; i >= 0; i--) {
                if (indices[i] < arr.length - k + i) {
                    break;
                }
            }

            if (i < 0) {
                break;
            }

            indices[i]++;
            for (int j = i + 1; j < k; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        int k1 = 1;
        List<Integer> sums1 = sumOfCombinations(arr, k1);
        System.out.println("Sums of combinations of 2 elements: " + sums1);

        // Trường hợp k = 2
        int k2 = 2;
        List<Integer> sums2 = sumOfCombinations(arr, k2);
        System.out.println("Sums of combinations of 2 elements: " + sums2);

        // Trường hợp k = 3
        int k3 = 3;
        List<Integer> sums3 = sumOfCombinations(arr, k3);
        System.out.println("Sums of combinations of 3 elements: " + sums3);
    }
}

