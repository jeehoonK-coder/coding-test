//Back_11967 불켜기
//BFS
//ArrayList배열 만드는 것

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_11967 {

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Impo{
        int check;
        int light;

        Impo(int check, int light){
            this.check = check;
            this.light = light;
        }
    }

    static int  N,M;
    static List<Point>[][] Array;
    static Impo[][] Map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new ArrayList[N+1][N+1];
        Map = new Impo[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
               Array[i][j] = new ArrayList<>();
               Map[i][j] = new Impo(0,0);
            }
        }

        for(int i = 0; i < M ; i++){
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           Array[x][y].add(new Point(a,b));
        }
        bw.write(BFS()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        int answer = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1,1));
        Map[1][1].check = 1;
        Map[1][1].light = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            List<Point> list = Array[p.x][p.y];
            for(Point o : list){
                if(Map[o.x][o.y].light == 0){
                    Map[o.x][o.y].light = 1;
                    for(int i = 0; i < 4; i++){
                        int nx = o.x+dx[i];
                        int ny = o.y+dy[i];
                        if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                        if(Map[nx][ny].check == 1 && Map[nx][ny].light == 1){
                            q.add(new Point(nx,ny));
                            Map[nx][ny].check = 1;
                        }
                    }
                    answer++;
                }
            }

            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if(Map[nx][ny].check == 0 && Map[nx][ny].light == 1){
                    q.add(new Point(nx,ny));
                    Map[nx][ny].check = 1;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws Exception{
        new Back_11967().solution();
    }
}
