//Back_2156 포도주 시식 (실버)
//DP

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2156 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        int[] dp = new int[n+1];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = number[0];
        if(n > 1) dp[2] = number[0]+number[1];
        for(int i = 3; i <=n ;i++){
            dp[i] = Math.max(dp[i-1], dp[i-3]+number[i-1]+number[i-2]);
            dp[i] = Math.max(dp[i],dp[i-2]+number[i-1]);
            // 없어도 성립
            // if(i >= 5) dp[i] = Math.max(dp[i], dp[i-4]+number[i-1]+number[i-3]);
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Back_2156().solution();
    }
}
