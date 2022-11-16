//Back_4485 녹색 옷 입은 애가 젤다지?
//BFS

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_4485 {

    static int N;
    static int[][] Array;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            Array = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    Array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int dis = BFS(Array);
            bw.write("Problem "+count+": "+dis+"\n");
            count++;
        }

        bw.flush();
    }

    public int BFS(int[][] array){
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);



        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        dist[0][0] = array[0][0];
        while(!q.isEmpty()){
            int[] a = q.poll();
            int x = a[0];
            int y = a[1];
            int rupi = dist[x][y];

            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>= 0 && nx < N && ny>=0 && ny < N && dist[nx][ny] > rupi+array[nx][ny]){
                    dist[nx][ny] = rupi+array[nx][ny];
                    q.add(new int[]{nx,ny});

                }

            }
        }

        return dist[N-1][N-1];

    }

    public static void main(String[] args) throws Exception {
        new Back_4485().solution();
    }
}
