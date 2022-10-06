//Back_1915 가장 큰 정사각형
//DP dp[i][j]는 아래 칸들의 최솟값에 더하기 1한 것
//부분합과 완전탐색을 이용한 방법도 있지만 dp가 효율적임

package Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1915 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] square = new int[n][m];
        for(int i=0; i < n;i++){
            String[] str = br.readLine().split("");
            for(int j =0; j < m; j++){
                square[i][j] = Integer.parseInt(str[j]);
            }
        }
//        for(int i=0; i < m;i++){
//            for(int j =0; j < n; j++){
//                System.out.print(square[j][i]);
//            }
//            System.out.println();
//        }

        int[][] dp = new int[n][m];
        int answer = 0;
        for(int i=0; i < n;i++){
            for(int j =0; j < m; j++){
                if(i == 0 || j == 0) dp[i][j] = square[i][j];
                else if(square[i][j] == 0) dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) +1;

                }
                answer = Math.max(dp[i][j],answer);
            }
        }
        System.out.println(answer*answer);

    }


    public static void main(String[] args) throws Exception {
        new Back_1915().solution();
    }

}
