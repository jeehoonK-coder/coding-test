/**
 *  23.03.07
 *  Back_17609 회문
 *  문자열, 투포인터
 *
 *  1. 투포인터를 이용한다음 유사회문은 재귀로 판독
 */


package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_17609 {

    static String S;
    static int N;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            S = br.readLine();
            bw.write(palindrome(S, true) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public int palindrome(String str, boolean check){
        int start = 0;
        int end = str.length()-1;
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else{
                int a = 2,b = 2;
                if(check && str.charAt(start+1) == str.charAt(end)){
                    String s = str.substring(0,start) + str.substring(start+1);
                    a = palindrome(s, false);
                }
                if(check && str.charAt(start) == str.charAt(end - 1)){
                    String s = str.substring(0, end) + str.substring(end+1);
                    b = palindrome(s, false);
                }
                if( a == 0 || b == 0) return 1;
                return 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_17609().solution();
    }
}
