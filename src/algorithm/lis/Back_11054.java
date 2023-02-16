//Back_11054 가장 긴 바이토닉 부분 수열
//LIS(DP)

package algorithm.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_11054 {


    static int N;
    static int[] Array,LDP,RDP;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Array = new int[N];
        LDP = new int[N];
        RDP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            Array[i] = Integer.parseInt(st.nextToken());
        }
        LDP[0] = 1;
        RDP[N-1] = 1;
        for(int i = 1; i < N; i++){
            int lmax = 1;
            for(int j = i-1; j >=0; j--){
                if(Array[i] > Array[j]){
                    lmax = Math.max(lmax, LDP[j]+1);
                }
            }
            LDP[i] = lmax;
        }
        for(int i = N-2; i >= 0; i--){
            int rmax = 1;
            for(int j = i+1; j <N; j++){
                if(Array[i] > Array[j]){
                    rmax = Math.max(rmax, RDP[j]+1);
                }
            }
            RDP[i] = rmax;
        }
        int answer = 0;
        for(int i = 0; i < N; i++){
            answer = Math.max(answer , LDP[i]+RDP[i]-1);
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_11054().solution();
    }

}
