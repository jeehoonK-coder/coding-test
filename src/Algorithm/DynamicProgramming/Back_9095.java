//Back_9095 1,2,3 더하기
//DP 활용

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_9095 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            sb.append(DP(a)).append('\n');
        }
        System.out.println(sb);

    }

    public int DP(int a){
        if(a == 1) return 1;
        if(a == 2) return 2;
        if(a == 3) return 4;
        int[] dp = new int[a+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i <= a; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[a];
    }

    public static void main(String[] args) throws Exception {
        new Back_9095().solution();
    }
}
