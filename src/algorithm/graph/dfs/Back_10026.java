/**
 *  23.03.22
 *  Back_10026 적록색약
 *  DFS (BFS로도 가능)
 *
 */

package algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_10026 {

    static int N;
    static char[][] Paint;
    static int[][] Check;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Paint = new char[N][N];
        Check = new int[N][N];
        for(int i = 0; i < N; i++){
            Paint[i] = br.readLine().toCharArray();
        }


        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Paint[i][j] == 'R' || Paint[i][j] == 'G' || Paint[i][j] == 'B'){
                    if(Check[i][j] == 0){
                        DFS(Paint[i][j], i,j);
                        count++;
                    }

                }
            }
        }
        bw.write(count+" ");
        count = 0;
        Check = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Paint[i][j] == 'R'){
                    Paint[i][j] = 'G';
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Paint[i][j] == 'G' || Paint[i][j] == 'B'){
                    if(Check[i][j] == 0){
                        DFS(Paint[i][j], i,j);
                        count++;
                    }
                }
            }
        }
        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(char c, int i, int j){
        Check[i][j] = 1;
        for(int k = 0; k < 4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
            if(Paint[nx][ny] == c && Check[nx][ny] == 0){
                DFS(c,nx,ny);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_10026().solution();
    }
}
