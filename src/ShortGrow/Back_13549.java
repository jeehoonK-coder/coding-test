//Back_13549 숨바꼭질 3
//BFS, 다익스트라

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_13549 {

    static int N,K;


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = Dijkstra(N,K);
        bw.write(answer+"");
        bw.flush();
    }

    public int Dijkstra(int start,int end){
        int[] dijkstra = new int[1000001];
        Arrays.fill(dijkstra,Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dijkstra[start] = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            if(a == end){
                return dijkstra[end];
            }
            if(a*2 <= 100000 && dijkstra[a*2] > dijkstra[a]){
                dijkstra[a*2] = dijkstra[a];
                q.add(a*2);
            }

            if(a-1 >= 0 && dijkstra[a-1] > dijkstra[a] +1){
                dijkstra[a-1] = dijkstra[a]+1;
                q.add(a-1);
            }
            if(a+1 <= 100000 && dijkstra[a+1] > dijkstra[a] +1){
                dijkstra[a+1] = dijkstra[a]+1;
                q.add(a+1);
            }

        }
        return dijkstra[end];
    }

    public static void main(String[] args) throws Exception {
        new Back_13549().solution();
    }

}
