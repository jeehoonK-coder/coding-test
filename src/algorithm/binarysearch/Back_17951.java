//Back_17951 흩날리는 시험지 속에서 내 평점이 느껴진거야
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_17951 {

    static int N,K;
    static int[] Array;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Array = new int[N];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
            System.out.println("Array[i] = " + Array[i]);
            sum += Array[i];
        }

        bw.write(binarySearch(sum) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int sum){
        int begin = 0, end = sum / K;
        int mid = 0, pivot = 0;
        int regionSum = 0, min = 0;
        int result = 0;
        while(begin <= end){
            pivot = (begin + end) >> 1;

            mid = 0;
            regionSum = 0;
            min = Integer.MAX_VALUE;
            for(int score : Array){
                regionSum += score;
                if(regionSum >= pivot){
                    min = Math.min(min, regionSum);
                    regionSum = 0;
                    mid++;
                }
            }
            if(mid >= K){
                result = min;
                begin = min + 1;
            }
            else{
                end = pivot -1;
            }

        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Back_17951().solution();
    }

}
