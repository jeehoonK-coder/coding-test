//Back_14891 톱니바퀴
//구현, 시뮬레이션

package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_14891 {

    static int K,N,D;
    static int[][] Array = new int[4][8];


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                Array[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            turn(N,D);
        }
        int answer = 0;
        for(int i = 0; i< 4;i++){
            if(Array[i][0] == 1){
                answer += Math.pow(2,i);
            }
        }


        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void turn(int n, int d){
        boolean[] turning = new boolean[4];
        turning[0] = true;
        turning[1] = Array[0][2] == Array[1][6] ? true : false;
        turning[2] = Array[1][2] == Array[2][6] ? true : false;
        turning[3] = Array[2][2] == Array[3][6] ? true : false;
        int[] clock = new int[4];
        if(n == 1){
            clock[n-1] = d;
            for(;n <4; n++){
                if(!turning[n]){
                    clock[n] = d == 1 ? -1 : 1;
                    d = clock[n];
                }
                else{
                    break;
                }
            }
        }
        else if(n == 2){
            clock[n-1] = d;
            if(!turning[1]){
                clock[0] = d == 1 ? -1 : 1;
            }
            if(!turning[2]){
                clock[2] = d == 1 ? -1 : 1;
                d = clock[2];
                if(!turning[3]){
                    clock[3] = d == 1 ? -1 : 1;
                    d = clock[3];
                }
            }
        }
        else if(n == 3){
            clock[n-1] = d;
            if(!turning[3]){
                clock[3] = d == 1 ? -1 : 1;
            }
            if(!turning[2]){
                clock[1] = d == 1 ? -1 : 1;
                d = clock[1];
                if(!turning[1]){
                    clock[0] = d == 1 ? -1 : 1;
                    d = clock[0];
                }
            }
        }
        else if(n == 4){
            clock[n-1] = d;
            for(;n > 1; n--){
                if(!turning[n-1]){
                    clock[n-2] = d == 1 ? -1 : 1;
                    d = clock[n-2];
                }
                else{
                    break;
                }
            }
        }
        for(int i = 0; i < 4; i++){
            clock_turn(i,clock[i]);
        }
    }

    public void clock_turn(int n, int d){
        int[] temp = new int[8];
        if(d == 1){
            temp[0] = Array[n][7];
            for(int i = 1; i < 8; i++){
                temp[i] = Array[n][i-1];
            }
            Array[n] = temp;
        }
        else if(d == -1){
            temp[7] = Array[n][0];
            for(int i = 0; i < 7; i++){
                temp[i] = Array[n][i+1];
            }
            Array[n] = temp;
        }

    }



    public static void main(String[] args) throws Exception {
        new Back_14891().solution();
    }
}
