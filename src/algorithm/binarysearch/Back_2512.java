//Back_2512 예산 (실버)
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_2512 {

    static int N,Total;
    static int[] Num;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Num[i] = Integer.parseInt(st.nextToken());
        }
        Total = Integer.parseInt(br.readLine());
        Arrays.sort(Num);
        bw.write(binarySearch(Total)+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int key){
        int begin = 1, end = Total;
        int mid = 0, pivot = 0;
        int result = 0;
        int total = 0;
        for(int i = 0; i < N; i++){
            total += Num[i];
        }
        if(Total >= total) return Num[N-1];
        while(begin < end){
            pivot = (begin + end) >> 1;
            mid = 0;
            for(int i : Num){
                if(i > pivot) mid += (pivot);
                else mid += i;
            }
            if(mid <= Total){
                result = pivot;
                begin = pivot+1;
            }
            else{
                end = pivot ;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Back_2512().solution();
    }

}
