/**
 *  23.03.12
 *  Back_10942 팰린드롬?
 *  DP
 *
 *  1. 길이가 1인것부터 차례대로 DP수행
 */


package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_10942 {

    static int N,M;
    static int[] Array;
    static int[][] DP;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Array = new int[N+1];
        DP = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++){
            DP[i][i] = 1;
        }
        for(int i = 1; i < N; i++){
            if(Array[i] == Array[i+1]) DP[i][i+1] = 1;
        }
        for(int i = 2; i < N; i++){
            for(int j = 1; j<= N -i ;j++){
                if(Array[j] == Array[j+i] && DP[j+1][j+i-1] == 1) DP[j][j+i] = 1;
            }
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            bw.write(DP[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_10942().solution();
    }
}
