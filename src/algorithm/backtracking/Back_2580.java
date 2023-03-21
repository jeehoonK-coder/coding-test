/**
 *  23.03.21
 *  Back_2580 스도쿠
 *  백트래킹
 *
 *  1. 처음에는 0이 한줄에 한 두개만 있는줄알고 1개인 것을 찾아서 남은 빈자릴 채워넣는 식으로 구현을 함 (가로채우기, 세로채우기, 네모채우기)
 *      -> 한줄에 0이 2,3개씩 있을 수 있으므로 백트래킹으로 찾아야 함
 *  2. 백트래킹을 이용하여 0일때마다 들어갈 수 있는지 체크를 하고 재귀를 돌린다.
 */


package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back_2580 {

    static int[][] Sudoku = new int[9][9];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                Sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        resursive(0,0);

        br.close();
    }

    public void resursive(int x, int y) throws Exception {

        if(y == 9){
            resursive(x+1, 0);
            return;
        }

        if(x == 9){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    bw.write(Sudoku[i][j]+" ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }

        if(Sudoku[x][y] == 0){
            for(int i = 1; i <= 9; i++){
                if(promising(x,y,i)){
                    Sudoku[x][y] = i;
                    resursive(x,y+1);
                }
            }
            Sudoku[x][y] = 0;
            return;
        }

        resursive(x,y+1);

    }

    public boolean promising(int x, int y, int num){
        for(int i = 0; i < 9; i++){
            if(Sudoku[x][i] == num){
                return false;
            }
        }

        for(int i = 0; i < 9; i++){
            if(Sudoku[i][y] == num){
                return false;
            }
        }

        int set_row = (x / 3) * 3;	// value가 속한 3x3의 행의 첫 위치
        int set_col = (y / 3) * 3;	// value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (Sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        new Back_2580().solution();
    }
}
