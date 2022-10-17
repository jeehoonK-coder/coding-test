//Back_10844 쉬운 계단 수(실버)
//DP
//전에것을 곱하고 끝에 0,1만 빼는식으로 구현을 하였지만
//곱하는과정에서 오버플로가 발생해서 하나씩 다 더하면서 나머지를 구하는 방식으로 해결

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_10844 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] cnt = {0,1,1,1,1,1,1,1,1,1};
        dp[1] = 9;

        for(int i = 2; i <= n;i++){
            int[] temp = new int[10];
            for(int j = 0; j<10;j++){
                if(j == 0){
                    temp[j] = cnt[j+1];
                    continue;
                }
                if(j == 9){
                    temp[j] = cnt[j-1];
                    continue;
                }
                temp[j] = cnt[j-1]+cnt[j+1];
                temp[j] %= 1000000000;
            }
            for(int k = 0; k<10; k++){
                dp[i] += temp[k];
                dp[i] %= 1000000000;
            }
            cnt = temp;
        }

        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws Exception {
        new Back_10844().solution();
    }
}
