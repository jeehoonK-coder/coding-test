/**
 *  23.05.03
 *  Back_25794 초콜릿과 나이트 게임
 *  애드-혹
 *
 *  1. 그냥 규칙찾아서 구현
 */

package algorithm.adhoc;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_25794 {

    static int X,Y;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        if(X == Y){
            int[] sameX = {X, X, X, -X, -X, -X, X};
            int[] sameY = {X, -X, -X,-X,-X, X,X};
            bw.write(7+"\n");
            int x = 0;
            int y = 0;
            for(int i = 0; i < sameX.length; i++){
                x += sameX[i];
                y += sameY[i];
                bw.write(x+" "+y+"\n");
            }
        }
        else if(X == 0 || Y == 0){
            int a = Math.max(X,Y);
            int[] zeroX = {0,a,a,0,0,-a,0};
            int[] zeroY = {a,0,0,-a,-a,0,a};
            bw.write(7+"\n");
            int x = 0;
            int y = 0;
            for(int i = 0; i < zeroX.length; i++){
                x += zeroX[i];
                y += zeroY[i];
                bw.write(x+" "+y+"\n");
            }
        }
        else{
            int[] diffX = {-Y, X, Y, Y, X, -Y, X ,-X ,Y ,-X, -Y, -Y, -X, Y, X};
            int[] diffY = {X, -Y, X, -X, Y, -X, -Y, -Y, -X, Y, -X, X, -Y, X, Y};
            bw.write(15+"\n");
            int x = 0;
            int y = 0;
            for(int i = 0; i < diffX.length; i++){
                x += diffX[i];
                y += diffY[i];
                bw.write(x+" "+y+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Back_25794().solution();
    }
}
