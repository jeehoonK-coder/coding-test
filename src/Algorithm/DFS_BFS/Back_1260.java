//Back_1260 DFS와 BFS (실버)
//

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1260 {

    boolean[] check;
    int n,m,start;
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        int[][] line = new int[n+1][n+1];
        check = new boolean[n+1];
        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a][b] = 1;
            line[b][a] = 1;
        }
        DFS(line,start);
        sb.append("\n");
        check = new boolean[n+1];
        BFS(line,start);
        System.out.println(sb);
    }

    public void DFS(int[][] line, int start){
        check[start] = true;
        sb.append(start+ " ");
        for(int i = 0; i <= n; i++){
            if(line[start][i] == 1 && !check[i]) DFS(line, i);
        }
    }

    public void BFS(int[][] line, int start){
        queue.add(start);
        check[start] = true;
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start+ " ");
            for(int i = 1; i<= n;i++){
                if(line[start][i] == 1 && !check[i]){
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1260().solution();
    }
}
