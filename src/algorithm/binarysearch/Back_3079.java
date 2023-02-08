//Back_3079 입국 심사
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_3079 {

    static int N,M;
    static int[] Array;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Array = new int[N];
        long max = 0;
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(br.readLine());
            max = Math.max(Array[i],max);
        }
        bw.write(binarySearch(max) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public long binarySearch(long max) {
        long begin = 0, end = max*M;
        long mid = 0, pivot = 0;
        long result = 0;
        while(begin <= end){
            pivot = begin + ((end-begin) / 2);
            mid = 0;
            for(int i : Array){
                mid += pivot / i;
            }
            if(mid >= M){
                result = pivot;
                end = pivot - 1;
            }
            else{
                begin = pivot + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Back_3079().solution();
    }
}
