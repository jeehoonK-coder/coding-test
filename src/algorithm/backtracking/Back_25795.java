/**
 *  23.05.02
 *  예쁜 초콜릿과 숫자놀이
 *  백트래킹, 재귀 , DP도 가능
 *
 *  1.올바른 괄호 문자열의 조건과 일치함 -> 이것을 활용하여 재귀를 돌려 구현
 */

package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_25795 {

    static int N,a,b,c;
    static int Score = 0;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursive(0,a,N,N);
        bw.write(Score+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void recursive(int len, long score, int white, int black){
        if(len == 2*N){
            Score = Math.max(Score, (int)score);
            return;
        }
        if(white == black){
            recursive(len+1, (score + b) % 100000, white -1, black);
        }
        else if(white == 0){
            recursive(len+1, (score * c) % 100000, white, black -1);
        }
        else if(white < black && white > 0){
            recursive(len+1, (score + b) % 100000, white -1, black);
            recursive(len+1, (score * c) % 100000, white, black -1);
        }

    }

    public static void main(String[] args) throws Exception {
        new Back_25795().solution();
    }
}
