package leetcode.rin17_Three_Sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        Map<String, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < len - 2; i++) {
            int num1=nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                int num2=nums[j];
                for (int k = j + 1; k < len; k++) {
                    int num3=nums[k];
                    if (num1+num2+num3==0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(num1);
                        list.add(num2);
                        list.add(num3);
                        if (!res.containsKey(list.toString())) {
                            res.put(list.toString(), list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res.values());
    }
    public List<List<Integer>> threeSumMethod2(int[] nums) {
        Arrays.sort(nums);

        System.out.println("Array after sort:"+ Arrays.toString(nums));

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            System.out.println("Loop " + i);

            //Khi sắp xếp mảng lại các số giống nahu sẽ liền kề nhau
            //Nếu số xét sau giống số trc đã xét thì nó sẽ bỏ qua
            if (i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("Task 1  " + nums[i] + ", " + nums[i-1]);
                continue; // Bỏ qua các phần tử trùng lặp
            }
            int left = i + 1;
            int right = len - 1;

            System.out.println(left + " L, R " + right);


            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("Sum : "+sum);
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //Tương tự ở pp trên
                    //Nếu đã tìm đc 3 phần tử cộng đc lại bằng 0
                    //Thì phần tử kế tiếp giống nhau sẽ bỏ qua
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // Bỏ qua các phần tử trùng lặp
                    }

                    //Này cx tương tự
                    //Nếu giá trị của left thay đổi thì cộng 3 số với giá trí right trc
                    //Ko thể bằng 0 nên ta phải đi tìm số mới cho vế phải
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // Bỏ qua các phần tử trùng lặp
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, 2, -1, -3, 4, -1, 2, 1 };
        List<List<Integer>> res = solution.threeSumMethod2(nums);

        System.out.println(res);
    }
}
