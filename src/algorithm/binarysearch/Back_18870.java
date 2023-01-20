//Back_18870 좌표 압축(실버)
//이분 탐색 (좌표압축?)

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_18870 {

    static int N;
    static int[] Array,Target;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Array = new int[N];
        Target = new int[N];
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
            Target[i] = Array[i];
        }
        Arrays.sort(Target);
        List<Integer> target = new ArrayList<>();
        target.add(Target[0]);
        for(int i = 1; i < N; i++){
            if(Target[i] != Target[i-1]) target.add(Target[i]);
        }
        for(int i : Array){
            bw.write(binarySearch(i,target)+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int key, List<Integer> target){
        int begin = 0, end = target.size();
        int mid = 0, pivot = 0;
        while(begin < end){
            pivot = (end + begin) >> 1;
            mid = target.get(pivot);
            if(mid >= key) end = pivot;
            else begin = pivot +1;
        }
        return begin;
    }

    public static void main(String[] args) throws Exception {
        new Back_18870().solution();
    }

}
