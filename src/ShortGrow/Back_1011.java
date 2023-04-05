/**
 *  23.04.05
 *  Back_1011 Fly me to the Alpha Centauri
 *  수학
 *
 *  1. 점화식 느낌으로 따져보면서 풀어야 하는 문제
 *  2. 계속 찾아봐서 규칙을 찾아야 한다. 잘모르겟다
 *
 *  cf) https://st-lab.tistory.com/79
 */


package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1011 {

    static int T;
    static long X,Y;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Long.parseLong(st.nextToken());
            Y = Long.parseLong(st.nextToken());
            long distance = Y-X;
            long max = (long) Math.floor(Math.sqrt(distance));
            long answer = 0;
            if(distance == max*max) answer = max*2-1;
            else if(distance - (max*max) > max) answer = max*2+1;
            else answer = max*2;

            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_1011().solution();
    }
}
