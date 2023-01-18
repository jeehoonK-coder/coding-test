//Back_11726 2xn 타일링 (실버)
//DP를 사용하지 않으면 시간초과

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11726 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for(int i = 1; i<=n ; i++){
            dp[i] = dp[i-1]+num[i-1];
        }
        for(int i = 0; i < k ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[b]-dp[a-1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_11726().solution();
    }
}
