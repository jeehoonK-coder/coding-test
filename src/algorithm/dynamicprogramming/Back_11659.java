//Back_11659 구간 합 구하기4 (실버)
//DP

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_11659 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        if(n == 1) dp[1] = 1;
        else if(n == 2) dp[2] = 2;
        else if(n == 3) dp[3] = 3;
        else{
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for(int i = 4; i <= n; i++){
                dp[i] = (dp[i-1]+dp[i-2])%10007;
            }
        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws Exception {
        new Back_11659().solution();
    }
}
