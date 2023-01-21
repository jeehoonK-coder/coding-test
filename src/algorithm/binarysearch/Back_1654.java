//Back_1654 랜선 자르기 (실버)
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1654 {

    static int K,N;
    static int[] Array;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Array = new int[K];
        for(int i = 0; i < K; i++){
            Array[i] = Integer.parseInt(br.readLine());
        }
        long max = 0;
        for(int i = 0; i < K; i++){
            max = Math.max(max, Array[i]);
        }
        bw.write(binarySearch(max) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public long binarySearch(long max){
        long begin = 0, end = max+1;
        long mid = 0, pivot = 0;

        while(begin < end){
            pivot = (begin+end) >> 1;
            mid = 0;
            for(int i : Array){
                mid += i / pivot;
            }
            if(mid < N) end = pivot;
            else begin = pivot + 1;
        }
        return begin - 1;
    }

    public static void main(String[] args) throws Exception {
        new Back_1654().solution();
    }
}
