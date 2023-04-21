//Back_2644 촌수계산 (실버)
//DFS (BFS로도 풀수있고 인접리스트로도 가능)
//List<List<Integer>> list = new ArrayList<>();

package algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2644 {

    static int n,k,A,B;
    static int[][] array;
    static int[] check;
    static int answer = -1;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];
        check = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a][b] = 1;
            array[b][a] = -1;
        }

        check[A] = 1;
        DFS(check, A,B,0);
        System.out.println(answer);
    }

    public void DFS(int[] check, int a, int b, int depth){
        if(a == b) answer = depth;
        for(int i = 1; i <= n; i++){
            if(array[a][i] == 1 || array[a][i] == -1){
                if(check[i] != 1){
                    check[i] = 1;
                    DFS(check,i,b,depth+1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_2644().solution();
    }
}
