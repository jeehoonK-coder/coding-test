/**
 *  23.03.22
 *  Back_2638 치즈
 *  DFS
 *
 *  1. 외부 공기와 내부 공기를 구분하기 위해 매 시간마다 0,0에서 DFS를 돌려 외부 공기를 찾는다.
 *  2. 그 후 시간에 맞춰서 DFS를 돌린다.
 */


package algorithm.dfs_bfs.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_2638 {

    static int N,M;
    static int[][] Cheese;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Cheese = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Cheese[i][j] = Integer.parseInt(st.nextToken());
                if(Cheese[i][j] == 1) Cheese[i][j] = -1;
            }
        }

        //치즈 : -1, 밖 공간 : -2
        boolean check = true;
        int[][] checkArr;
        int time = 1;
        while(check){
            check = false;
            checkArr = new int[N][M];
            checkAir(0,0,checkArr);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(Cheese[i][j] == -1 && checkArr[i][j] == 0) {
                        DFS(i,j,time, checkArr);
                        check = true;
                    }
                }
            }
            time++;
        }

        bw.write(time - 2+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void checkAir(int x, int y, int[][] check){
        check[x][y] = 1;
        Cheese[x][y] = -2;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
            if(Cheese[nx][ny] != -1){
                if(check[nx][ny] == 0){
                    checkAir(nx,ny, check);
                }
            }
        }
    }

    public void DFS(int x, int y, int time, int[][] check) {
        check[x][y] = 1;
        int count = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
            if(Cheese[nx][ny] == -2){
                count++;
            }
        }

        if(count >= 2){
            Cheese[x][y] = time;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
            if(Cheese[nx][ny] == -1 && check[nx][ny] == 0){
                DFS(nx,ny,time,check);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_2638().solution();
    }
}
