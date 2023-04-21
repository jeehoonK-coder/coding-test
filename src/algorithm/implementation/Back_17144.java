/**
 *  23.04.19
 *  Back_17144 미세먼지 안녕!
 *  구현, 시뮬레이션
 *
 *  1. 단순 구현 -> 빨리푸는 것에 집중
*/


package algorithm.implementation;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_17144 {

    static int R,C,T;
    static int[][] Array, Dust;
    static int[] up = new int[2];
    static int[] down = new int[2];

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Array = new int[R][C];
        Dust = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
                if(Array[i][j] > 0) Dust[i][j] = Array[i][j];
                else if(Array[i][j] == -1){
                    if(up[0] == 0) up = new int[]{i,j};
                    else down = new int[]{i,j};
                }
            }
        }

        while(T-->0){
            //확산
            Dust = new int[R][C];
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(Array[i][j] > 0) Dust[i][j] = Math.floorDiv(Array[i][j], 5);
                }
            }
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(Dust[i][j] > 0) {
                        int count = 0;
                        for(int k = 0; k < 4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                            if(Array[nx][ny] != -1){
                                Array[nx][ny] += Dust[i][j];
                                count++;
                            }
                        }
                        Array[i][j] -= Dust[i][j] * count;
                    }
                }
            }

            //위 공기청정기
            int x = up[0] -1;
            int y = up[1];
            while( x > 0){
                Array[x][y] = Array[x-1][y];
                x--;
            }
            while(y < C-1){
                Array[x][y] = Array[x][y+1];
                y++;
            }
            while( x < up[0]){
                Array[x][y] = Array[x+1][y];
                x++;
            }
            while( y > 1){
                Array[x][y] = Array[x][y-1];
                y--;
            }
            Array[x][y] = 0;

            //아래 공기청정기
            x = down[0] +1;
            y = down[1];
            while( x < R-1){
                Array[x][y] = Array[x+1][y];
                x++;
            }
            while(y < C-1){
                Array[x][y] = Array[x][y+1];
                y++;
            }
            while( x > down[0]){
                Array[x][y] = Array[x-1][y];
                x--;
            }
            while( y > 1){
                Array[x][y] = Array[x][y-1];
                y--;
            }
            Array[x][y] = 0;
        }
        int total = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(Array[i][j] > 0) total += Array[i][j];
            }
        }
        bw.write(total+"");

        bw.flush();
        bw.close();
        br.close();
    }





    public static void main(String[] args) throws Exception {
        new Back_17144().solution();
    }
}
