package study.Dynamic_Programming.Subset_Sum_Problem;

import java.util.Arrays;

public class Solution  {

}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {69, 16, 82, 170, 31, 24, 45, 112};
        int S = 92;
        boolean[] dp= new boolean[S+1];
        dp[0] = true;

        for(int i=0; i<a.length ;i++){
            for(int j = S; j >= a[i] ;j--){
                if(dp[j - a[i]]==true){
                    dp[j] = true;                }
            }
        }
        if(dp[S]){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        System.out.println(Arrays.toString(dp));
    }
}