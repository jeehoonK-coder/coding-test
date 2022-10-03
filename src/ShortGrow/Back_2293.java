//Back_2293 동전1
//다이나믹 프로그래밍

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2293 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = 0; i <n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j<= k;j++){
                if(j >= coins[i])
                    dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception{
        new Back_2293().solution();
    }

}
