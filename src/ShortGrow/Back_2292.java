//Back_2292 벌집 (브론즈)
//수학

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_2292 {

    static int N;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int n = 1;
        int count = 2;

        if(N == 1) bw.write(1+"");
        else{
            while(true){
                n = n+6*(count-1);
                if(n >= N) break;
                count++;
            }
            bw.write(count+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_2292().solution();
    }
}
