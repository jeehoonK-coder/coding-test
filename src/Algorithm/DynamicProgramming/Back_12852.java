//Back_12852 1로 만들기2 (실버)
//DP

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_12852 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] numList = new int[n+1];
        int[] dp = new int[n+1];
        dp[1] = 0;

        for(int i = 2; i <= n; i++){
            int m = 1;
            dp[i] = dp[i-1]+1;
            if(i%2 == 0 && dp[i/2]+1 < dp[i]){
                dp[i] = dp[i/2]+1;
                m = 2;
            }
            if(i%3 == 0 && dp[i/3]+1 < dp[i]){
                dp[i] = dp[i/3]+1;
                m = 3;
            }
            numList[i] = m;
        }
        sb.append(dp[n]).append('\n');

        int num = n;
        sb.append(n).append(' ');
        while(num !=1){
            if(numList[num] == 1){
                num -=1;
            }
            else if(numList[num] == 2){
                num /=2;
            }
            else {
                num /=3;
            }
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Back_12852().solution();
    }
}
