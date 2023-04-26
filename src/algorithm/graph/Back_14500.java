/**
 *  23.04.27
 *  Back_14500 테트로미노
 *  그래프, 브루트포스 알고리즘
 *
 *  1. 전체 배열에서 4개를 뽑는 조합을 해서 구할려고하엿으나 시간이 초과할것같아 제외
 *  2. 그냥 모든 경우의 수를 미리 만들어놓고 모든 좌표에서 검정
 */

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_14500 {

    static int N, M, MAX = 0;
    static int[][] Array;
    static int[][][] tetirs = {{{0,0},{0,1},{0,2},{0,3}}, {{0,0},{1,0},{2,0},{3,0}}, {{0,0},{1,0},{0,1},{1,1}},  {{0,0},{1,0},{2,0},{2,1}},
                            {{0,1},{1,1},{2,1},{2,0}}, {{0,0},{0,1},{1,1},{2,1}}, {{0,0},{0,1},{1,0},{2,0}}, {{0,0},{1,0},{1,1},{1,2}},
                            {{0,2},{1,1},{1,2},{1,0}}, {{0,0},{0,1},{0,2},{1,2}}, {{0,0},{1,0},{0,1},{0,2}}, {{0,0},{1,0},{1,1},{2,1}},
                            {{0,1},{1,1},{1,0},{2,0}}, {{1,0},{1,1},{0,1},{0,2}}, {{0,0},{0,1},{1,1},{1,2}}, {{0,1},{1,0},{1,1},{1,2}},
                            {{0,0},{0,1},{0,2},{1,1}}, {{0,0},{1,0},{1,1},{2,0}}, {{0,1},{1,1},{1,0},{2,1}}};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < 19; k++){
                    int max = 0;
                    for(int l = 0; l < 4; l++){
                        int nx = i+tetirs[k][l][0];
                        int ny = j+tetirs[k][l][1];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                        max += Array[nx][ny];
                    }
                    MAX = Math.max(MAX,max);
                }
            }
        }

        bw.write(MAX+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_14500().solution();
    }
}
