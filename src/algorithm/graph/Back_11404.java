/**
 *  23.04.28
 *  Back_11404 플로이드
 *  그래프, 플로이드-워셜
 *
 */

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_11404 {

    static int N, M;
    static int[][] Array;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Array = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(Array[a][b] != 0) Array[a][b] = Math.min(Array[a][b], c);
            else Array[a][b] = c;
        }
        boolean check = true;
        while(check){
            check = false;
            for(int i = 1; i <= N ; i++){
                for(int j = 1; j <= N; j++){
                    for(int k = 1; k <= N; k++){
                        if(Array[i][k] == 0 || Array[k][j] == 0) continue;
                        if(i != j && Array[i][j] == 0 || Array[i][k] + Array[k][j] < Array[i][j]) {
                            Array[i][j] = Array[i][k] + Array[k][j];
                            check = true;
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                bw.write(Array[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_11404().solution();
    }
}
