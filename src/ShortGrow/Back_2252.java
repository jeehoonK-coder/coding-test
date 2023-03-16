/**
 *  23.03.16
 *  Back_2252 줄 세우기
 *  위상정렬 (topology sort)
 *
 *  1. Indegree 배열을 이용하여 간선개수를 저장한다.
 *  2. Queue에 Indegree가 0인것을 차례로 저장 후 하나씩 뺀다.
 */


package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_2252 {

    static int N,M;
    static int[] Indegree;
    static List<Integer>[] PriList;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Indegree = new int[N+1];
        PriList = new List[N+1];
        for(int i = 1; i <= N; i++){
            PriList[i] = new ArrayList<>();
        }
        Indegree[0] = 1;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Indegree[b]++;
            PriList[a].add(b);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++){
            if(Indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int n = queue.poll();
            bw.write(n+" ");
            for(int k : PriList[n]){
                Indegree[k]--;
                if(Indegree[k] == 0){
                    queue.add(k);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Back_2252().solution();
    }
}
