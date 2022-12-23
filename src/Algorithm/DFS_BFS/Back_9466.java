//Back_9466 텀 프로젝트
//DFS

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_9466 {

    static int  T,N;
    static int[] Array;
    static int[] AnswerArray;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Array = new int[N+1];
            AnswerArray = new int[N+1];
            for(int i = 1; i <= N; i++){
                Array[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <=N; i++){
                int[] check = new int[N+1];
                if( AnswerArray[i] == 0) DFS(i,i,check);

            }
            int count = 0;
            for(int i = 1; i <= N; i++){
                if(AnswerArray[i] == 0){
                    count++;
                }
            }
            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public boolean DFS(int start, int end, int[] check){
        check[start] = 1;
        if(Array[start] == end){
            AnswerArray[start] = 1;
            return true;
        }
        if(check[Array[start]] == 0 && AnswerArray[Array[start]] == 0){
            if(DFS(Array[start], end, check)){
                AnswerArray[start] = 1;
                return true;
            }
            return false;
        }
        else return false;
    }

    public static void main(String[] args) throws Exception{
        new Back_9466().solution();
    }
}
