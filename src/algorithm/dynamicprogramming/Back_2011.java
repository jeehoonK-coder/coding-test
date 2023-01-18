//Back_2011 암호코드
//DP

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2011 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] numList = str.split("");
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        if(Integer.parseInt(numList[0]) == 0) dp[1] = 0;
        else{
            dp[1] = 1;
        }
        for(int i = 2; i<=n; i++){
            if(numList[i-2].equals("1") && !numList[i-1].equals("0")){
                dp[i] = dp[i-2] + dp[i-1];
            }
            else if(numList[i-1].equals("0") && Integer.parseInt(numList[i-2]) <= 2 && Integer.parseInt(numList[i-2]) >= 1){
                dp[i] = dp[i-2];
            }
            else if(numList[i-1].equals("0")){
                dp[n] = 0;
                break;
            }
            else if(numList[i-2].equals("2") && Integer.parseInt(numList[i-1]) <= 6){
                dp[i] = dp[i-2] + dp[i-1];
            }
            else{
                dp[i] = dp[i-1];
            }
            dp[i] %= 1000000;

        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws Exception {
        new Back_2011().solution();
    }
}
