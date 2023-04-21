//Back_2583 영역 구하기 (실버)
//BFS

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_2583 {

    static int N,M,K;
    static int[][] Array;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            Point p1,p2;
            p1 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            p2 = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int j = p1.x; j < p2.x; j++){
                for(int k = p1.y; k < p2.y; k++){
                    Array[k][j] = 1;
                }
            }
        }
        List<Integer> areaList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(Array[i][j] == 0){
                    areaList.add(BFS(i,j));
                }
            }
        }
        areaList.sort(Comparator.naturalOrder());
        bw.write(areaList.size()+"\n");
        for(int i : areaList){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(int x , int y){
        Point p = new Point(x,y);
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        int area = 1;
        Array[p.x][p.y] = area;
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(Array[nx][ny] == 0){
                    q.add(new Point(nx,ny));
                    Array[nx][ny] = ++area;
                }
            }
        }
        return area;

    }


    public static void main(String[] args) throws Exception {
        new Back_2583().solution();
    }
}
