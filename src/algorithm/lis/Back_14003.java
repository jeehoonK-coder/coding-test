//Back_14003 가장 긴 증가하는 부분 수열 5
//이분 탐색

package algorithm.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_14003 {

    static int N, Index;
    static int[] Array,L,P;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        P = new int[N];
        L = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(L, Integer.MIN_VALUE);
        L[1] = Array[0];
        P[0] = 1;
        Index = 1;
        for(int i = 1; i < N; i++){
            P[i] = binarySearch(Array[i]);
        }
        bw.write(Index+"\n");
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--){
            if(P[i] == Index) {
                stack.add(Array[i]);
                Index--;
            }
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int binarySearch(int target){
        int begin = 0, end = Index;
        int mid = target, pivot = 0;
        if(Index == 1 && L[Index] > target){
            L[Index] = target;
            return Index;
        }
        if(L[Index] < target){
            L[Index + 1] = target;
            Index++;
            return Index;
        }
        while(begin < end){
            pivot = (begin+end) >> 1;
            if(mid > L[pivot] && mid <= L[pivot+1]){
                L[pivot+1] = mid;
                return pivot+1;

            }
            else if(mid > L[pivot]){
                begin = pivot +1;
            }
            else if(mid <= L[pivot]){
                end = pivot;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_14003().solution();
    }
}
