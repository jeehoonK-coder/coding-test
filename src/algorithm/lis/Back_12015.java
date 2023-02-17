//Back_12015 가장 긴 증가하는 부분 수열 2
//이분 탐색
//이것은 LIS의 길이를 구하는 것이지 구성요소까지 구하는 것은 아니다.

package algorithm.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_12015 {
    static int N, Index;
    static int[] Array,DP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        DP = new int[N+1];
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
        new Back_12015().solution();
    }
}
