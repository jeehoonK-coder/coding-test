/**
 *  23.04.17
 *  Back_20055 컨베이어 벨트 위의 로봇
 *  구현, 시뮬레이션
 *
 *  1. 문제 이해가 어려웠다..
 *  2. 컨베이어 벨트를 배열로 구현한뒤 그냥 문제대로 구현
 */

package algorithm.implementation;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_20055 {

    static int N, K;
    static int[] Array, Robot;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Array = new int[2*N];
        Robot = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        while(true){
            //회전
            int temp = Array[2*N-1];
            int pre;
            for(int i = 0; i < 2*N; i++){
                pre = Array[i];
                Array[i] = temp;
                temp = pre;

            }

            for(int i = N-1; i >=0; i--){
                if(i == N-1 && Robot[i] == 1) Robot[i] = 0;
                if(Robot[i] == 1){
                    Robot[i+1] = 1;
                    Robot[i] = 0;
                }
            }

            //2번
            for(int i = N-2; i >= 0; i--){
                if(i == N-2 && Robot[i] == 1 && Array[N-1] > 0) {
                    Array[N-1]--;
                    Robot[i] = 0;
                }
                if(Robot[i] == 1 && Array[i+1] > 0 && Robot[i+1] != 1){
                    Robot[i+1] = 1;
                    Robot[i] = 0;
                    Array[i+1]--;
                }
            }
            //3번
            if(Array[0] > 0 && Robot[0] == 0){
                Robot[0] = 1;
                Array[0]--;
            }
            int c = 0;
            for(int i = 0; i < 2*N; i++){
                if(Array[i] == 0) c++;
            }
            if(c >= K) break;
            count++;

        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Back_20055().solution();
    }

}
