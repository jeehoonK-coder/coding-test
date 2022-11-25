//Back_14719 빗물
//구현

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14719 {

    static int H,W;
    static int[] Array;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        Array = new int[W];

        st = new StringTokenizer(br.readLine());
        int maxR = 0;
        for(int i = 0; i < W; i++) {
            Array[i] = Integer.parseInt(st.nextToken());
            maxR = Math.max(maxR,Array[i]);
        }

        int maxL = 0;
        int answer = 0;
        for(int i = 0; i < W; i++){
            if(i == W -1) break;
            if(maxL > Array[i] && maxR > Array[i]) {
                int min = Math.min(maxL,maxR);
                answer += min - Array[i];
            }
            else{
                maxL = Math.max(maxL,Array[i]);
                if(maxR == Array[i]){
                    maxR = Array[i+1];
                    for(int j = i+1; j < W; j++){
                        maxR = Math.max(maxR,Array[j]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Back_14719().solution();
    }
}
