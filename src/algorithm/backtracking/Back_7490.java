/**
 *  23.05.12
 *  Back_7490 0 만들기
 *  백트래킹
 */


package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Back_7490 {

    static int T,N;
    static char[] Exp;
    static List<String> List;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            List = new ArrayList<>();
            Exp = new char[N];
            combination(Exp, 1, N);
            bw.write("\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    public void combination(char[] Exp, int start, int end) throws Exception{
        if(start == end){
            if(result(Exp, end)){
                for(int i = 1; i<=N; i++){
                    if(i != N){
                        bw.write(i+""+Exp[i]);
                    }
                    else{
                        bw.write(i+"\n");
                    }
                }
            }
            return;
        }

        Exp[start] = ' ';
        combination(Exp, start+1, end);
        Exp[start] = '+';
        combination(Exp, start+1, end);
        Exp[start] = '-';
        combination(Exp, start+1, end);
    }

    public boolean result(char[] Exp, int N) {
        int sum = 0;
        for(int i=N; i>1; i--) {
            int num = i;
            if(Exp[i-1] == '+') {
                sum+=num;
            } else if(Exp[i-1] == '-') {
                sum-=num;
            } else {
                int result = i;
                int cnt = 1;
                while(Exp[i-1] == ' ') {
                    i--;
                    result = i*(int)Math.pow(10, cnt++)+result;
                }
                if(i-1 >=1 && Exp[i-1] == '-') {
                    sum-=result;
                } else {
                    sum+=result;
                }
            }
        }
        if(Exp[1] != ' ') {
            sum+=1;
        }
        if(sum == 0) return true;
        else return false;
    }

    public static void main(String[] args) throws Exception{
        new Back_7490().solution();
    }
}
