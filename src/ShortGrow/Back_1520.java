//Back_1520 내리막 길
//DP + DFS

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1520 {


    static int M,N;
    static int[][] Array;
    static int[][] DP;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Array = new int[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP = new int[M][N];
        for(int[] a : DP){
            Arrays.fill(a, -1);
        }
        DP[0][0] = 1;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(DP[i][j] == -1) {
                    DFS(i,j);
                }
            }
        }

        bw.write(DP[M-1][N-1] + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public int DFS(int x, int y){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(Array[nx][ny] <= Array[x][y]) continue;
            if(DP[nx][ny] != -1) cnt += DP[nx][ny];
            else{
                cnt += DFS(nx,ny);
            }
        }
        DP[x][y] = cnt;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new Back_1520().solution();
    }
}
