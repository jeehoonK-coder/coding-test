//Back_14002 가장 긴 증가하는 부분 수열4
//DP

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_14002 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        int[][] dp = new int[n+1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i <= n; i++){
            boolean check = false;
            for(int j = i-2; j >=0; j--){
                if(number[j] < number[i-1] && dp[i][0] <= dp[j+1][0]+1){
                    dp[i][0] = dp[j+1][0]+1;
                    dp[i][1] = j+1;
                    check = true;
                }
            }
            if(!check){
                dp[i][0] = 1;
                dp[i][1] = i;
            }
        }
        int max = 0;
        int maxIdx = 0;
        for(int i = 1; i <= n ;i++){
            if(max <= dp[i][0]){
                max = dp[i][0];
                maxIdx = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < max; i++){
            stack.push(number[maxIdx-1]);
            maxIdx = dp[maxIdx][1];
        }
        sb.append(max).append('\n');
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Back_14002().solution();
    }
}
