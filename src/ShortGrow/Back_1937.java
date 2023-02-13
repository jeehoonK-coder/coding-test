//Back_1937 욕심쟁이 판다
//DFS + DP

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1937 {

    static int N;
    static int[][] Array,DP;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Array = new int[N][N];
        DP = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(DP[i], -1);
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(DP[i][j] == -1){
                    DFS(i, j);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer = Math.max(answer, DP[i][j]);
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int DFS(int x, int y){
        int cnt = 1;
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(Array[x][y] >= Array[nx][ny]) continue;
            if(DP[nx][ny] != -1) cnt = Math.max(cnt,DP[nx][ny] + 1) ;
            else{
                cnt = Math.max(cnt,DFS(nx,ny) + 1);
            }
        }
        DP[x][y] = cnt;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new Back_1937().solution();
    }

}
