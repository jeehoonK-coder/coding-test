//Back_2230 수 고르기
//투포인터

package algorithm.twopoint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_2230 {

    static int N,M;
    static int[] Array;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N];
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Array);
        int start = 0;
        int end = 1;
        int answer = Integer.MAX_VALUE;
        while(end < N){
            if(Array[end]-Array[start] < M){
                end++;
                continue;
            }
            if(Array[end]-Array[start] == M){
                answer = M;
                break;
            }
            answer = Math.min(answer, Array[end]-Array[start]);
            start++;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_2230().solution();
    }

}
