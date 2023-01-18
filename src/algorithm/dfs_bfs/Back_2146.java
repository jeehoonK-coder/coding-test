//Back_2146 다리 만들기
//BFS

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_2146 {

    static class Point{
        int x;
        int y;
        int d;

        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N , Min = Integer.MAX_VALUE;
    static int[][] Array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Array = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 2;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Array[i][j] == 1){
                    region(i,j,count);
                    count++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Array[i][j] != 0){
                    BFS(i,j,Array[i][j]);
                }
            }
        }
        bw.write(Min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void BFS(int x, int y, int c){
        Queue<Point> q = new LinkedList<>();
        int[][] check = new int[N][N];
        q.add(new Point(x,y,0));
        check[x][y] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.d > Min){
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && check[nx][ny] == 0){
                    if(Array[nx][ny] != 0 && Array[nx][ny] != c){
                        Min = Math.min(Min, p.d);
                        return;
                    }
                    else if(Array[nx][ny] == 0){
                        q.add(new Point(nx,ny,p.d+1));
                        check[nx][ny] = 1;
                    }

                }
            }
        }
    }

    public void region(int x, int y, int c){
        Queue<Point> q = new LinkedList<>();
        int[][] check = new int[N][N];
        q.add(new Point(x,y,0));
        Array[x][y] = c;
        check[x][y] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && check[nx][ny] == 0 && Array[nx][ny] == 1){
                    q.add(new Point(nx,ny,0));
                    Array[nx][ny] = c;
                    check[nx][ny] = 1;
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        new Back_2146().solution();
    }
}
