//Level1
//K번째 수
//22.03.11

import java.util.Arrays;

public class Level1_3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] copyArr = {};
        copyArr = Arrays.copyOfRange(array,2,4);
        for(int ans : copyArr)    System.out.println(ans);

        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = new int[commands.length];
        int[] copyArray = {};
        for(int i = 0 ; i< commands.length; i++){
            copyArray = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
            Arrays.sort(copyArray);
//            for(int cop : copyArray){
//                System.out.println(cop);
//            }
            answer[i] = copyArray[commands[i][2]-1];
            //System.out.println(answer[i]);
        }

    }
}

/*
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] copyArray = {};
        for(int i = 0 ; i< commands.length; i++){
            copyArray = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);  //받은 인덱스 범위로 추출
            Arrays.sort(copyArray);  //내림차순으로 정렬
            answer[i] = copyArray[commands[i][2]-1];
        }
        return answer;
    }
}
*/