//Back_12919 A와 B 2
//문자열, 재귀

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_12919 {

    static String S,T;
    static int N,Answer;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        N = S.length();
        System.out.println(S.substring(0,S.length()-1));
        stringChange(T,T.length(),0);
        System.out.println(Answer);
    }
    public void stringChange(String s, int depth, int dir){
        if(depth == N){
            if(dir == 0 && s.equals(S) ){
                Answer = 1;
            }
            else if(dir == 1){
                String reverse = "";
                for(int i = s.length() -1; i >= 0; i--){
                    reverse += s.charAt(i);
                }
                if(reverse.equals(S)){
                    Answer =1;
                }
            }
        }
        else{
            if(dir == 0){
                if(s.charAt(0) == 'B'){
                    stringChange(s.substring(1),depth-1,1);
                }
                if(s.charAt(s.length()-1) == 'A'){
                    stringChange(s.substring(0,s.length()-1),depth-1,0);
                }
            }
            else if(dir == 1){
                if(s.charAt(0) == 'A'){
                    stringChange(s.substring(1),depth-1,1);
                }
                if(s.charAt(s.length()-1) == 'B'){
                    stringChange(s.substring(0,s.length()-1),depth-1,0);
                }
            }

        }
    }
    //앞에서 한것 시간초과
    /*
    public void stringChange(String s, int depth){
        if(depth == N){
            if(s.equals(T)){
                Answer = 1;
            }
        }
        else{
            stringChange(s+'A',depth+1);
            String reverse = "";
            s += 'B';
            for(int i = s.length() -1; i >= 0; i--){
                reverse += s.charAt(i);
            }
            stringChange(reverse,depth+1);
        }
    }
     */

    public static void main(String[] args) throws Exception{
        new Back_12919().solution();
    }
}
