/**
 *  23.03.24
 *  Back_1405 미친 로봇
 *  DFS, 백트래킹
 *
 *  1. 전형적인 DFS 문제
 *  2. 간단하지 않는 것을 구한다음 1에서 그 값을 뺐는데 그냥 간단한 것을 구하는 것이 더 편하다
 *      -> 조건을 Depth가 N일때 확률을 더하는 것만 넣으면 된다.
 */


package algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1405 {

    static int N;
    static double Answer = 0;
    static double[] Percent = new double[4];
    static int[][] Board = new int[30][30];
    static int[][] Check = new int[30][30];

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++)
            Percent[i] = Double.parseDouble(st.nextToken()) / 100;
        Check[15][15] = 1;
        combination(15,15,1,0,false);

        bw.write(1-Answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void combination(int x, int y, double percent, int depth, boolean notSimple){
        if(notSimple){
            Answer += percent;
            return;
        }
        if(depth == N){
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(Check[nx][ny] == 0){
                Check[nx][ny] = 1;
                combination(nx,ny,percent*Percent[i], depth+1, false);
                Check[nx][ny] = 0;
            }
            else{
                combination(nx,ny, percent*Percent[i], depth+1, true);
            }

        }
    }


    public static void main(String[] args) throws Exception {
        new Back_1405().solution();
    }
}
