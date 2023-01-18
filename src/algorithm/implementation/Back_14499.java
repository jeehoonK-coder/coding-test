//Back_14499 주사위 굴리기
//구현, 시뮬레이션

package algorithm.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_14499 {

    static int N,M,x,y,K;
    static int[][] Array;
    static int[] dice = new int[6];

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    //      3
    //   4  0  5
    //      1
    //      2
    static int[][] rollPattern = {{5,1,4,3,0,2},{4,1,5,3,2,0},{3,0,1,2,4,5},{1,2,3,0,4,5}};

    public void rolling(int move){
        int[] temp = new int[6];
        int n = 0;
        for(int i : rollPattern[move]){
            temp[i] = dice[n];
            n++;
        }
        for(int i = 0; i < 6; i++){
            dice[i] = temp[i];
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while(K-->0){
            int move = Integer.parseInt(st.nextToken())-1;
            if(x+dx[move] >= M || x+dx[move] < 0 || y+dy[move] >= N || y+dy[move] < 0) continue;
            rolling(move);
            x = x+dx[move];
            y = y+dy[move];
            int up = dice[0];
            if(Array[y][x] == 0){
                Array[y][x] = dice[2];
            }
            else{
                dice[2] = Array[y][x];
                Array[y][x] = 0;
            }
            bw.write(up+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Back_14499().solution();
    }
}
