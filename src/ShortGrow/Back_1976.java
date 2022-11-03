//Back_1976 여행 가자
//BFS

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1976 {

    static int N,M;
    static int[][] Graph;
    static Queue<Integer> queue;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Graph = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            queue.add(Integer.parseInt(st.nextToken()) - 1); //index 번호를 맞추기 위함
        }
        int start;
        int end = queue.poll();
        boolean ch = true;
        while(!queue.isEmpty()){
            start = end;
            end = queue.poll();
            if(start == end){
                continue;
            }
            if(!BFS(start,end)){
                ch = false;
                System.out.println("NO");
                break;
            }
        }
        if(ch) System.out.println("YES");

    }

    public boolean BFS(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] check = new int[N];

        while(!q.isEmpty()){
            int a = q.poll();
            check[a] = 1;
            for(int i = 0; i < N ; i++){
                if(Graph[a][i] == 1 && check[i] == 0){
                    if(i == end){
                        return true;
                    }
                    q.add(i);
                    check[i] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Back_1976().solution();
    }

}
