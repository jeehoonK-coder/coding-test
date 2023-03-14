/**
 *  23.03.13
 *  Back_12100 2048 (Easy)
 *  구현, 브루트포스, 백트래킹
 *
 *  1. 오,왼,위,아래 방향의 슬라이드를 다구현한 후 백트래킹을 이용하여 구현
 */


package ShortGrow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_12100 {

    static int N;
    static int[][] Array;
    static int MAX = 0;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Array = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] direct = new int[5];
        game(Array,direct,0 );

        bw.write(MAX+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void game(int[][] arr, int[] direct, int idx){
        if(idx==5 ){
            int[][] temp = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    temp[i][j] = arr[i][j];
                }
            }
            for(int i = 0; i < 5; i++){
                if(!move(temp, direct[i])){
                    break;
                }
            }
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    MAX = Math.max(MAX, temp[i][j]);
                }
            }
            return;
        }

        direct[idx] = 0;
        game(arr, direct,idx+1);
        direct[idx] = 1;
        game(arr, direct,idx+1);
        direct[idx] = 2;
        game(arr, direct,idx+1);
        direct[idx] = 3;
        game(arr, direct,idx+1);

    }

    // 0 : 위 , 1 : 오 , 2 : 아래 , 3 : 왼 슬라이드하는 방향
    public boolean move(int[][] array,  int dir){
        boolean check = false;
        if(dir == 0){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N-1; j++){
                    if(array[j][i] == 0) continue;
                    int d = 1;
                    while(true){
                        if(array[j][i] == array[j+d][i]){
                            check = true;
                            array[j][i] *= 2;
                            array[j+d][i] = 0;
                            break;
                        }
                        else if(array[j+d][i] != 0){
                            break;
                        }
                        d++;

                        if(j+d >= N) break;
                    }
                }
                for(int j = 0; j < N-1; j++){
                    if(array[j][i] == 0){
                        int d = 1;
                        while(true){
                            if(array[j+d][i] != 0){
                                check = true;
                                array[j][i] = array[j+d][i];
                                array[j+d][i] = 0;
                                break;
                            }
                            d++;
                            if(j+d >= N) break;
                        }
                    }
                }
            }
        }

        else if(dir == 2){
            for(int i = 0; i < N; i++){
                for(int j = N-1; j > 0; j--){
                    if(array[j][i] == 0) continue;
                    int d = 1;
                    while(true){
                        if(array[j][i] == array[j-d][i]){
                            check = true;
                            array[j][i] *= 2;
                            array[j-d][i] = 0;
                            break;
                        }
                        else if(array[j-d][i] != 0){
                            break;
                        }
                        d++;
                        if(j-d < 0) break;
                    }
                }
                for(int j = N-1; j > 0; j--){
                    if(array[j][i] == 0){
                        int d = 1;
                        while(true){
                            if(array[j-d][i] != 0){
                                check = true;
                                array[j][i] = array[j-d][i];
                                array[j-d][i] = 0;
                                break;
                            }

                            d++;
                            if(j-d < 0) break;
                        }
                    }
                }
            }
        }

        else if(dir == 1){
            for(int i = 0; i < N; i++){
                for(int j = N-1; j > 0; j--){
                    if(array[i][j] == 0) continue;
                    int d = 1;
                    while(true){
                        if(array[i][j] == array[i][j-d]){
                            check = true;
                            array[i][j] *= 2;
                            array[i][j-d] = 0;
                            break;
                        }
                        else if(array[i][j-d] != 0){
                            break;
                        }
                        d++;
                        if(j-d < 0) break;
                    }
                }
                for(int j = N-1; j > 0; j--){
                    if(array[i][j] == 0){
                        int d = 1;
                        while(true){
                            if(array[i][j-d] != 0){
                                check = true;
                                array[i][j] = array[i][j-d];
                                array[i][j-d] = 0;
                                break;
                            }
                            d++;
                            if(j-d < 0) break;
                        }
                    }
                }
            }
        }
        else if(dir == 3){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N-1; j++){
                    if(array[i][j] == 0) continue;
                    int d = 1;
                    while(true){
                        if(array[i][j] == array[i][j+d]){
                            check = true;
                            array[i][j] *= 2;
                            array[i][j+d] = 0;
                            break;
                        }
                        else if(array[i][j+d] != 0){
                            break;
                        }
                        d++;
                        if(j+d >= N) break;
                    }
                }
                for(int j = 0; j < N-1; j++){
                    if(array[i][j] == 0){
                        int d = 1;
                        while(true){
                            if(array[i][j+d] != 0){
                                check = true;
                                array[i][j] = array[i][j+d];
                                array[i][j+d] = 0;
                                break;
                            }
                            d++;
                            if(j+d >= N) break;
                        }
                    }
                }
            }
        }

        return check;

    }

    public static void main(String[] args) throws Exception {
        new Back_12100().solution();
    }
}
