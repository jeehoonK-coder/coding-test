//Back_3190 뱀
//구현, 시뮬레이션, 덱(디큐)

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_3190 {

    static int N,K,L,D;
    static int[][] Array;

    // 우 : 0 / 하 : 1 / 좌 : 2 / 상 : 3
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] turn = {{1,3},{2,0},{3,1},{0,2}};

    static class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Direction {
        int t;
        char c;

        Direction(int t, char c){
            this.t = t;
            this.c = c;
        }

    }
    static Queue<Direction> directions = new LinkedList<>();
    static Deque<Point> Snake = new ArrayDeque<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Array = new int[N][N];
        Array[0][0] = 1;
        //뱀은 1, 사과는 3
        K = Integer.parseInt(br.readLine());
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Array[x-1][y-1] = 3;
        }

        L = Integer.parseInt(br.readLine());
        while(L --> 0){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            directions.add(new Direction(t,c));
        }
        //방향
        D = 0;
        int count = 0;
        Point point = new Point(0,0);
        Snake.add(new Point(0,0));
        while(true){
            count++;
            int nx = point.x+dx[D];
            int ny = point.y+dy[D];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            if(Array[nx][ny] == 1) break;
            if(Array[nx][ny] == 3){
                Array[nx][ny] = 1;
                Snake.addFirst(new Point(nx,ny));
                point.x = nx;
                point.y = ny;
            }
            else if(Array[nx][ny] == 0) {
                Snake.addFirst(new Point(nx,ny));
                Array[nx][ny] = 1;
                Point p = Snake.pollLast();
                Array[p.x][p.y] = 0;
                point.x = nx;
                point.y = ny;
            }
            if(!directions.isEmpty() && directions.peek().t == count){
                Direction d = directions.poll();
                if(d.c == 'D') D = turn[D][0];
                else D = turn[D][1];
            }
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_3190().solution();
    }
}
