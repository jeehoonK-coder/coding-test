//Back_21921 블로그(실버)
//누적 합, 슬라이딩 윈도우

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_21921 {

    static int N,X;
    static int[] Array;


    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ;i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int temp;
        int start = 0;
        int count = 1;
        for(int i = 0; i < X; i++) max += Array[i];
        temp = max;
        for(int i = X; i < N; i++){
            temp -= Array[start];
            temp += Array[i];
            start++;
            if(temp > max){
                count = 1;
                max = temp;
            }
            else if(temp == max) count++;


        }
        if(max == 0) bw.write("SAD");
        else{
            bw.write(max+"\n");
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static void main(String[] args) throws Exception {
        new Back_21921().solution();
    }
}
