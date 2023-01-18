//Back_1912 연속합 (실버)
//DP

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1912 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        int[] dp = new int[n+1];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
            dp[i+1] = dp[i]+number[i];

        }
        int max = dp[1];
        int min = dp[1];
        for(int i = 2; i <= n ;i++){
            int a = Math.max(dp[i] - min,dp[i]);
            if(max < a) max = a;
            if(dp[i] < min) min = dp[i];
        }
        System.out.println(max);
    }


    public static void main(String[] args) throws Exception {
        new Back_1912().solution();
    }
}
