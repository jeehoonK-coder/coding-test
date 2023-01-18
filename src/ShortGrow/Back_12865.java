//Back_12865 평범한 배낭
//DP문제
//12920, 2293

package ShortGrow;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_12865 {
    static int dp[][], w[], v[];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        dp = new int [n+1][value+1];
        w = new int[n+1];
        v = new int[n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());

        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=value;j++) {
                dp[i][j] = dp[i-1][j];
                if(j - w[i]>=0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        sb.append(dp[n][value]);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Back_12865().solution();
    }
}
