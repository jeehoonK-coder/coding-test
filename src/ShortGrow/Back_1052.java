//Back_1052 물병
//비트마스킹 (최소원소 찾기 : 가장 오른쪽에 잇는 1찾기 N & (-N))

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1052 {

    static int N,K;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = 0;
        while(Integer.bitCount(N) > K) {
            answer += N & (-N);
            N += N & (-N);
        }

        System.out.println(answer);
    }



    public static void main(String[] args) throws Exception {
        new Back_1052().solution();
    }
}
