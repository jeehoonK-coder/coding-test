//Back_13458 시험 감독 (브론즈)
//수학

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_13458 {

    static long N,B,C;
    static long[] Array;


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Array = new long[(int)N];
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long answer = 0;
        for(long a : Array){
            answer++;
            a -= B;
            if(a <= 0) continue;
            answer += a / C;
            if( a % C != 0 ) answer++;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_13458().solution();
    }
}
