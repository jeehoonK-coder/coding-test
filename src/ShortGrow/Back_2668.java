//Back_2668 숫자고르기
//DFS

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Back_2668 {

    static int N,K;
    static int[] Array;
    static List<Integer> List = new ArrayList<>();
    static boolean[] Check;

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Array = new int[N+1];
        for(int i = 1; i <= N; i++){
            Array[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++){
            Check = new boolean[N+1];
            DFS(i,i);
        }
        bw.write(List.size()+"\n");
        for(int a : List) bw.write(a+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(int i, int start){
        if(Check[i]){
            if(i == start){
                List.add(start);
            }
        }
        else{
            Check[i] = true;
            DFS(Array[i],start);
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_2668().solution();
    }
}
