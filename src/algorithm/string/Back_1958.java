/**
 *  23.03.10
 *  Back_1958 LCS 3
 *  문자열, DP
 *
 *  1. LCS 2의 3차원 버전 (No.9252)
 */

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_1958 {

    static String S1, S2, S3;
    static int[][][] DP;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S1 = br.readLine();
        S2 = br.readLine();
        S3 = br.readLine();
        DP = new int[S1.length()+1][S2.length()+1][S3.length()+1];
        int max = 0;
        for(int i = 1; i <= S1.length(); i++){
            for(int j= 1; j <= S2.length(); j++){
                for(int k = 1; k <= S3.length(); k++){
                    if(S1.charAt(i-1) == S2.charAt(j-1) && S2.charAt(j-1) == S3.charAt(k-1)){
                        DP[i][j][k] = DP[i-1][j-1][k-1] + 1;
                    }
                    else{
                        DP[i][j][k] = Math.max(DP[i][j][k-1], Math.max(DP[i-1][j][k],DP[i][j-1][k]));
                    }
                    max = Math.max(max, DP[i][j][k]);
                }

            }
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1958().solution();
    }
}
