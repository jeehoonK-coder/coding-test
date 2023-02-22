//Back_1629 곱셈 (실버)
//분할 정복

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1629 {

    static long A,B,C;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        bw.write(pow(A,B)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public long pow(long A, long exponent){
        if(exponent == 1){
            return A % C;
        }
        long temp = pow(A, exponent/2);
        if(exponent % 2 == 1){
            return (temp * temp % C) * A % C;
        }
        return temp * temp % C;
    }


    public static void main(String[] args) throws Exception {
        new Back_1629().solution();
    }
}
