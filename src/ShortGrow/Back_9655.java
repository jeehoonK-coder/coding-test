//Back_9655 돌 게임 (실버)
//DP (DP이긴하지만 점화식이 짝,홀이라 짝홀로 풀어도 맞음)

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_9655 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        /*
        dp[1] = 1;

        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-1] == 1 ? 2 : 1;
        }
        if(dp[n] == 1) System.out.println("SK");
        else{
            System.out.println("CY");
        }
        */
        if(n % 2 == 1) System.out.println("SK");
        else{
            System.out.println("CY");
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_9655().solution();
    }
}
