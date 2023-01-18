//Back_1932 정수 삼각형 (실버)
//DP

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1932 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        for(int i = 1; i < n;i++){
            for(int j = 0; j<i+1;j++){
                if(j == 0) dp[i][j] = dp[i-1][j] + tri[i][j];
                else if(j == i) dp[i][j] = dp[i-1][j-1] + tri[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + tri[i][j];
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < n;i++){
            answer = Math.max(answer,dp[n-1][i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Back_1932().solution();
    }

}
