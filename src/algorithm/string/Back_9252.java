/**
 *  23.03.08
 *  Back_9252 LCS 2
 *  문자열, DP
 *
 *  1.No.9251에서 파생된 문제
 *  2.
 */


package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Back_9252 {

    static String S1, S2;
    static int[][] DP;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S1 = br.readLine();
        S2 = br.readLine();
        DP = new int[S1.length()+1][S2.length()+1];

        for(int i = 1; i <= S1.length(); i++){
            for(int j= 1; j <= S2.length(); j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1]+1;
                }
                else{
                    DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        int x = S1.length(), y = S2.length();
        while(x > 0 && y > 0){
            if( x == 0 || y == 0) break;

            if(DP[x-1][y] == DP[x][y]){
                x -= 1;
            }
            else if(DP[x][y-1] == DP[x][y]){
                y -= 1;
            }
            else{
                stack.push(S1.charAt(x-1));
                x--;
                y--;
            }
        }
        String answer = "";
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        bw.write(answer.length()+"\n");
        if(answer.length() != 0) bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_9252().solution();
    }
}
