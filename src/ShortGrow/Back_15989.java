//Back_15989 1,2,3 더하기 4 (실버)
//DP

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_15989 {

    static int N;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4 ; i < 10001 ; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i = 0; i < N ; i++){
            int a = Integer.parseInt(br.readLine());
            bw.write(dp[a][1]+dp[a][2]+dp[a][3] + "\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Back_15989().solution();
    }
}
