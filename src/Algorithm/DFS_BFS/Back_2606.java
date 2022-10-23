//Back_2606 바이러스 (실버)
//BFS

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2606 {

    int[][] array;
    int[] check;
    int n,k;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];
        check = new int[n+1];
        StringTokenizer st;
        for(int i = 0; i < k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a][b] = array[b][a] = 1;
        }
        BFS();
        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer += check[i];
        }
        System.out.println(answer-1);
    }

    public void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = 1;
        while(!q.isEmpty()){
            int a = q.poll();
            for(int i = 1; i <= n; i++){
                if(array[a][i] == 1 && check[i] != 1){
                    q.add(i);
                    check[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_2606().solution();
    }

}
