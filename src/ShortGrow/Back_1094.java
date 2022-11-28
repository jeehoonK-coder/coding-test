//Back_1094 막대기 (실버)
//비트마스킹

package ShortGrow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_1094 {

    static int X;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        int answer = 0;
        //비트마스킹 느낌 76ms
        /*
        int bitNumber = 64;
        while( X != bitNumber){
            bitNumber = bitNumber >> 1;
            if(bitNumber > X) continue;
            else if(bitNumber < X){
                answer++;
                X -= bitNumber;
            }
        }
        System.out.println(++answer);
        */

        //2진법 1의 개수 80ms
        for(int i = 0; i<=6; i++){
            if((X & (1<<i)) == Math.pow(2,i)) answer += 1;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Back_1094().solution();
    }
}
