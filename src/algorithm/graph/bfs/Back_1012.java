//Back_1012 유기농 배추 (실버)
//BFS

package algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1012 {

    static int T,N,M,K;
    static int[][] Array;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Array = new int[N][M];
            while(K-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Array[y][x] = 1;
            }
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(Array[i][j] == 1){
                        BFS(new Point(i,j));
                        count++;

                    }
                }
            }
            bw.write(count+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void BFS(Point point){
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        Array[point.x][point.y] = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(Array[nx][ny] == 1){
                    q.add(new Point(nx,ny));
                    Array[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1012().solution();
    }

}
