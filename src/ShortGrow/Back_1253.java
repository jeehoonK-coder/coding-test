//Back_1253 좋다
//정렬, 이분탐색

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1253 {

    static int N;
    static int[] A;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;

        for(int i = 0; i < N; i++){
            int findNumber = A[i];
            int start = 0;
            int end = N-1;
            int sum = 0;

            while(start < end){
                sum = A[start] + A[end];
                if(sum == findNumber){
                    if(start == i){
                        start++;
                    }
                    else if(end == i){
                        end--;
                    }
                    else{
                        count++;
                        break;
                    }
                }
                else if(sum > findNumber){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        bw.write(count+"");
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        new Back_1253().solution();
    }
}
