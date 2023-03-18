/**
 *  23.03.18
 *  Back_2133 타일 채우기
 *  DP
 *
 *  1 : 0
 *  2 : 3
 *  3 : 0
 *  4 : 4
 *
 *  1. 점화식 - DP[i] = DP[i-2]*3 + DP[i-4]*2 + DP[i-6]*2 + DP[i-8]*2 .....
 */


package algorithm.dynamicprogramming;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_2133 {

    static int N;
    static int[] DP;
    static int[] count = {0,0,3,0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1];
        if(N <= 3){
            bw.write(count[N]+"");
        }
        else{
            DP[1] = 0;
            DP[2] = 3;
            DP[3] = 0;
            for(int i = 4; i < N+1; i++){
                if(i%2 == 0) DP[i] = 2;
                DP[i] += DP[i-2]*3;
                int k = 2;
                while((i - k*2) > 0){
                    DP[i] += DP[i-k*2]*2;
                    k++;
                }
            }
            bw.write(DP[N]+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_2133().solution();
    }
}
