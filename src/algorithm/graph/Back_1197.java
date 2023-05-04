/**
 *  23.05.05
 *  Back_1197 최소 스패닝 트리
 *  그래프, 최소 스패닝 트리
 */


package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_1197 {

    static int V,E;
    static PriorityQueue<int[]> PQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    static int[] parent;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        while(E-->0){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            PQ.add(new int[]{v1,v2,weight});
        }
        parent = new int[V+1];
        for(int i = 1; i < V+1; i++){
            parent[i] = i;
        }

        int answer = 0;
        while(!PQ.isEmpty()){
            int[] node = PQ.poll();
            int p1 = find(node[0]);
            int p2 = find(node[1]);
            if(p1 != p2){
                union(p1, p2);
                answer += node[2];
            }
        }

        bw.write(answer+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public int find(int idx){
        if(parent[idx] == idx) return idx;
        return parent[idx] = find(parent[idx]);
    }

    public void union(int idx1, int idx2){
        parent[idx1] = idx2;
    }

    public static void main(String[] args) throws Exception {
        new Back_1197().solution();
    }
}
