//Back_14940 쉬운 최단거리 (실버)
//BFS

package algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_14940 {

    static int N,M,X,Y;
    static int[][] Array;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
                if(Array[i][j] == 2){
                    X = i;
                    Y = j;
                }
            }
        }

        int[][] answer = BFS();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(answer[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int[][] BFS(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[N][M];
        int[][] temp = new int[N][M];
        check[X][Y] = true;
        q.add(new int[]{X,Y,0});
        temp[X][Y] = 0;

        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = a[0]+dx[i];
                int ny = a[1]+dy[i];

                if(nx>= 0 && ny >=0 && nx < N && ny < M){
                    if(!check[nx][ny] && Array[nx][ny] == 1){
                        q.add(new int[]{nx,ny,a[2]+1});
                        temp[nx][ny] = a[2]+1;
                        check[nx][ny] = true;
                    }
                    else if(Array[nx][ny] == 0){
                        check[nx][ny] = true;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(Array[i][j] == 1 && !check[i][j]) temp[i][j] = -1;
            }
        }
        return temp;
    }


    public static void main(String[] args) throws Exception {
        new Back_14940().solution();
    }
}
