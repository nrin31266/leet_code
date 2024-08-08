package leetcode.rin10_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        s= " " + s;
        int len = s.length();
        int rs = 0;
        boolean theFirst = false;

        for (int i = len - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && theFirst){
                break;
            }else if(s.charAt(i) != ' '){
                rs++;
                if(s.charAt(i-1) == ' '){
                    theFirst=true;
                }
            }
        }
        return rs;
    }

    public int lengthOfLastWordMethod2(String s) {
        int i = s.length() - 1;
        int c = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            c++;
            i--;
        }
        return c;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa fwfregrereh4thjjh4   egdfgfdg     sdfds   ";
        System.out.println(solution.lengthOfLastWord(s));
    }
}
