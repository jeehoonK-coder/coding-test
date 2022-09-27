//Back_2166 다각형의 면적
//다각형의 면적을 좌표로 구하는 방식 사용 (cf. 외적으로 한 사람도 있음)

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2166 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n+1];
        long[] y = new long[n+1];


        for(int i = 0; i < n ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[n] = x[0];
        y[n] = y[0];
        long front = 0;
        long back = 0;

        for(int i = 0; i < n; i++){
            front += x[i]*y[i+1];
            back += y[i]*x[i+1];
        }

        System.out.println(String.format("%.1f", Math.abs(front - back) / 2.0));

    }

    public static void main(String[] args) throws Exception{
        new Back_2166().solution();
    }


}
