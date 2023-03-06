/**
 *  23.03.06
 *  Back_5582 공통 부분 문자열
 *  문자열, DP
 *
 *  1. DP를 이용하는 것이 포인트
 */


package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_5582 {

    static String S1, S2;
    static int[][] DP;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S1 = br.readLine();
        S2 = br.readLine();
        DP = new int[S1.length()+1][S2.length()+1];
        int max = 0;
        for(int i = 1; i <= S1.length(); i++){
            for(int j= 1; j <= S2.length(); j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1]+1;
                    max = Math.max(max, DP[i][j]);
                }
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_5582().solution();
    }

}