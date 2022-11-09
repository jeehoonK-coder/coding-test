//Back_8979 올림픽 (실버)
//구현,정렬(정렬사용안함)

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_8979 {

    static int N,K;
    static int[][] country;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        country = new int[N][3];

        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1;

            for(int j = 0; j < 3; j++){
                country[n][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int[] target = country[K-1];

        for(int i = 0; i < N ; i++){
            if(i == K-1) continue;
            int[] medal = country[i];
            if(medal[0] > target[0]){
                count++;
                continue;
            }
            else if(medal[0] == target[0] && medal[1] > target[1]){
                count++;
                continue;
            }
            else if(medal[0] == target[0] && medal[1] == target[1] && medal[2] > target[2]){
                count++;
                continue;
            }
        }

        bw.write(String.valueOf(count+1));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Back_8979().solution();
    }

}
