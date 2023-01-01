//Back_18427 함께 블록 쌓기
//DP

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class Back_18427 {

    static int N,M,H;
    static List[] Array;
    static int[][] DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Array = new List[N];
        DP = new int[N+1][H+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            DP[i-1][0] = 1;
            int num = st.countTokens();
            while(num --> 0){
                int h = Integer.parseInt(st.nextToken());
                for(int j = h; j <= H; j++){
                    DP[i][j] = (DP[i][j] + DP[i-1][j-h]) % 10007;
                }
            }
            for(int k = 1; k <= H; k++){
                DP[i][k] = (DP[i][k] + DP[i-1][k]) % 10007;
            }

        }

        bw.write(DP[N][H]+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_18427().solution();
    }
}
