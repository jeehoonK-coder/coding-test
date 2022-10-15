//Back_14501 퇴사 (실버)
//DP

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14501 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i+1][0] = Integer.parseInt(st.nextToken());
            cost[i+1][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+6];
        dp[0] = 0;
        for(int i = 1; i <= n;i++){
            int d = cost[i][0];
            dp[i+d-1] = dp[i+d-1] > dp[i-1]+cost[i][1] ? dp[i+d-1] : dp[i-1]+cost[i][1];
            int k = i;
            while(k != 0){
                if(dp[k] < dp[k-1]){
                    dp[k] = dp[k-1];
                    k--;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws Exception {
        new Back_14501().solution();
    }

}
