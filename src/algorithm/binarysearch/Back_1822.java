//Back_1822 차집합 (실버)
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Back_1822 {

    static int N,M;
    static int[] NumA, NumB;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        NumA = new int[N];
        NumB = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            NumA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            NumB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(NumB);
        Arrays.sort(NumA);
        List<Integer> cGroup = new ArrayList<>();

        for(int i : NumA){
            if(binarySearch(i) == 0){
                cGroup.add(i);
            }
        }
        bw.write(cGroup.size()+"\n");
        for(int k : cGroup){
            bw.write(k+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int key){
        int begin = 0, end = M-1;
        int mid = 0, pivot = 0;

        if(NumB[begin] == key || NumB[M-1] == key) return 1;
        while(begin < end){
            pivot = (begin + end) >> 1;
            mid = NumB[pivot];
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
        new Back_1822().solution();
    }
}
