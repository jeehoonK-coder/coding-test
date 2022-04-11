//BackJoon Question
//No.1010  다리놓기

package Back;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge {

    private int[][] dp = new int[40][40];

    private int bridgeCnt(int n, int m){
        if(dp[m][n] > 0){
            return dp[m][n];
        }
        if(n==0 || m==n){
            return dp[m][n] = 1;
        }
        return dp[m][n] = bridgeCnt(n-1,m-1)+bridgeCnt(n,m-1);
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cnt = bridgeCnt(a,b);
            sb.append(cnt).append('\n');
//            for(int j = 0; j<2; j++){
//                int s = Integer.parseInt(st.nextToken());
//                System.out.println(s);
//
//            }


        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Bridge().solution();
    }


}
