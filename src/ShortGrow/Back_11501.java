//Back_11501 주식 (실버)
//그리디 알고리즘

package ShortGrow;

import java.io.*;
import java.util.StringTokenizer;

public class Back_11501 {

    static int N;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N ;i++){
            int k = Integer.parseInt(br.readLine());
            int[] array = new int[k];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < k;j++){
                array[j] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            long answer = 0;
            for(int a = k-1; a >=0 ; a--){
                if(max < array[a]){
                    max = array[a];
                }
                if(max > array[a]){
                    answer += (max-array[a]);
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Back_11501().solution();
    }

}
