//Back_16933 벽 부수고 이동하기 3
//밤에 벽을 못부수는 것을 하루 추가하고 큐 뒤로 날려버리면 간단하다
//BFS

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_16933 {

    static class Point{
        int x;
        int y;
        int d;
        int through;
        int day; // 1이면 낮 0이면 밤

        Point(int x, int y, int d, int through, int day){
            this.x = x;
            this.y = y;
            this.d = d;
            this.through = through;
            this.day = day;

        }
    }

    static int N,M,K;
    static char[][] Array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Array = new char[N][M];
        for(int i = 0; i < N; i++){
            Array[i] = br.readLine().toCharArray();
        }

        int answer = BFS(Array);
        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(char[][] array){
        int[][] check = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == '0') {
                    check[i][j] = -1;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1, K,1));
        check[0][0] = K;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                return p.d;
            }
            for(int k = 0; k < 4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M ){
                    if(check[nx][ny] < p.through ){
                        if(array[nx][ny] == '0'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through,0));
                                check[nx][ny] = p.through;
                            }
                            else{
                                q.add(new Point(nx,ny,p.d+1, p.through,1));
                                check[nx][ny]= p.through;
                            }
                        }
                        else if(array[nx][ny] == '1'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through-1,0));
                                check[nx][ny] = p.through;
                            }
                            else{
                                q.add(new Point(p.x,p.y,p.d+1, p.through,1));

                            }
                        }

                    }
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_16933().solution();
    }
}

/*
public class Back_16933 {

    static class Point{
        int x;
        int y;
        int d;
        int through;
        int day; // 1이면 낮 0이면 밤

        Point(int x, int y, int d, int through, int day){
            this.x = x;
            this.y = y;
            this.d = d;
            this.through = through;
            this.day = day;

        }
    }

    static int N,M,K;
    static char[][] Array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Array = new char[N][M];
        for(int i = 0; i < N; i++){
            Array[i] = br.readLine().toCharArray();
        }

        int answer = BFS(Array);
        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(char[][] array){
        int[][][] check = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == '0') {
                    check[i][j][0] = -1;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1, K,1));
        check[0][0][0] = K;
        check[0][0][1] = 1;

        int min = Integer.MAX_VALUE;


        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                min = Math.min(min, p.d);
                continue;
            }
            for(int k = 0; k < 4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M ){
                    if(check[nx][ny][0] < p.through ){
                        if(array[nx][ny] == '0'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through,0));
                                check[nx][ny][1] = p.d+1;
                            }
                            else{
                                q.add(new Point(nx,ny,p.d+1, p.through,1));
                                check[nx][ny][1] = p.d+1;
                            }
                        }
                        else if(array[nx][ny] == '1'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through-1,0));
                                check[nx][ny][1] = p.d+1;
                            }
                            else{
                                q.add(new Point(nx,ny,p.d+2, p.through-1,0));
                                check[nx][ny][1] = p.d+2;
                            }
                        }
                        check[nx][ny][0] = p.through;
                    }
                    else if(check[nx][ny][0] == p.through && check[nx][ny][1] > p.d+1){
                        if(array[nx][ny] == '0'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through,0));
                                check[nx][ny][1] = p.d+1;
                            }
                            else{
                                q.add(new Point(nx,ny,p.d+1, p.through,1));
                                check[nx][ny][1] = p.d+1;
                            }
                        }
                        else if(array[nx][ny] == '1'){
                            if(p.day == 1) {
                                q.add(new Point(nx,ny,p.d+1, p.through-1,0));
                                check[nx][ny][1] = p.d+1;
                            }
                            else{
                                q.add(new Point(nx,ny,p.d+2, p.through-1,0));
                                check[nx][ny][1] = p.d+2;
                            }
                        }
                        //check[nx][ny][0] = p.through;
                    }

                }
            }

        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }


    public static void main(String[] args) throws Exception {
        new Back_16933().solution();
    }
}
*/

