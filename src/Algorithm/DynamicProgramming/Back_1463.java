//Back_1463 1로 만들기(실버)
//DP 사용

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Back_1463 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int a = -1;
            int b = -1;
            if(i%2 == 0){
                a = dp[i/2]+1;
            }
            if(i%3 == 0){
                b = dp[i/3]+1;
            }
            if(a >= 0 && b >= 0){
                dp[i] = Math.min(Math.min(dp[i-1]+1,a),b);
            }
            else if( a < 0 && b <0){
                dp[i] = dp[i-1]+1;
            }
            else if( a > 0){
                dp[i] = Math.min(dp[i-1]+1,a);
            }
            else{
                dp[i] = Math.min(dp[i-1]+1,b);
            }
        }
        System.out.println(dp[n]);

    }


    public static void main(String[] args) throws Exception {
        new Back_1463().solution();
    }
}
