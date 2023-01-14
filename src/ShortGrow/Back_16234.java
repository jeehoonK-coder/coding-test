//Back_16234 인구 이동
//BFS, 구현, 시뮬레이션

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_16234 {

    static int N,L,R;
    static int[][] Array;
    static int[][] Check;
    static boolean Move = true;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Array = new int[N][N];
        Check = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(Move){
            Move = false;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(Check[i][j] == 0){
                        BFS(new Point(i,j));
                    }
                }
            }
            answer++;
            Check = new int[N][N];
        }

        bw.write(answer-1+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void BFS(Point point){
        Queue<Point> q = new LinkedList<>();
        Check[point.x][point.y] = 1;
        q.add(point);

        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        int total = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            total += Array[p.x][p.y];

            for(int i = 0; i < 4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                int gap = Math.abs(Array[p.x][p.y] - Array[nx][ny]);
                if(Check[nx][ny] == 0 && gap >= L && gap <= R){
                    Point np = new Point(nx,ny);
                    q.add(np);
                    Check[nx][ny] = 1;
                    pointList.add(np);
                }
            }
        }

        if(pointList.size() == 1) return;
        int count = total / pointList.size();
        for(Point p : pointList) {
            Array[p.x][p.y] = count;
        }
        Move = true;
    }


    public static void main(String[] args) throws Exception {
        new Back_16234().solution();
    }
}
