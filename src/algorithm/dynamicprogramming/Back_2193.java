//Back_2193 이친수 (실버)
//DP


package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2193 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n>1) dp[2] = 1;
        for(int i = 3; i <= n ;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws Exception {
        new Back_2193().solution();
    }
}

