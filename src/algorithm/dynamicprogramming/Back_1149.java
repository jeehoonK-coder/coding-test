//Back_1149 RGB거리(실버1)
//DP 활용

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1149 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] house = new int[n][3];
        for(int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][3];
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][1]+house[i][0],dp[i-1][2]+house[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+house[i][1],dp[i-1][2]+house[i][1]);
            dp[i][2] = Math.min(dp[i-1][0]+house[i][2],dp[i-1][1]+house[i][2]);
        }
        int answer = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
        System.out.println(answer);
    }


    public static void main(String[] args) throws Exception {
        new Back_1149().solution();
    }

}
