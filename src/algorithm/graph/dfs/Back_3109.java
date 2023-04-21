/**
 *  23.03.27
 *  Back_3109 빵집
 *  DFS, 그리디
 *
 *  1. check = 1 을하고 DFS를 진행한 후에 false가 반환되었을 때 check를 해제할 필요가 없다
 *      -> 어차피 그곳으로 가서 도달하지 못했다면 다른곳에서 그곳으로 가도 도달하지 못하기 때문이다.
 *      -> 일종의 DP
 *
 */

package algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_3109 {

    static int R,C;
    static char[][] Array;
    static int[][] Check;

    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Array = new char[R][C];
        Check = new int[R][C];
        for(int i = 0; i < R; i++){
            Array[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for(int i = 0; i < R; i++){
            if(DFS(i,0)){
                answer++;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public boolean DFS(int x, int y){
        if(y == C-1){
            return true;
        }

        for(int i = 0; i < 3; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= R || nx < 0 || ny >= C || ny < 0) continue;
            if(Check[nx][ny] == 0 && Array[nx][ny] == '.'){
                Check[nx][ny] = 1;
                if(DFS(nx,ny)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Back_3109().solution();
    }

}
