//Back_11053 가장 긴 증가하는 부분 수열 (실버)
//LIS (DP)

package algorithm.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_11053 {

    static int N;
    static int[] Array,DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        DP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        DP[0] = 1;
        for(int i = 1; i < N; i++){
            int max = 1;
            for(int j = i-1; j >=0; j--){
                if(Array[i] > Array[j]){
                    max = Math.max(max, DP[j]+1);
                }
            }
            DP[i] = max;
        }
        int answer = 0;
        for(int cnt : DP){
            answer = Math.max(answer, cnt);
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_11053().solution();
    }

}
