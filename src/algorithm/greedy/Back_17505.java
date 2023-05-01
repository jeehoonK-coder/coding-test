/**
 *  23.05.01
 *  Back_17505 링고와 순열
 *  그리디 알고리즘
 *
 *  1. 맨앞에 계속 넣으면서 개수를 넘지않게 조절하여 딱 맞춰서 진행
 *  2. 0번 index에 계속 추가하는 것은 N의 시간이 걸려 그냥 뒤에서부터 적기로 함 -> 시간초과 해결
 */

package algorithm.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_17505 {

    static int N;
    static long K;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        if ((N * (N - 1)) / 2 == K) for (int i = N; i >= 1; i--) bw.write(i+" ");
        else if(K == 0) for (int i = 1; i <= N; i++) bw.write(i+" ");
        else{
            List<Integer> list = new ArrayList<>();
            long count = 0;
            int i;
            for(i = 0; i < N; i++){
                if(count+i >= K){
                    list.add((int)(K-count), i+1);
                    count = K;
                    break;
                }
                else{
                    list.add(i+1);
                    count += i;
                }
            }
            if(count != K){
                bw.write(-1+"");
            }
            else{
                for(int k = list.size()-1; k >= 0; k--) {
                    bw.write(list.get(k)+" ");
                }
                if(i != N){
                    for(int k = i+1; k <N; k++){
                        bw.write(k+1+" ");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_17505().solution();
    }

}
