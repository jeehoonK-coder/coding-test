//Back_1600 말이 되고픈 원숭이
//BFS

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1600 {

    static class Point{
        int x;
        int y;
        int d;
        int horse;

        Point(int x, int y, int d, int horse){
            this.x = x;
            this.y = y;
            this.d = d;
            this.horse = horse;
        }
    }

    static int  K,W,H;
    static int[][] Array;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[] hx = {2,2,-2,-2,1,-1,1,-1};
    static int[] hy = {1,-1,1,-1,2,2,-2,-2};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Array = new int[H][W];

        for(int i = 0; i < H ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = BFS();
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        Queue<Point> q = new LinkedList<>();
        int[][] check = new int[H][W];
        for(int i = 0; i < H; i++){
            Arrays.fill(check[i], -1);
        }
        q.add(new Point(0,0,0,K));
        check[0][0] = K;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == H-1 && p.y == W-1){
                return p.d;
            }
            if(p.horse > 0){
                for(int i = 0; i < 8; i++){
                    int nx = p.x+hx[i];
                    int ny = p.y+hy[i];
                    if(nx >= 0 && ny >= 0 && nx < H && ny < W && check[nx][ny] < p.horse-1 && Array[nx][ny] == 0){
                        q.add(new Point(nx,ny,p.d+1,p.horse-1));
                        check[nx][ny] = p.horse-1;
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < H && ny < W && check[nx][ny] < p.horse && Array[nx][ny] == 0){
                    q.add(new Point(nx,ny,p.d+1,p.horse));
                    check[nx][ny] = p.horse;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        new Back_1600().solution();
    }
}
