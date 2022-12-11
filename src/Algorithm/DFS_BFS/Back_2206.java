//Back_2206 벽 부수고 이동하기
//벽을 queue에 담아 지우고 BFS를 돌렸으나 시간초과 -> 벽을 부순 경로와 안부순 경로 둘다 체크하면서 진행
//BFS

package Algorithm.DFS_BFS;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_2206 {

    static class Point{
        int x;
        int y;
        int d;
        boolean through;

        Point(int x, int y, int d, boolean through){
            this.x = x;
            this.y = y;
            this.d = d;
            this.through = through;
        }
    }

    static int N,M;
    static char[][] Array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
        boolean[][][] check = new boolean[N][M][2];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1, false));
        check[0][0][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                return p.d;
            }
            if(p.through){
                for(int k = 0; k < 4; k++){
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(array[nx][ny] == '0' && !check[nx][ny][1]){
                            q.add(new Point(nx,ny,p.d+1, true));
                            check[nx][ny][1] = true;
                        }
                    }
                }
            }
            else{
                for(int k = 0; k < 4; k++){
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(array[nx][ny] == '0' && !check[nx][ny][0]){
                            q.add(new Point(nx,ny,p.d+1, false));
                            check[nx][ny][0] = true;
                        }
                        else if(array[nx][ny] == '1' && !check[nx][ny][1]){
                            q.add(new Point(nx,ny,p.d+1, true));
                            check[nx][ny][1] = true;
                        }
                    }
                }

            }

        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_2206().solution();
    }


}




/*
public class Back_2206 {

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

    static int N,M;
    static char[][] Array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Array = new char[N][M];
        for(int i = 0; i < N; i++){
            Array[i] = br.readLine().toCharArray();
        }
        // 벽의 위치 저장
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int count = 0;
                if(Array[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                            if(Array[nx][ny] == '0'){
                                count++;
                            }
                        }
                        if(count > 1) {
                            queue.add(new Point(i,j,0));
                            break;
                        }
                    }
                }
            }
        }


        int answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            Array[p.x][p.y] = '0';
            int a = BFS(Array);
            if( a > 0){
                answer = Math.min(answer, a);
            }
            Array[p.x][p.y] = '1';
        }

        if(answer == Integer.MAX_VALUE) bw.write(-1+"");
        else{
            bw.write(answer+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(char[][] array){
        boolean[][] check = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        check[0][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                return p.d;
            }
            for(int k = 0; k < 4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(array[nx][ny] == '0' && !check[nx][ny]){
                        q.add(new Point(nx,ny,p.d+1));
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Back_2206().solution();
    }


}
*/
