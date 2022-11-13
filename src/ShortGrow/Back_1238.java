//Back_1238

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1238 {

    static int N,M,X,Max;
    static int[][] Array, MinArray;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Array = new int[N+1][N+1];
        MinArray = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            Array[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for(int i = 1; i < N+1; i++){

        }
        for(int i = 1; i < N+1; i++){
            max = Math.max(max, MinArray[i][X] + MinArray[X][i]);
        }

        bw.write(max+"");
        bw.flush();
    }

    public void Dijkstra(int start, int end, int[] check, int total){
        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        boolean[] visited = new boolean[N+1];

        while(!q.isEmpty()){
            int a = q.poll();
            visited[a] = true;
            for(int i = 1; i < M+1 ; i++){
                if(Array[a][i] > 0 && !visited[i]){

                }

            }

        }


    }

    public static void main(String[] args) throws Exception {
        new Back_1238().solution();
    }

}
