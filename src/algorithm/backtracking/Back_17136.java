/**
 *  23.04.02
 *  Back_17136 색종이 붙이기
 *  백트래킹, DFS
 *
 *  1. 백트래킹과 DFS를 같이하는 이와 같은 상황일때는 좌표를 옮기는 재귀를 사용하면 풀린다.
 *  2. 모든좌표를 순서대로 하나씩 찾아보면서 DFS를 돌리는 상황에서 사용한다.
 */


package algorithm.backtracking;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_17136 {

    static int[][] Array = new int[10][10];
    static int[] Paper = {0,5,5,5,5,5};
    static int Count = Integer.MAX_VALUE;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                Array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0,0,0);
        if(Count != Integer.MAX_VALUE) bw.write(Count+"");
        else bw.write(-1+"");

        bw.flush();
        bw.close();
        br.close();
    }

    public void backTracking(int x, int y, int count){
        if(x >= 9 && y > 9){
            Count = Math.min(Count, count);
            return;
        }
        if(Count <= count){
            return;
        }
        if(y > 9){
            backTracking(x+1,0,count);
            return;
        }

        if(Array[x][y] == 1){
            for(int i = 5; i >= 1; i--){
                if(check(x,y,i)){
                    setPaper(x,y,i,i+1);
                    Paper[i]--;
                    backTracking(x,y+1, count+1);
                    Paper[i]++;
                    setPaper(x,y,i,1);
                }
            }
        }
        else{
            backTracking(x,y+1, count);
        }


    }

    public boolean check(int x, int y, int size) {
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if( i >= 10 || j >= 10){
                    return false;
                }
                if(Array[i][j] == 1){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        if(Paper[size] >= 1) return true;
        else return false;
    }

    public void setPaper(int x, int y, int size, int paper){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                Array[i][j] = paper;
            }
        }
    }




    public static void main(String[] args) throws Exception {
        new Back_17136().solution();
    }
}
