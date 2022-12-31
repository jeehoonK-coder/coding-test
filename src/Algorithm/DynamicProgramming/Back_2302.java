//Back_2302 극장 좌석(실버)
//DP

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_2302 {

    static int N,M;
    static int[] Array;
    static int[] DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        if(N == 1) {
            bw.write(1+"");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        DP = new int[N+1];
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;
        for(int i = 3; i <= N; i++){
            DP[i] = DP[i-1]+DP[i-2];
        }
        if(M == 0) {
            bw.write(DP[N] + "");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        Array = new int[M];
        for(int i = 0; i < M; i++){
            Array[i] = Integer.parseInt(br.readLine());
        }
        int answer = 1;
        answer *= DP[Array[0] -1];
        for(int i = 0; i < M-1; i++){
            answer *= DP[(Array[i+1] - Array[i] - 1)];
        }
        answer *= DP[N-Array[M-1]];
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_2302().solution();
    }
}
