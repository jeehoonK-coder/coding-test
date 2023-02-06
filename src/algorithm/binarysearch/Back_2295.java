//Back_2295 세 수의 합
//이분 탐색

package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Back_2295 {

    static int N;
    static long[] List;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        List = new long[N];
        for(int i = 0; i < N; i++){
            List[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(List);

        bw.write(Search() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public long Search() {
        long target = 0L;
        long needSum = 0L;

        for(int i = N-1; i >= 1; i--){
            target = List[i];
            for(int j = i-1; j >= 0; j--){
                if(target / 3 > List[j]) continue;
                needSum = target - List[j];
                int begin = 0, end = j;
                while(begin <= end){
                    long sum = List[begin] + List[end];
                    if(sum > needSum) end--;
                    else if(sum < needSum) begin++;
                    else return target;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Back_2295().solution();
    }

}
