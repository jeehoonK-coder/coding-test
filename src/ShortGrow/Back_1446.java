//Back_1446 지름길 (실버)
//DP

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1446 {

    static int N,D;
    static int[][] Array;

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        Array = new int[N][3];
        int[] dp = new int[D+1];
        for(int i = 0; i < D+1; i++){
           dp[i] = i;
        }
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            Array[i][0] = Integer.parseInt(st.nextToken());
            Array[i][1] = Integer.parseInt(st.nextToken());
            Array[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Array, ((o1, o2) -> {
            if(o1[0] == o2[0]) return Integer.compare(o1[1],o2[1]);
            else{
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        Queue<int[]> q = new LinkedList<>();
        for(int[] arr : Array){
            q.add(arr);
        }

        int[] a = q.poll();

        for(int i = 0; i < D+1 ; i++){
            if(i > 0)
                dp[i] = Math.min(dp[i], dp[i-1] +1);

            while(a != null && a[0] == i ){
                if(a[1] <= D){
                    dp[a[1]] = Math.min(dp[a[1]], dp[i] + a[2]);
                }
                a = q.poll();

            }
        }

        System.out.println(dp[D]);
    }


    public static void main(String[] args) throws Exception{
        new Back_1446().solution();
    }
}
