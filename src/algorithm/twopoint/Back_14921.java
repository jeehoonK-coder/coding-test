//Back_14921 용액 합성하기
//투 포인터

package algorithm.twopoint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_14921 {

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

        bw.write(twoPointSearch()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public int twoPointSearch(){
        int begin = 0, end = N-1;
        int mid = LiquidList[0] + LiquidList[N-1];
        while(begin < end){
            if( Math.abs(LiquidList[begin] + LiquidList[end]) < Math.abs(mid) ){
                mid = LiquidList[begin] + LiquidList[end];
            }

            if( Math.abs(LiquidList[end]) > Math.abs(LiquidList[begin])){
                end = end-1;
            }
            else begin = begin+1;
        }

        return mid;
    }


    public static void main(String[] args) throws Exception {
        new Back_14921().solution();
    }

}
