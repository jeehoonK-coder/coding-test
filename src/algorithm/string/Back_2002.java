/**
 *  23.03.11
 *  Back_2002 추월 (실버)
 *  문자열, 집합?
 *
 *  1. List 생성 후 순서가 안맞을때마다 삭제하면서 파악
 */

package algorithm.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Back_2002 {

    static int N;
    static List<String> StrList = new ArrayList<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StrList.add(br.readLine());
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(!StrList.get(i-count).equals(str)){
                count++;
                StrList.remove(str);
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_2002().solution();
    }
}
