/**
 *  23.03.20
 *  Back_9663 N-Queen
 *  백트래킹
 *
 *  1. 1차원배열을 이용하여 체스판을 구현할 수 있다.
 *  2. 같은 위치에 있거나 차이가 열 번호 차이와 같으면 대각선상에 있는 것이기 때문에 돌아간다.
 */

package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back_9663 {

    static int N;
    static int Count = 0;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        //1차원 배열로 표현
        int[] board = new int[N];
        recursion(board, 0);

        bw.write(Count+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public void recursion(int[] board, int idx){
        if(idx == N){
            Count++;
            return;
        }
        for(int i = 0; i < N; i++){
            board[idx] = i;
            if(promising(board, idx)){
                recursion(board, idx+1);
            }
        }
    }

    public boolean promising(int[] board, int idx){
        for(int i = 0; i < idx; i++){
             if(board[i] == board[idx] || Math.abs(board[i] - board[idx]) == (idx - i)){
                 return false;
             }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Back_9663().solution();
    }
}
