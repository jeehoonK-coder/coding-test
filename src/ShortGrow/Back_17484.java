//Back_17484 진우의 달 여행(small) (실버)
//DFS , DP로 어케푸는지 모르겟음

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_17484 {

    static int N,M,Min;
    static int[][] Array;
    static int[] dz = {-1,0,1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N][M];
        Min = Integer.MAX_VALUE;
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            DFS(Array[0][i],0,i,2);
        }
        bw.write(Min+"");
        bw.flush();
    }

    public void DFS(int total, int depth, int x, int dircetion){
        if(depth >= N-1){
            Min = Math.min(Min,total);
            return;
        }
        for(int i = 0; i < 3; i++){
            if(dz[i] == dircetion) continue;
            int nz = x+dz[i];
            if(nz >= 0 && nz < M){
                DFS(total+Array[depth+1][nz],depth+1,nz,dz[i]);
            }
        }


    }


    public static void main(String[] args) throws Exception {
        new Back_17484().solution();
    }
}
