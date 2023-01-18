//Back_14442 벽 부수고 이동하기 2
//BFS, 벽을 부술 수 있는만큼 배열을 늘리면 시간이 오래걸림 -> 벽을 부순만큼을 저장한다음 그 개수보다 많은 수로 도착을 하면 느린거기 대문에 저장하지 않음

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_14442 {

    static class Point{
        int x;
        int y;
        int d;
        int through;

        Point(int x, int y, int d, int through){
            this.x = x;
            this.y = y;
            this.d = d;
            this.through = through;
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
        q.add(new Point(0,0,1, K));
        check[0][0] = K;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                return p.d;
            }
            for(int k = 0; k < 4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && check[nx][ny] < p.through){
                    if(array[nx][ny] == '0'){
                        q.add(new Point(nx,ny,p.d+1, p.through));
                    }
                    else if(array[nx][ny] == '1'){
                        q.add(new Point(nx,ny,p.d+1, p.through-1));
                    }
                    check[nx][ny] = p.through;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_14442().solution();
    }


}







/*
public class Back_14442 {

    static class Point{
        int x;
        int y;
        int d;
        int through;

        Point(int x, int y, int d, int through){
            this.x = x;
            this.y = y;
            this.d = d;
            this.through = through;
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
        System.out.println(answer);

        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(char[][] array){
        int[][][] check = new int[N][M][K+1];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1, 0));
        check[0][0][0] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                return p.d;
            }
            if(p.through == K){
                for(int k = 0; k < 4; k++){
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(array[nx][ny] == '0' && check[nx][ny][K] == 0){
                            q.add(new Point(nx,ny,p.d+1, p.through));
                            check[nx][ny][p.through] = 1;
                        }
                    }
                }
            }
            else{
                for(int k = 0; k < 4; k++){
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(array[nx][ny] == '0' && check[nx][ny][p.through] == 0){
                            q.add(new Point(nx,ny,p.d+1, p.through));
                            check[nx][ny][p.through] = 1;
                        }
                        else if(array[nx][ny] == '1' && check[nx][ny][p.through+1] == 0){
                            q.add(new Point(nx,ny,p.d+1, p.through+1));
                            check[nx][ny][p.through+1] = 1;
                        }
                    }
                }

            }

        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_14442().solution();
    }


}
*/