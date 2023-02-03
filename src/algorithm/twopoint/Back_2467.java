//Back_2467 용액
//투 포인터 (이진탐색으로도 가능)

package algorithm.twopoint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_2467 {

    static int N;
    static int[] LiquidList;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        LiquidList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            LiquidList[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(twoPointSearch());
        bw.flush();
        bw.close();
        br.close();
    }

    public String twoPointSearch(){
        int begin = 0, end = N-1;
        int mid = LiquidList[0] + LiquidList[N-1];
        int left = LiquidList[0], right = LiquidList[N-1];
        while(begin < end){
            if( Math.abs(LiquidList[begin] + LiquidList[end]) < Math.abs(mid) ){
                mid = LiquidList[begin] + LiquidList[end];
                left = LiquidList[begin];
                right = LiquidList[end];
            }

            if( Math.abs(LiquidList[end]) > Math.abs(LiquidList[begin])){
                end = end-1;
            }
            else begin = begin+1;
        }

        return left+" "+right;
    }


    public static void main(String[] args) throws Exception {
        new Back_2467().solution();
    }
}
