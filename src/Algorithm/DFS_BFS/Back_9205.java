//Back_9205 맥주 마시면서 걸어가기 (실버)
//

package Algorithm.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_9205 {

    int N,K;
    int[][] Array;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            Array = new int[65536][65536]; // +32768
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Array[a+32768][b+32768] = 1;
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                Array[a+32768][b+32768] = 2;
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            Array[a+32768][b+32768] = 1;


        }


        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Back_9205().solution();
    }
}
