//Level1
//크레인 인형뽑기 게임 ( 2019 카카오 개발자 겨울 인턴쉽)
//22.03.22

package Level1;

import java.util.*;

public class Level1_11 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int N = board.length;
        List<Integer> result = new ArrayList<Integer>();
        for(int move : moves){
            for(int i = 0; i< N ; i++){
                if(board[i][move-1] != 0){
                    result.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        int answer = 0;
        while(true) {
            int ans = answer;
            for (int i = 0; i < result.size() - 1; i++) {
                if (result.get(i) == result.get(i + 1)) {
                    answer += 2;
                    result.remove(i);
                    result.remove(i);
                }
            }
            if(ans == answer){
                break;
            }
        }
        System.out.println(answer);
    }
}

//stack으로 푸는법
/*
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
 */
