//Back_2805 나무 자르기(실버)
//이분 탐색 (sort를 안해도 되는 상황이면 안하는것이 빠름)

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_2805 {

    static int N,M;
    static long[] Tree;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Tree);
        long max = Tree[N-1];

        bw.write(binarySearch(max) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public long binarySearch(long max){
        long begin = 0, end = max;
        long mid = 0, pivot = 0;

        long result = 0;
        while(begin < end){
            pivot = (begin + end) >> 1;
            mid = 0;
            for(long h : Tree){
                if(h > pivot) mid += h - pivot;
            }

            if(mid >= M){
                result = pivot;
                begin = pivot+1;
            }
            else{
                end = pivot;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Back_2805().solution();
    }

}
