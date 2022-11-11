//Back_1786 찾기
//KMP 알고리즘

package Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Back_1786 {

    static String Str, Target;
    static int[] Pi;
    static List<Integer> List = new ArrayList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Str = br.readLine();
        Target = br.readLine();
        Pi = new int[Target.length()];
        getPi(Target);

        KMP(Str,Target);
        bw.write(List.size() + "\n");
        for(int a : List){
            bw.write(a+1 + " ");
        }
        bw.flush();
    }

    public void KMP(String str, String target){
        int strLen = str.length();
        int targetLen = target.length();
        int j = 0;
        for(int i = 0; i < strLen;i++){
            while(j > 0 && str.charAt(i) != target.charAt(j)){
                j = Pi[j-1];
            }
            if(str.charAt(i) == target.charAt(j)){
                if(j == targetLen-1){
                    List.add(i-targetLen+1);
                    j = Pi[j];
                }
                else{
                    j++;
                }
            }

        }
    }

    public void getPi(String str) {
        int strLen = str.length();
        int j = 0;
        for(int i = 0; i < strLen; i++){
            if(i == 0) continue;
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = Pi[j-1];
            }
            if(str.charAt(i) == str.charAt(j)){
                Pi[i] = ++j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Back_1786().solution();
    }

}
