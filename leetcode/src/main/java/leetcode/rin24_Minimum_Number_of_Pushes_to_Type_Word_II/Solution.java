package leetcode.rin24_Minimum_Number_of_Pushes_to_Type_Word_II;

import java.util.*;

class Data {
    private Character ch;
    private int num;

    public Data() {
    }

    public Data(Character ch, int num) {
        this.ch = ch;
        this.num = num;
    }

    public Character getCh() {
        return ch;
    }

    public int getNum() {
        return num;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public void setNum(int num) {
        this.num = num;
    }
}


public class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Data> data = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Data d = new Data();
            d.setCh(entry.getKey());
            d.setNum(entry.getValue());
            data.add(d);
        }

        data.sort((d1, d2) -> Integer.compare(d2.getNum(), d1.getNum()));

        Stack<Data> stack = new Stack<>();
        for (int i = data.size() - 1; i >= 0; i--) {
            stack.add(data.get(i));
        }

        int keyNums = 0, res = 0;
        int[] keys = new int[8];
        while (true) {
            if (keyNums == 8) {
                keyNums = 0;
            }
            if (stack.isEmpty()) {
                break;
            }
            Data d = stack.pop();

            keys[keyNums] = keys[keyNums] + 1;

            res += keys[keyNums] * d.getNum();

            keyNums++;
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
