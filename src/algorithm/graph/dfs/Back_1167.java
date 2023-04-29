/**
 *  23.03.14
 *  Back_1167 트리의 지름
 *  DFS
 *
 *  1. 한 정점에서 제일 긴 정점을 구한다음 다시 그 정점에서 DFS를 돌려서 제일 긴 길이를 구하면 그것이 지름이 된다.
 *  cf) 평면에 (트리를 이루는) 많은 점이 있다고 가정합시다. 이때 임의의 점에서 dfs를 돌린다면 지름을 그릴 수 있는 점 중 '하나'를 찾을 수 있습니다. 여기에서 또 한번 dfs를 돌린다면 지름의 나머지 한 점을 찾을 수 있고, 이것이 트리의 "지름"이 되는 것입니다.
 */


package algorithm.graph.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_1167 {

    static class Node {
        int number;
        int weight;

        Node(int number, int weight){
            this.number = number;
            this.weight = weight;
        }
    }

    static int V;
    static List<Node>[] NodeList;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        NodeList = new List[V+1];
        for(int i = 1; i < V+1; i++){
            NodeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken()), weight = 0;
            while(next != -1){
                weight = Integer.parseInt(st.nextToken());
                NodeList[num].add(new Node(next, weight));
                next = Integer.parseInt(st.nextToken());
            }
        }
        int[] check = new int[V+1];
        check[1] = 1;
        int[] one = DFS(1,check,0);
        check = new int[V+1];
        check[one[0]] = 1;
        int[] two = DFS(one[0], check, 0);

        bw.write(two[1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int[] DFS(int i, int[] check, int weight) {
        int max = weight;
        int num = i;
        for(Node n : NodeList[i]){
            if(check[n.number] == 0){
                check[n.number] = 1;
                int[] m = DFS(n.number, check, weight+n.weight);
                if(max < m[1]){
                    max = m[1];
                    num = m[0];
                }
                check[n.number] = 0;
            }
        }
        return new int[]{num,max};
    }

    public static void main(String[] args) throws Exception {
        new Back_1167().solution();
    }
}
