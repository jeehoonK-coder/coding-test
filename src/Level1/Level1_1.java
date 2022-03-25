package Level1;//Level1
//완주하지 못한 선수

import java.util.*;

public class Level1_1 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
            }
        }
        if (answer.equals("")) answer = participant[completion.length];
        System.out.println(answer);
    }
}

/*
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i< completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[completion.length];
    }
}
*/