//Back_2240 자두나무
//DP 3차원 배열

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2240 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] trees = new int[n+1];
        for(int i = 1; i <= n;i++){
            trees[i] = Integer.parseInt(br.readLine());
        }
        int[][][] dp = new int[2][n+1][w+1];
        for(int i = 1; i <= n;i++){
            for(int j = 0; j<w+1;j++){
                if(trees[i] == 1){
                    if(j == 0){
                        dp[0][i][j] = dp[0][i-1][j] +1;
                        continue;
                    }
                    dp[0][i][j] = Math.max(dp[0][i-1][j],dp[1][i-1][j-1])+1;
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[0][i-1][j-1]);


                }
                else{
                    if(j==0){
                        dp[0][i][j] = dp[0][i-1][j];
                        continue;
                    }
                    dp[0][i][j] = Math.max(dp[0][i-1][j],dp[1][i-1][j-1]);
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[0][i-1][j-1])+1;
                }
            }
        }

        System.out.println(Math.max(dp[0][n][w],dp[1][n][w]));
    }


    public static void main(String[] args) throws Exception{
        new Back_2240().solution();
    }
}
