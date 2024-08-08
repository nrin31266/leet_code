package leetcode.rin15_Group_Anagrams;

import java.util.*;

class Data{
    private boolean isUse = false;
    private String str;

    public Data( String str) {
        this.str = str;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<Data> dataList = new ArrayList<>();
        for (String str : strs) {
            dataList.add(new Data(str));
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if(!dataList.get(i).isUse()) {
                String s = dataList.get(i).getStr();

                dataList.get(i).setUse(true);
                List<String> list = new ArrayList<>();
                list.add(s);

                for (int j = 0; j < len; j++) {
                    if(!dataList.get(j).isUse()){
                        if (checkTheChain(s, strs[j])) {
                            list.add(dataList.get(j).getStr());
                            dataList.get(j).setUse(true);
                        }
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }

    private boolean checkTheChain(String a, String b) {
        if (a.length() != b.length()) return false;

        // Mảng để đếm tần suất ký tự
        int[] charCountA = new int[256]; // Giả sử ký tự ASCII
        int[] charCountB = new int[256];

        // Đếm tần suất ký tự trong chuỗi a
        for (int i = 0; i < a.length(); i++) {
            charCountA[a.charAt(i)]++;
        }

        // Đếm tần suất ký tự trong chuỗi b
        for (int i = 0; i < b.length(); i++) {
            charCountB[b.charAt(i)]++;
        }

        // So sánh tần suất ký tự
        for (int i = 0; i < 256; i++) {
            if (charCountA[i] != charCountB[i]) {
                return false;
            }
        }

        return true;
    }
}
class SolutionMethod2{
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // HashMap để nhóm các anagram
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Chuyển chuỗi thành mảng ký tự và sắp xếp
            char[] charArray = str.toCharArray();
            System.out.println(Arrays.toString(charArray));
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            System.out.println(sortedStr);

            // Nếu khóa chưa có thì tạo khóa mới với chuỗi đã sắp xếp
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // Chuyển giá trị của map thành danh sách
        return new ArrayList<>(map.values());
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionMethod2 solutionMethod2 = new SolutionMethod2();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> ans = solutionMethod2.groupAnagrams(strs);

        for (List<String> list : ans) {
            System.out.println(list.toString());
        }
    }

}