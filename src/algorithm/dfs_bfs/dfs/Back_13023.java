/**
 *  23.03.23
 *  Back_13023 ABCDE
 *  DFS
 *
 *  1. 전형적인 DFS문제
 *  2. ArrayList를 사용하였지만 LinkedList를 사용한다면 더 빠를 것..
 */

package algorithm.dfs_bfs.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_13023 {

    static int N,M,Answer = 0;
    static List<Integer>[] RelationList;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        RelationList = new List[N];
        for(int i = 0; i < N; i++){
            RelationList[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            RelationList[a].add(b);
            RelationList[b].add(a);
        }
        int[] check;
        for(int i = 0; i < N; i++){
            if(Answer == 1){
                break;
            }
            check = new int[N];
            check[i] = 1;
            DFS(i, 0,check);
        }
        bw.write(Answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void DFS(int num, int depth, int[] check){
        if(depth == 4){
            Answer = 1;
            return;
        }
        for(int n : RelationList[num]){
            if(check[n] == 0){
                check[n] = 1;
                DFS(n, depth+1, check);
                check[n] = 0;
            }
        }


    }


    public static void main(String[] args) throws Exception {
        new Back_13023().solution();
    }
}
