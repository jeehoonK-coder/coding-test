//Back_1477 휴게소 세우기
//이분 탐색
//Shelter배열에 0과 L을 추가로 넣어서 구현하면 N이 0일때와 1일때의 조건을 넣을 필요가 없다!!


package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1477 {

    static int N,M,L;
    static int[] Shelter;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        if(N==0){
            bw.write((int)Math.ceil(L / (double)(M+1)) +"");
        }
        else{
            Shelter = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                Shelter[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Shelter);
            bw.write(binarySearch(L) + "" );
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public int binarySearch(int max) {
        int begin = 1, end = max;
        int mid = 0, pivot = 0;
        int result = 0;
        while(begin <= end){
            pivot = (begin+end) >> 1;
            mid = 0;
            if(N == 1){
                mid += Math.ceil((L-Shelter[0]) / (double)pivot) - 1;
                mid += Math.ceil((Shelter[0]) / (double)pivot) - 1;
            }
            else{
                for(int i = 0; i < N; i++){
                    if(i == 0) {
                        mid += Math.ceil(Shelter[i] / (double)pivot) - 1;
                    }
                    else if(i == N-1) {
                        mid += Math.ceil((L-Shelter[i]) / (double)pivot) - 1;
                        mid += Math.ceil((Shelter[i] - Shelter[i-1]) / (double)pivot) - 1;
                    }
                    else mid += Math.ceil((Shelter[i] - Shelter[i-1]) / (double)pivot) - 1;
                }
            }
            if(mid > M) {
                begin = pivot+1;
            }
            else {
                result = pivot;
                end = pivot -1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        new Back_1477().solution();
    }

}
