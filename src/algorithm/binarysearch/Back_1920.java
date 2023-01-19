//Back_1920 수 찾기 (실버)
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1920 {

    static int N,M;
    static int[] Array;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Array = new int[N];
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Array);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            bw.write(binarySearch(Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int key){
        int begin = 0, end = N;
        int mid = 0, pivot = 0;
        while(begin < end){
            pivot = (end + begin) >> 1;
            mid = Array[pivot];

            if(mid == key) return 1;
            else if(mid > key) end = pivot;
            else begin = pivot +1;
        }

        return 0;
    }


    public static void main(String[] args) throws Exception {
        new Back_1920().solution();
    }
}
