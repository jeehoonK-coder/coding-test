/**
 *  23.05.04
 *  Back_1944 복제 로봇
 *  BFS, 최소 스패닝 트리
 *
 *  1. 스패닝 트리를 활용 -> union-find를 활용
 */


package algorithm.graph;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1944 {

    static int N,M;
    static char[][] Array;
    static class Point{
        int x;
        int y;
        int dis;

        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));
    static int[] parent;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new char[N][N];
        for(int i = 0; i < N; i++){
            Array[i] = br.readLine().toCharArray();
        }
        Point[] points = new Point[M+1];
        int k = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Array[i][j] == 'S') points[0] = new Point(i,j,0);
                else if(Array[i][j] == 'K') {
                    points[k] = new Point(i,j,0);
                    k++;
                }
            }
        }


        for(int i = 0; i < M; i++){
            BFS(i, points);
        }

        parent = new int[M+1];
        for(int i = 0; i < M+1; i++){
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int p1 = find(node[0]);
            int p2 = find(node[1]);
            if(p1 != p2) {
                union(p1,p2);
                answer += node[2];
                count++;
            }
        }
        if(count != M) bw.write(-1+"");
        else bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void union(int p1, int p2){
        parent[p1] = p2;
    }

    public int find(int node){
        if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public void BFS(int idx, Point[] points){
        Queue<Point> q = new LinkedList<>();
        Point p1 = points[idx];
        q.add(p1);
        int[][] check = new int[N][N];
        check[p1.x][p1.y] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(Array[p.x][p.y] == 'S' || Array[p.x][p.y] == 'K'){
                for(int i = idx+1; i < points.length; i++){
                    if(p.x == points[i].x && p.y == points[i].y){
                        pq.add(new int[]{idx, i, p.dis});
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(Array[nx][ny] == '1') continue;
                if(check[nx][ny] == 0){
                    check[nx][ny] = 1;
                    q.add(new Point(nx,ny,p.dis+1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1944().solution();
    }
}
