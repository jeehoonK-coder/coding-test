//Back_9935 문자열 폭발
//문자열, 스택

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back_9935 {

    static String Str,Target;
    static Stack<Character> Stack = new Stack<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Str = br.readLine();
        Target = br.readLine();
        /*
        //단순한 replace이용은 메모리초과 발생
        while(true){
            int length = Str.length();
            Str = Str.replace(Target,"");
            int after = Str.length();
            if(length == after) break;
        }
        if(Str.length() == 0) bw.write("FRULA");
        else bw.write(Str);
        */

        int str_len = Str.length();
        int target_len = Target.length();
        for(int i = 0; i < str_len; i++){
            char c = Str.charAt(i);
            Stack.add(c);

            if(Stack.size() >= target_len){
                boolean bomb = true;
                for(int j = 0; j < target_len; j++){
                    if(Stack.get(Stack.size() - target_len +j) == Target.charAt(j)) continue;
                    bomb = false;
                }
                if(bomb){
                    for(int j = 0; j < target_len; j++)
                        Stack.pop();
                }
            }
        }
        if(Stack.isEmpty()) bw.write("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : Stack) {
                sb.append(c);
            }
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws Exception {
        new Back_9935().solution();
    }
}
