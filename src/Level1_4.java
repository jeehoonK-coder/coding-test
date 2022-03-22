//Level1
//약수의 개수와 덧셈
//22.03.12
//제곱인 것을 어떤방식으로 알아야 하는가

public class Level1_4 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int answer = 0;
        double number;
        for(int i = left ; i < right+1; i++){
            number = Math.sqrt(i);
            if( (int)number == number){
                answer -= i;
            }
            else{
                answer += i;
            }
        }
        System.out.println(answer);
    }
}

/*
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        double number;
        for(int i = left ; i < right+1; i++){
            number = Math.sqrt(i);
            if( (int)number == number){
                answer -= i;
            }
            else{
                answer += i;
            }
        }
        return answer;
    }
}
 */