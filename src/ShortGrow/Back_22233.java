//Back_22233 가희와 키워드 (실버)
//문자열, 집합

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Back_22233 {

    static int N,M;
    static HashSet<String> set = new HashSet<>();

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i++){
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            String[] list = str.split(",");
            for(String s : list){
                set.remove(s);
            }
            bw.write(set.size()+"\n");
        }

        bw.flush();
    }



    public static void main(String[] args) throws Exception{
        new Back_22233().solution();
    }
}
