/**
 *  23.03.31
 *  Back_1005 ACM Craft
 *  위상 정렬
 *
 *  1. 끝나는 시간이 빠른 것을 기준으로 재정렬을 하여 위상정렬을 한다.
 */


package algorithm.topologicalsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_1005 {

    static int T,N,K;
    static int[] Indegree, BuildTime;
    static List<Integer>[] BuildList;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Indegree = new int[N+1];
            BuildTime = new int[N+1];
            BuildList = new List[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                BuildTime[i] = Integer.parseInt(st.nextToken());
                BuildList[i] = new ArrayList<>();
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Indegree[b]++;
                BuildList[a].add(b);
            }

            int goal = Integer.parseInt(br.readLine());
            int answer = topologicalSort(goal);
            bw.write(answer+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int topologicalSort(int goal){
        //건물번호, 시간
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(int i = 1; i <= N; i++){
            if(Indegree[i] == 0) {
                if(i == goal){
                    return BuildTime[i];
                }
                queue.add(new int[]{i,BuildTime[i]});
            }
        }

        while(!queue.isEmpty()){
            int[] build = queue.poll();
            for(int n : BuildList[build[0]]){
                if(--Indegree[n] == 0){
                    if(n == goal){
                        return build[1] + BuildTime[n];
                    }
                    queue.add(new int[]{n, build[1] + BuildTime[n]});
                }
            }

        }

        return -1;
    }



    public static void main(String[] args) throws Exception {
        new Back_1005().solution();
    }
}
