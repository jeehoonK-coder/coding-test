/**
 *  23.03.08
 *  Back_9251 LCS
 *  문자열, DP
 *
 */

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_9251 {

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
                }
                else{
                    DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
                }
                max = Math.max(max, DP[i][j]);
            }
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_9251().solution();
    }

}
