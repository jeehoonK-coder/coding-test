//Back_10815 숫자카드 (실버)
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_10815 {

    static int N,M;
    static int[] NumA, NumB;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        NumA = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            NumA[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        NumB = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            NumB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(NumA);
        for(int i : NumB){
            if(binarySearch(i) == 0) bw.write("0 ");
            else bw.write("1 ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int key){
        int begin = 0, end = N-1;
        int mid = 0, pivot = 0;

        if(NumA[begin] == key || NumA[N-1] == key) return 1;
        while(begin < end){
            pivot = (begin + end) >> 1;
            mid = NumA[pivot];
            if(mid < key){
                begin = pivot+1;
            }
            else if(mid == key) return 1;
            else{
                end = pivot;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_10815().solution();
    }
}
