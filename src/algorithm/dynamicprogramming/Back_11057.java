//Back_11057 오르막 수 (실버)
//DP

package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Back_11057 {

    static int N;
    static int[][] DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        DP = new int[10][N+1];
        for(int i = 0; i < 10; i++){
            DP[i][1] = 1;
        }
        for(int i = 2; i <= N; i++){
            for(int j= 0; j < 10; j++){
                int addNum = DP[j][i-1];
                for(int k = j; k < 10; k++){
                    DP[k][i] += addNum;
                }
            }
            for(int j = 0; j < 10; j++){
                DP[j][i] %= 10007;
            }

        }
        int total = 0;
        for(int i = 0; i < 10; i++){
            total += DP[i][N];
        }

        bw.write(total%10007+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_11057().solution();
    }
}
