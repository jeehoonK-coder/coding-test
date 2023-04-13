/**
 *  23.04.12
 *  2023 KAKAO BLIND RECRUITMENT
 *  표현 가능한 이진트리
 *  level 3
 *
 *
 *  1. 재귀를 통해서 트리의 성질을 만족하는지 판단하는 문제 -> length / 2한 것이 root이므로 root의 leaf가 0일때 1인지를 판별
 *  -> root가 0일 경우 그 str에 1이 포함되는지를 찾아 바로 반환하면 더 빠르게 할 수 있다. (실행 결과 조금 준다.)
 */


package kakaopractice.blind2023;

public class No4 {

    public static void main(String[] args) {
        long[] numbers = {63,111,95};
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            String str = "";
            long number = numbers[i];
            while(number >= 2){
                str = (number % 2) + str;
                number /= 2;
            }
            str = number+str;
            str = addZero(str);
            int point = str.length()/2;
            if(str.charAt(point) == '0') answer[i] = 0;
            else{
                boolean ans = check(str, '1');
                if(ans) answer[i] = 1;
                else answer[i] = 0;
            }


        }

        for(int a : answer){
            System.out.println(a);
        }

    }

    private static String addZero(String str){
        int size = str.length();
        int binarySize = 1;
        int add = 2;
        while(binarySize < size){
            binarySize += add;
            add *= 2;
        }
        for(int i = 0; i < binarySize-size; i++){
            str = "0"+str;
        }
        return str;
    }

    private static boolean check(String str, char c){
        if(str.length() == 1){
            if(c == '0' && str.charAt(0) == '1') return false;
            else return true;
        }
        //root가 0일 경우 그 str에 1이 포함되는지를 찾아 바로 반환하면 더 빠르게 할 수 있다.
        if( c == '0' && str.contains("1")) return false;
        if( c == '0' && str.contains("1")) return true;

        int point = str.length()/2;
        char p = str.charAt(point);
        if(c == '0' && p == '1') return false;
        return check(str.substring(0,point), p) && check(str.substring(point+1), p);
    }

}
