//Back_1926 그림 (실버)
//BFS

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1926 {
    boolean[][] Check;
    int N,M;
    int[][] Array;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Array = new int[N][M];
        Check = new boolean[N][M];
        for(int i = 0; i < N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int max = 0;
        for(int i = 0; i < N;i++){
            for(int j = 0; j < M; j++){
                if(Array[i][j] == 1 && !Check[i][j]){
                    count++;
                    Check[i][j] = true;
                    max = Math.max(max,BFS(i,j));

                }

            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public int BFS(int i , int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int size = 0;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            size++;
            for(int a = 0; a < 4; a++){
                int di = point[0]+dx[a];
                int dj = point[1]+dy[a];
                if(di < N && di >= 0 && dj < M && dj >= 0 && !Check[di][dj] && Array[di][dj] == 1){
                    queue.add(new int[]{di,dj});
                    Check[di][dj] = true;
                }
            }

        }
        return size;
    }



    public static void main(String[] args) throws Exception {
        new Back_1926().solution();
    }

}
