//Level1
//[카카오인턴] 키패드 누르기

public class Level1_5 {
    public static void main(String[] args) {
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";
        String answer = "";
        int leftNum = 10, rightNum = 11;
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                leftNum = num;
            }
            else if(num == 3 || num == 6 || num == 9){
                answer +="R";
                rightNum = num;
            }
            else{
                if(checkHand(leftNum,rightNum,num, hand).equals("L")){
                    answer+="L";
                    leftNum = num;
                }
                else{
                    answer +="R";
                    rightNum = num;
                }
            }
        }
        System.out.println(answer);
    }

    private static String checkHand(int leftNum, int rightNum, int num, String hand){
        int[] rightPos = getPosition(rightNum);
        int[] leftPos = getPosition(leftNum);
        int[] numPos = getPosition(num);
        int rN = Math.abs(numPos[0]-rightPos[0])+Math.abs(numPos[1]-rightPos[1]);
        int lN = Math.abs(numPos[0]-leftPos[0])+Math.abs(numPos[1]-leftPos[1]);
        if(rN>lN){
            return "L";
        }
        else if(rN<lN){
            return "R";
        }
        else{
            return hand.equals("right") ? "R":"L";
        }
    }

    private static int[] getPosition(int number){
        int[][] keyPad= {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
        int[] pos = new int[2];
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j <3; j++){
                if(keyPad[i][j] == number){
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
}


/*
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftNum = 10, rightNum = 11;
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                leftNum = num;
            }
            else if(num == 3 || num == 6 || num == 9){
                answer +="R";
                rightNum = num;
            }
            else{
                if(checkHand(leftNum,rightNum,num, hand).equals("L")){
                    answer+="L";
                    leftNum = num;
                }
                else{
                    answer +="R";
                    rightNum = num;
                }
            }
        }
        return answer;
    }

    private String checkHand(int leftNum, int rightNum, int num, String hand){
        int[] rightPos = getPosition(rightNum);
        int[] leftPos = getPosition(leftNum);
        int[] numPos = getPosition(num);
        int rN = Math.abs(numPos[0]-rightPos[0])+Math.abs(numPos[1]-rightPos[1]);
        int lN = Math.abs(numPos[0]-leftPos[0])+Math.abs(numPos[1]-leftPos[1]);
        if(rN>lN){
            return "L";
        }
        else if(rN<lN){
            return "R";
        }
        else{
            return hand.equals("right") ? "R":"L";
        }
    }

    private int[] getPosition(int number){
        int[][] keyPad= {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
        int[] pos = new int[2];
        for(int i = 0 ; i < 4; i++){
            for(int j = 0 ; j <3; j++){
                if(keyPad[i][j] == number){
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
}
*/