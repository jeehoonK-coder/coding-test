//Back_9466 텀 프로젝트
//DFS

package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_9466 {

    static int  T,N,Count;
    static int[] Array;
    static int[] Visited,Finished;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Array = new int[N+1];
            Visited = new int[N+1];
            Finished = new int[N+1];
            Count = 0;
            for(int i = 1; i <= N; i++){
                Array[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <=N; i++){
                DFS(i);
            }
            bw.write(N-Count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(int start){
        if(Visited[start] == 1){
            return;
        }

        Visited[start] = 1;
        int next = Array[start];

        if(Visited[next] != 1) DFS(next);
        else{
            if(Finished[next] != 1){
                Count++;
                for(int i = next; i != start; i = Array[i]){
                    Count++;
                }
            }
        }
        Finished[start] = 1;
    }

    public static void main(String[] args) throws Exception{
        new Back_9466().solution();
    }
}
