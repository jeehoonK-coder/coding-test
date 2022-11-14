//Back_1238 파티
//다익스트라

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Town implements Comparable<Town> {
    int end;
    int weight;

    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Town arg0) {
        return weight - arg0.weight;
    }
}

public class Back_1238 {

    static int N,M,X;
    static final int INF = 987654321;
    static ArrayList<ArrayList<Town>> arrList, reverse_arrList;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
        reverse_arrList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            reverse_arrList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Town(end, weight));
            reverse_arrList.get(end).add(new Town(start, weight));
        }

        int[] dist1 = Dijkstra(arrList);
        int[] dist2 = Dijkstra(reverse_arrList);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        bw.write(ans+"");
        bw.flush();
    }

    public static int[] Dijkstra(ArrayList<ArrayList<Town>> a) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Town town : a.get(cur)) {
                    if (!check[town.end] && dist[town.end] > dist[cur] + town.weight) {
                        dist[town.end] = dist[cur] + town.weight;
                        pq.add(new Town(town.end, dist[town.end]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        new Back_1238().solution();
    }

}
