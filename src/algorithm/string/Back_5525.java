/**
 *  23.03.05
 *  Back_5525 IOIOI (실버)
 *  문자열
 *
 *  1. IOI가 반복되는 것을 이용하여 O(n)안에 푸는 것이 포인트
 */


package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_5525 {

    static int N,M;
    static String S;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int answer = 0;
        int count = 0;
        for(int i = 1; i < M - 1; i++){
            if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;
                if(count == N){
                    count--;
                    answer++;
                }
                i++;
            }
            else{
                count = 0;
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_5525().solution();
    }
}
