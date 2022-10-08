//Back_2579 계단 오르기
//DP


package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2579 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scoreList = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            scoreList[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1) System.out.println(scoreList[1]);
        else if(n == 2) System.out.println(scoreList[1]+scoreList[2]);
        else{
            dp[1] = scoreList[1];
            dp[2] = scoreList[1]+scoreList[2];
            dp[3] = Math.max(scoreList[1]+scoreList[3],scoreList[2]+scoreList[3] );
            for(int i = 4; i <= n;i++){
                dp[i] = Math.max(dp[i-2]+scoreList[i], dp[i-3]+scoreList[i-1]+scoreList[i]);
            }
            System.out.println(dp[n]);
        }

    }

    public static void main(String[] args) throws Exception {
        new Back_2579().solution();
    }
}
