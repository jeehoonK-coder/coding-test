//Back_16920 확장 게임
//BFS

package algorithm.dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_16920 {

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int  N,M,P;
    static char[][] Array;
    static int[] NumPlayer;
    static Queue<Point>[] LocPlayerQueue;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Array = new char[N][M];
        NumPlayer = new int[P];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < P ; i++){
            NumPlayer[i] = Integer.parseInt(st.nextToken());
        }
        LocPlayerQueue = new Queue[P];
        for(int i = 0; i < P; i++){
            LocPlayerQueue[i] = new LinkedList<>();
        }
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                Array[i][j] = str.charAt(j);
                if(str.charAt(j) != '.' && str.charAt(j) != '#'){
                    LocPlayerQueue[Character.getNumericValue(str.charAt(j))-1].add(new Point(i,j));
                }
            }
        }
        BFS();
        int[] answer = new int[P];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(Array[i][j] != '.' && Array[i][j] != '#'){
                    answer[Character.getNumericValue(Array[i][j])-1]++;
                }
            }
        }
        for(int a : answer){
            bw.write(a+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public void BFS(){
        while(true){
            int breaking = 0;
            for(int i = 0; i < P; i++){
                Queue<Point> queue = LocPlayerQueue[i];
                int number = NumPlayer[i];

                while(number --> 0 && !queue.isEmpty()){
                    int size = queue.size();
                    while(size --> 0){
                        breaking = 1;
                        Point p = queue.poll();
                        for(int j = 0; j < 4; j++){
                            int nx = p.x+(dx[j]);
                            int ny = p.y+(dy[j]);
                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(Array[nx][ny] == '.'){
                                Array[nx][ny] = (char)(i+1+'0');
                                queue.add(new Point(nx,ny));
                            }
                        }
                    }
                }

            }
            if(breaking == 0) break;
        }

    }

    public static void main(String[] args) throws Exception{
        new Back_16920().solution();
    }
}