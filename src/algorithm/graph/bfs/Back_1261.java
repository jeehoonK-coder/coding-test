/**
 *  23.03.26
 *  Back_1261 알고스팟
 *  BFS, 다익스트라, 0-1 너비 우선 탐색
 *
 *  1. 벽을 부순개수를 기준으로 우선 순위큐를 이용하는 것이 포인트
 */


package algorithm.graph.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_1261 {

    static int N,M;
    static int[][] Array;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[M][N];
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        int answer = BFS();
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int BFS(){
        //int[] : x,y, 벽을 부신 수
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[][] check = new int[M][N];
        for(int i = 0; i < M; i++){
            Arrays.fill(check[i], 10000);
        }
        queue.add(new int[]{0,0,0});


        while(!queue.isEmpty()){
            int[] point = queue.poll();
            if(point[0] == M-1 && point[1] == N-1){
                //true
                return point[2];
            }

            for(int i = 0; i < 4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(nx >= M || nx < 0 || ny >= N || ny < 0) continue;
                if(check[nx][ny] > point[2] && Array[nx][ny] == 0){
                    check[nx][ny] = point[2];
                    queue.add(new int[]{nx,ny, point[2]});
                }
                else if(check[nx][ny] > point[2] + 1){
                    check[nx][ny] = point[2]+1;
                    queue.add(new int[]{nx,ny,point[2]+1});
                }
            }

        }
        //false
        return 0;

    }

    public static void main(String[] args) throws Exception {
        new Back_1261().solution();
    }
}
