//Back_1766 문제집
//위상 정렬, 우선순위 큐

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1766 {

    static int N,M;
    static ArrayList<Integer>[] NumberList;
    static int[] Indegree;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        NumberList = new ArrayList[N+1];
        Indegree = new int[N+1];
        for(int i=1; i<=N; i++){
            NumberList[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            NumberList[x].add(y);
            Indegree[y]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            if(Indegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int current = pq.poll();
            bw.write(current+" ");
            for(int i = 0; i < NumberList[current].size(); i++){
                int next = NumberList[current].get(i);
                Indegree[next]--;
                if(Indegree[next] == 0){
                    pq.add(next);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1766().solution();
    }

}
