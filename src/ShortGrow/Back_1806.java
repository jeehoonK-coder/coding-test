//Back_1806 부분합
// 누적합, 투 포인터

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_1806 {

    static int N,S;
    static int[] Array;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        Array = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }

        int count = N+1;
        int start = 0;
        int end = 0;
        int sum = Array[0];

        while(true){
            if(sum >= S){
                count = Math.min(count, end-start+1);
                sum -= Array[start];
                start++;
            }
            else{
                end++;
                if(end == N) break;
                sum += Array[end];
            }

        }
        if(count == N+1) count = 0;
        bw.write(count+"");
        bw.flush();
    }


    public static void main(String[] args) throws Exception{
        new Back_1806().solution();
    }
}
