//Back_1477 휴게소 세우기
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1477 {
    /*
    static int M,N;
    static long[] SnackList;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        SnackList = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            SnackList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(SnackList);
        long max = SnackList[N-1];
        bw.write(binarySearch(max) + "" );
        bw.flush();
        bw.close();
        br.close();
    }

    public long binarySearch(long max) {
        long begin = 1, end = max;
        long mid = 0, pivot = 0;
        long result = 0;
        while(begin <= end){
            pivot = (begin+end) >> 1;
            mid = 0;
            for(long i : SnackList){
                mid += i / pivot;
            }
            if(mid >= M) {
                result = pivot;
                begin = pivot+1;
            }
            else end = pivot -1;
        }

        return result;
    }
    */
    public static void main(String[] args) throws Exception{
        new Back_1477().solution();
    }

}
