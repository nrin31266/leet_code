package leetcode.rin4;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {

            String str = strs[i];
            String temp = "";

            for (int j = 0; j <(Math.min(str.length(), prefix.length())); j++) {
                if (str.charAt(j) == prefix.charAt(j)) {
                    temp = prefix.substring(0, j+1);
                }else break;
            }

            if(temp.isEmpty()) return ""; else prefix=temp;
        }

        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"dir","car"};

        System.out.println(solution.longestCommonPrefix(strs));

    }
}