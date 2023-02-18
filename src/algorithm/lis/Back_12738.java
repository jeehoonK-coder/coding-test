//Back_12738 가장 긴 증가하는 부분 수열 3
//이분 탐색
//No.12015랑 똑같다. 배열 원소의 범위가 마이너스가 있어 DP배열의 초기값을 음수로 잡음

package algorithm.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_12738 {
    static int N, Index;
    static int[] Array,DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        DP = new int[N+1];
        Arrays.fill(DP, Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        DP[1] = Array[0];
        Index = 1;
        for(int i = 1; i < N; i++){
            binarySearch(Array[i]);
        }
        bw.write(Index+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void binarySearch(int target){
        int begin = 0, end = Index;
        int mid = target, pivot = 0;
        if(Index == 1 && DP[Index] > target){
            DP[Index] = target;
            return;
        }
        if(DP[Index] < target){
            DP[Index + 1] = target;
            Index++;
            return;
        }
        while(begin < end){
            pivot = (begin+end) >> 1;
            if(mid > DP[pivot] && mid <= DP[pivot+1]){
                DP[pivot+1] = mid;
                break;
            }
            else if(mid > DP[pivot]){
                begin = pivot +1;
            }
            else if(mid <= DP[pivot]){
                end = pivot;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_12738().solution();
    }

}
