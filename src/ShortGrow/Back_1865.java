//Back_1865 웜홀
//벨만-포드

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_1865 {

    static class Edge{
        int s;
        int e;
        int t;

        Edge(int s, int e, int t){
            this.s = s;
            this.e = e;
            this.t = t;
        }
    }

    static int TC,N,M,W;
    static ArrayList<Edge> EdgeList = new ArrayList<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());
        while(TC-->0){
            EdgeList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                EdgeList.add(new Edge(s,e,t));
                EdgeList.add(new Edge(e,s,t));
            }
            for(int i = 0; i < W; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                EdgeList.add(new Edge(s,e,-t));
            }

            int[] dist = new int[N+1];
//            Arrays.fill(dist, Integer.MAX_VALUE);
//            dist[5] = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < EdgeList.size(); j++){
                    Edge edge = EdgeList.get(j);
                    if(dist[edge.e] > dist[edge.s] + edge.t){
                        dist[edge.e] = dist[edge.s] + edge.t;
                    }
                }
            }
            boolean check = true;
            for(int j = 0; j < EdgeList.size(); j++){
                Edge edge = EdgeList.get(j);
                if(dist[edge.e] > dist[edge.s] + edge.t){
                    bw.write("YES\n");
                    check = false;
                    break;
                }
            }
            if(check) bw.write("NO\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1865().solution();
    }

}
